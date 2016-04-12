import rx.lang.scala.Observable

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val justString: Observable[String] = Observable.just("I'm just a string.")

val fromIterable = Observable.from(List(1, 2, 3))
  .subscribe(i => println("onNext: " + i))

val fromFuture = Observable.from(Future {
  Thread.sleep(1000)
  "Completed my long computation"
})

fromFuture
  .subscribe(t => println("onNext: " + t),
    e => println("onError: " + e.getMessage),
    () => println("onComplete.")
  )

Observable.empty
  .subscribe(t => println("onNext: This will never be called"),
    e => println("onError: this will never be called. " + e.getMessage),
    () => println("onComplete.")
  )

val errorObservable = Observable.error(new Exception("Life is hard."))
  .subscribe(t => println("onNext: " + t),
    e => println("onError: " + e.getMessage),
    () => println("onComplete. This will never be called.")
  )

val numbers: Observable[Int] = Observable.from(0 to 3)
numbers.subscribe(i => println(i))

val stringOddNumbers: Observable[String] = ???
stringOddNumbers.subscribe(i => println(i))

stringOddNumbers.toBlocking.last
