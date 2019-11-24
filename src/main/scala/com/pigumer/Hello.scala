package com.pigumer

import java.util.UUID

import io.lettuce.core.RedisClient

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = {
    val conn = redisClient.connect()
    try {
      val sync = conn.sync()
      sync.set("hoge", "hello")
      sync.get("hoge")
    } finally {
      conn.close()
    }
  }

  val redisClient = RedisClient.create("redis://localhost:6379")

}
