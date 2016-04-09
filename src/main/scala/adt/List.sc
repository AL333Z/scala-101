

/*
 Scala Lists are quite similar to arrays which means, all the elements of a list have the same type but there are two
 important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment.
 Second, lists represent a linked list whereas arrays are flat. The type of a list that has elements of type T is written as List[T].
 */


//eq operator test identity
val a = List(1, 2, 3)
val b = List(1, 2, 3)

a.eq(a)
b.eq(b)
a.eq(b)

// == test same content.... what in java?
a == b
a == a
b == b


//Nil lists are identical, even of different types... why?
val nil1: List[String] = Nil
val nil2: List[Int] = Nil
nil1 == Nil
nil1.eq(Nil)
nil2 == Nil
nil2.eq(Nil)
nil1 == nil2
nil1.eq(nil2)

//Lists can be accessed via head and tail
a.head == 1
a.tail == List(2, 3)

//Lists can be accessed by position
a(0) == 1
a(1) == 2


//List are immutable
val c = a.filterNot(v => v == 2)
a == List(1, 2, 3)


//Useful operators on List: length, reverse, filter, map

a.length == 3
a.reverse
a.filter(v => v == 1)
a.map(_ * 2)
a.map(v => v * 2)

//Lists can be reduced with a mathematical operation
a.reduceLeft(_ + _)
a.reduceRight(_ + _)
a.reduceLeft((acc, v) => acc + v)

//Foldleft is like reduce, but with an explicit starting value
a.foldLeft(5)(_ + _)

//Lists reuse their tails

val d = 4 :: a
val e = 5 :: d
val f = 6 :: e


d.tail eq a
e.tail eq d
f.tail eq e




