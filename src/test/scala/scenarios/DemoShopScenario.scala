package scenarios

import config.BaseHelpers.thinkTimer
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object DemoShopScenario {
  def scnDemoShop: ScenarioBuilder = {
    scenario(scenarioName = "Demo Shop Scenario").during(10.minutes) {
      exec(flushHttpCache)
        .exec(flushSessionCookies)
        .exitBlockOnFail(
          group("Home Page") {
            exec(api.home.demoShopHome())
              .exec(thinkTimer())
          }
            .group("Category Tables") {
              exec(api.category.openCategory("tables"))
                .exec(thinkTimer())
            }
            .group("Open Table") {
              exec(api.product.getTable())
                .exec(thinkTimer())
            }
            .group("Add Table To Cart") {
              exec(api.addToCart.addToCart("${tableID}"))
                .exec(thinkTimer())
            }

            .group("Category Chairs") {
              exec(api.category.openCategory("chairs"))
                .exec(thinkTimer())
            }
            .group("Open Chair") {
              exec(api.product.getChair())
                .exec(thinkTimer())
            }
            .group("Add Chair To Cart") {
              exec(api.addToCart.addToCart("${chairID}"))
                .exec(thinkTimer())
            }

            .group("Cart") {
              exec(api.cart.getCart())
                .exec(thinkTimer())
            }
            .group("Checkout") {
              exec(api.checkout.checkout())
                .exec(thinkTimer())
            }
            .group("Place Order") {
              exec(api.checkout.placeOrder())
                .exec(thinkTimer())
            }
        )
    }
  }
}
