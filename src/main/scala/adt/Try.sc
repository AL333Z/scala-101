import scala.util.{Failure, Success, Try}

//Try is used to exception handling
/*Like Option Type Try is a wrapper around the value returned by a computation. Concrete values
can be Successful and Failure*/

val a = 1
val b = 0

val failureDivision = Try(a / b)
val successDivision = Try(b / a)

//Most idiomatic way to use Try abstraction is like Collection
// map, filer etc.. operator are defined

val map = successDivision.map(_ * 2)
val filter = successDivision.filter(_ % 2 == 0)

/* In Failure case return value is always None
 */

val mapOnFailure: Try[Int] = failureDivision.map(_ * 2)


//You can check for Failure or Success value
val isSuccess = successDivision.isSuccess
val isFailure = failureDivision.isFailure

/*You can pattern match over Try abstraction
 */

successDivision match {
  case Success(something) => true
  case Failure(e) => false
}

//Try abstractions are composable

val flatMap = successDivision.flatMap(zero => Try(7 / (zero * 5)))


















