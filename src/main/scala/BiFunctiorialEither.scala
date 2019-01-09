/**
  * Created by mtumilowicz on 2019-01-09.
  */
class BiFunctiorialEither[X, Y](val either: Either[X, Y]) {
  // either.map(second).swap.map(first).swap
  def bimap[X1, Y1](first: X => X1, second: Y => Y1): Either[X1, Y1] = either match {
    case Left(x) => Left(first(x))
    case Right(y) => Right(second(y))
  }
}
