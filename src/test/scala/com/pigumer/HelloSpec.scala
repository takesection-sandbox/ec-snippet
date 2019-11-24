package com.pigumer

import io.lettuce.core.RedisClient
import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    new Greeting {
      override val redisClient: RedisClient = RedisClient.create("redis://localhost:6379")
    }.greeting shouldEqual "hello"
  }
}
