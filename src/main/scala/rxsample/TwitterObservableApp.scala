package rxsample

case class Tweet(user: String, tweet: String)

object TwitterObservableApp extends App {

  TwitterObservable()

    /*
    * logic here
    * */

    .subscribe(t => ???)
}
