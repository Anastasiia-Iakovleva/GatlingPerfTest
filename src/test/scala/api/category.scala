package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object category {
  def openCategory(category: String): ChainBuilder = {
    exec(
      http(s"Open $category")
        .get(baseUrl + s"$category")
        .headers(headers_0)
        .check(regex("<a href=\"http://localhost/products/(.*)\"><")
          .findRandom
          .saveAs("productURL"))
    )
  }
}
