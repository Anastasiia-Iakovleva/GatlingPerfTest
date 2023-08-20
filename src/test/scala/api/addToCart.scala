package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object addToCart {
  def addToCart(productId: String): ChainBuilder = {
    exec(
      http("Add Item To Cart")
        .post(baseUrl + "wp-admin/admin-ajax.php")
        .headers(headers_1)
        .formParam("action", "ic_add_to_cart")
        .formParam("add_cart_data", s"current_product=$productId&cart_content=&current_quantity=1")
        .formParam("cart_widget", "0")
        .formParam("cart_container", "0")
        .check(regex("Added!"))
    )
  }
}
