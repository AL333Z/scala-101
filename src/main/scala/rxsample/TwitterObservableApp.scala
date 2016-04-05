package rxsample

case class Tweet(user: String, tweet: String)

object TwitterObservableApp extends App {

  TwitterObservable()
    .filter(s => s.getLang == "en")
    .map(s => Tweet(s.getUser.getScreenName, s.getText))
    .doOnNext(t => println(t))
    .toBlocking.last

}
