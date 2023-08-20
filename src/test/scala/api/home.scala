package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object home {
  def demoShopHome(): ChainBuilder = {
    exec(
      http("Open Home Page")
        .get(baseUrl)
        .headers(headers_0)
        .check(regex("Performance testing Essentials"))
    )
  }
}
