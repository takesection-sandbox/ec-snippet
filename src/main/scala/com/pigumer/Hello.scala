package com.pigumer

import java.io.{InputStream, OutputStream}
import java.nio.charset.StandardCharsets

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import io.lettuce.core.RedisClient
import spray.json._

class Hello extends Handler {
  lazy val endpoint = sys.env("ELASTICACHE_ENDPOINT")
  lazy val port = sys.env("ELASTICACHE_PORT")
  lazy val redisClient = RedisClient.create(s"redis://$endpoint:$port")
}

trait Greeting {
  val redisClient: RedisClient

  lazy val greeting: String = {
    val client = redisClient
    try {
      val conn = redisClient.connect()
      try {
        val sync = conn.sync()
        sync.set("hoge", "hello")
        sync.get("hoge")
      } finally {
        conn.close()
      }
    } finally {
      client.shutdown()
    }
  }
}

trait Handler extends Greeting with RequestStreamHandler {
  override def handleRequest(input: InputStream, output: OutputStream, context: Context): Unit = {
    output.write(JsObject(
      "greeting" -> JsString(greeting)
    ).compactPrint.getBytes(StandardCharsets.UTF_8))
  }
}
