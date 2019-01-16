import org.scalatest.{FunSuite, Matchers}

/**
  * Created by mtumilowicz on 2019-01-09.
  */
class BiFunctiorialEitherTest extends FunSuite with Matchers {

  implicit def toBiFunctorialEither[X, Y](either: Either[X, Y]) = new BiFunctiorialEither(either)

  test("bimap test") {
    Right[Integer, String]("a").bimap(_ * 2, _ + " mapped") should be(Right("a mapped"))
    Left[Integer, String](1).bimap(_ * 2, _ + " mapped") should be(Left(2))
  }

}
