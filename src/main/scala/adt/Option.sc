/*If you have worked with Java at all in the past,
it is very likely that you have come across a NullPointerException
at some time (other languages will throw similarly named errors in such a case).
Usually this happens because some method returns null when you were not expecting
it and thus not dealing with that possibility in your client code. A value of null
is often abused to represent an absent optional value.

Scala tries to solve the problem by getting rid of null values
altogether and providing its own type for representing optional values,
i.e. values that may be present or not: the Option[A] trait.

Option[A] is a container for an optional value of type A. If the value of type A is present, the Option[A] is an instance of Some[A], containing the present value of type A. If the value is absent, the Option[A] is the object None.
*/


val someValue = Some("I am wrapped in something")

val nullValue = None

null == None
someValue.get == "I am wrapped in something"


//Having this function

def maybeWillReturnSomething(flag: Boolean): Option[String] = {
  if (flag) Some("Result") else None
}

//We have represented null with None
val a = maybeWillReturnSomething(true)
val b = maybeWillReturnSomething(false)

//b.get
a.get


//Using getOrElse we can provide a default value ("No value")
// the optional argument (None) does not exist:

b.getOrElse("DefaultValue")

//To check if an option has a value you can use isEmpty or isDefinied

a.isEmpty
b.isEmpty

a.isDefined
b.isDefined


//Option can also be used with pattern matching:

a match {
  case Some(value) => value == "Result"
}

//An alternative for pattern matching is performing collection style operations. This is possible because
// an option could be looked at as a collection with either one or zero elements.
//One of these operations is map.
// this operation allows to map the inner value to a different type
// while preserving the option

val someNum: Option[Int] = Some(2)
val result: Option[Double] = someNum.map(_ * 2.5)

val none: Option[Int] = None
val result2: Option[Int] = none.map(v => v * 3)

//Note that the type of result1 is now Option[Double], thanks to the scala type inference.
result.get == 5
result2 == None



//Another operation is fold. this operation will extract the value from the option,
// or provide a default if the value is None

someNum.fold(0)(_ * 3)
none.fold(0)(_ * 3)


