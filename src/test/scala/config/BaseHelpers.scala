package config

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef.http

object BaseHelpers {

  val baseUrl = "http://localhost/";

  val httpProtocol = http
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/115.0")

  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val headers_1 = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Origin" -> "http://localhost",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_2 = Map(
    "Origin" -> "http://localhost",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_3 = Map(
    "Content-Type" -> "multipart/form-data; boundary=---------------------------40229347752136757597490891122",
    "Origin" -> "http://localhost",
    "Upgrade-Insecure-Requests" -> "1")

  def thinkTimer(Min: Int = 2, Max: Int = 5): ChainBuilder = {
    pause(Min, Max)
  }




}
