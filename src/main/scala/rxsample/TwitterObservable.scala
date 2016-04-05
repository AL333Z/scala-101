package rxsample

import com.typesafe.config.ConfigFactory
import rx.lang.scala.{Observable, Subscription}
import twitter4j.auth.AccessToken
import twitter4j.{Status, StatusAdapter, TwitterStreamFactory}

/**
  * Utils that opens a stream to Twitter feeds, using twitter4j apis and exposing an Observable.
  *
  * See http://www.nurkiewicz.com/2014/01/turning-twitter4j-into-rxjavas.html
  */
object TwitterObservable {

  def apply(): Observable[Status] =
    Observable { subscriber =>

      // config twitter4j
      val twitterStream = new TwitterStreamFactory().getInstance()
      twitterStream.setOAuthConsumer(CretentialsUtils.appKey, CretentialsUtils.appSecret)
      twitterStream.setOAuthAccessToken(new AccessToken(CretentialsUtils.accessToken, CretentialsUtils.accessTokenSecret))

      // add a listener that forwards the events through the observable
      twitterStream.addListener(
        new StatusAdapter() {

          override def onStatus(status: Status): Unit = subscriber.onNext(status)

          override def onException(ex: Exception): Unit = subscriber.onError(ex)
        }
      )

      twitterStream.sample() // start the upstream

      // returning a subscription, so if the user of the API cancel the subscription, the stream shuts down gracefully
      Subscription {
        twitterStream.cleanUp()
      }
    }

}

object CretentialsUtils {
  val config = ConfigFactory.load()
  val appKey: String = config.getString("appKey")
  val appSecret: String = config.getString("appSecret")
  val accessToken: String = config.getString("accessToken")
  val accessTokenSecret: String = config.getString("accessTokenSecret")
}
