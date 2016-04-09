package adt

object List {

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]


  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(h, t) => h + sum(t)
  }


  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }


  def tail[T](ts: List[T]): List[T] = ts match {
    case Nil => sys.error("init of empty list")
    case Cons(x, xs) => xs
  }


  def foldLeft[T, B](l: List[T], z: B)(f: (B, T) => B): B = {
    l match {
      case Nil => z
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }

  }

  def foldRight[T, B](l: List[T], z: B)(f: (T, B) => B): B =
    l match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sumFoldLeft(ts: List[Int]): Int = {
    foldLeft(ts, 0)(_ + _)
  }

  def productFoldLeft(ts: List[Int]): Int = {
    foldLeft(ts, 0)(_ * _)
  }

  def map[A, B](l: List[A])(f: A => B): List[B] = {
    foldRight(l, Nil: List[B])((elem: A, b: List[B]) => Cons(f(elem), b))
  }


  def filter[A](l: List[A])(predicate: A => Boolean): List[A] =
    foldRight(l, Nil: List[A])((h: A, t: List[A]) => if (predicate(h)) Cons(h, t) else t)


}
