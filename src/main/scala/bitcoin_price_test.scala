import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._

class abcTest.scala extends WordSpec with Matchers with ScalatestRouteTest {

// It cointains the test to check whether the localhost server is up and all routes are reachable or not.
// The test file can be upgraded by writing tests on the repsonse expected. For it we can mock the call
// and can provide the same inputs always to get the expected output. As I am new to Scala, I will do it later. 

  "The service" should {

    "return a Accepted status code on calling lastWeekPrice from root path" in {
      Get("/lastWeekPrice") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }

    "return a Accepted status code on calling lastMonthPrice from root path" in {
      Get("/lastMonthPrice") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }

    "return a Accepted status code on calling customPrice with parameters from root path" in {
      Get("/customPrice?start=2018-12-20&end=2018-12-28") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }

    "return a Accepted status code on calling movingAverage with parameters from root path" in {
      Get("/movingAverage?start=2018-12-15&end=2018-12-28&n=2") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }

    "return a Accepted status code on calling predictPrice from root path" in {
      Get("/predictPrice") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.Accepted
      }
    }

    "return a ClientError status code on calling predictPrice1 from root path" in {
      Get("/predictPrice1") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.ClientError
      }
    }

    "return a ClientError status code on calling moving average without parameters from root path" in {
      Get("/movingAverage") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.ClientError
      }
    }

    "return a ClientError status code on calling moving average wrong parameters from root path" in {
      Get("/movingAverage?start=2018-125&end=2018-12-28&n=2") ~> Route.seal(route) ~> check {
        status shouldEqual StatusCodes.ClientError
      }
    }
  }
}