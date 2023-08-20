package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object checkout {
  val checkoutUrl = "checkout";

  def checkout(): ChainBuilder = {
    exec(
      http("Checkout")
        .post(baseUrl + checkoutUrl)
        .headers(headers_2)
        .formParam("cart_content", "{\"${tableID}__\":1,\"${chairID}__\":1}")
        .formParam("p_quantity[]", "1,1")
        .formParam("shipping", "order")
        .formParam("p_id[]", "${tableID}__,${chairID}__")
        .formParam("trans_id", "16889076381272")
        .formParam("total_net", "${totalPrice}")
        .check(regex("Checkout"))
    )
  }

  def placeOrder(): ChainBuilder = {
    exec(
      http("Place Order")
        .post(baseUrl + checkoutUrl)
        .headers(headers_3)
        .formParam("cart_city", "Berlin")
        .formParam("cart_content", "{\"${tableID}\":1,\"${chairID}\":1},{\"${tableID}\":1,\"${chairID}\":1}")
        .formParam("ic_formbuilder_redirect", baseUrl + "thank-you")
        .formParam("cart_s_address", "")
        .formParam("cart_submit", "Place Order")
        .formParam("cart_comment", "")
        .formParam("cart_s_phone", "")
        .formParam("trans_id", "16889076439313")
        .formParam("cart_type", "order")
        .formParam("cart_s_company", "")
        .formParam("cart_country", "DE")
        .formParam("cart_s_postal", "")
        .formParam("cart_s_state", "")
        .formParam("shipping", "order")
        .formParam("product_price_${tableID}__", "${tablePrice}")
        .formParam("cart_company", "")
        .formParam("cart_s_email", "")
        .formParam("cart_name", "John Smith")
        .formParam("cart_state", "")
        .formParam("cart_s_country", "")
        .formParam("cart_phone", "+491721123456")
        .formParam("cart_s_city", "")
        .formParam("cart_address", "Test Street 123")
        .formParam("cart_postal", "10354")
        .formParam("cart_s_comment", "")
        .formParam("cart_inside_header_2", "<b>DELIVERY ADDRESS</b> (FILL ONLY IF DIFFERENT FROM THE BILLING ADDRESS)")
        .formParam("cart_email", "test@gmail.com")
        .formParam("cart_s_name", "")
        .formParam("cart_inside_header_1", "<b>BILLING ADDRESS</b>")
        .formParam("product_price_${chairID}__", "${chairPrice}")
        .formParam("total_net", "${totalPrice}")
        .check(regex("Thank You"))
    )
  }

}
