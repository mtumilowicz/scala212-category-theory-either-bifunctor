/**
  * Created by mtumilowicz on 2019-01-09.
  */
class FunctiorialEither[X, Y](val either : Either[X, Y]) {
  def bimap[X1, Y1](first: X => X1, second: Y => Y1): Either[X1, Y1] = either.map(second).swap.map(first).swap
}
