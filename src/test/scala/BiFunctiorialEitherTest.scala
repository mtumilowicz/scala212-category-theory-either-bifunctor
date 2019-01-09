import org.scalatest.{FunSuite, Matchers}

/**
  * Created by mtumilowicz on 2019-01-09.
  */
class BiFunctiorialEitherTest extends FunSuite with Matchers {

  implicit def toBiFunctorialEither[X, Y](either: Either[X, Y]) = new BiFunctiorialEither(either)

  test("testBimap") {
    Right(1).map(_ * 2) should be (Right(2))
    Left[String, Integer]("a").map(_ * 2) should be (Left("a"))
  }

  test("testMap") {
    Right[Integer, String]("a").bimap(_ * 2, _ + " mapped") should be (Right("a mapped"))
    Left[Integer, String](1).bimap(_ * 2, _ + " mapped") should be (Left(2))
  }

}
