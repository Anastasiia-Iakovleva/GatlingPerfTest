package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object cart {
  def getCart(): ChainBuilder = {
    exec(
      http("Navigate To Cart")
        .get(baseUrl + "cart")
        .headers(headers_0)
        .check(regex("name=\"total_net\" value=\"((\\d+,)?\\d+.\\d+)\"")
          .find(0)
          .saveAs("totalPrice"))
    )
  }
}
