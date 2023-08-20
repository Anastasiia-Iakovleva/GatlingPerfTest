package simulations

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.DemoShopScenario.scnDemoShop

class PerfTestSimulation extends Simulation {
  //mvn clean gatling:test

  setUp(
    scnDemoShop.inject(atOnceUsers(5))
  ).protocols(httpProtocol)
}
