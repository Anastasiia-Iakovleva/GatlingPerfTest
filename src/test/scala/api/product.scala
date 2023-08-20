package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object product {
  val productUrl = "products/${productURL}";
  val getProductIdRegex = "name=\"current_product\" value=\"(\\d*)\">";
  val getProductPriceRegex = "<td class=\"price-value .+>\\n.*\\$(\\d+.\\d+).*</td>";

  def getTable(): ChainBuilder = {
    exec(
      http("Open Random Table")
        .get(baseUrl + productUrl)
        .headers(headers_0)
        .check(regex(getProductIdRegex)
          .find(0)
          .saveAs("tableID"))
        .check(regex(getProductPriceRegex)
          .find(0)
          .saveAs("tablePrice"))
    )
  }

  def getChair(): ChainBuilder = {
    exec(
      http("Open Random Chair")
        .get(baseUrl + productUrl)
        .headers(headers_0)
        .check(regex(getProductIdRegex)
          .find(0)
          .saveAs("chairID"))
        .check(regex(getProductPriceRegex)
          .find(0)
          .saveAs("chairPrice"))
    )
  }
}
