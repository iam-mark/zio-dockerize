package dev.zio.quickstart.greet

import zio._
import zio.http._

object GreetingRoutes {
  def apply(): Routes[Any, Nothing] =
    Routes(
      // GET /greet?name=:name
      Method.GET / "greet" -> handler { (req: Request) =>
        val names    = req.url.queryParams("name").filter(_.trim.nonEmpty)
        val greeting = if (names.nonEmpty) s"Hello ${names.mkString(" and ")}!" else "Hello World!"
        ZIO.succeed(Response.text(greeting))
      },

      // GET /greet/:name
      Method.GET / "greet" / string("name") -> handler {
        (name: String, _: Request) =>
          Response.text(s"Hello $name!")
      }
    )
}
