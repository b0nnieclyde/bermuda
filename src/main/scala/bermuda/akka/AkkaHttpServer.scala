package bermuda.akka

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest}
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.unmarshalling.Unmarshal
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.{Await, Future}
object AkkaHttpServer {

  implicit val actorSystem = ActorSystem("system")
  implicit val actorMaterializer = ActorMaterializer()

  def main(args: Array[String]): Unit = {

    val route =
      get {
        pathSingleSlash {
          complete {
            "Hello World!"
          }
        } ~
          path("a" / "b" /) {
            complete {
              "Hello World, AB!"
            }
          }
      }
    Http().bindAndHandle(route, "localhost", 8080)
    getRequest("http://localhost:8080").onComplete(println)
    getRequest("http://localhost:8080/a/b/").onComplete(println)
    getRequest("http://localhost:8080/a/b/c").onComplete(println)
    getRequest("http://localhost:8081/jasperserver/rest_v2/resources").onComplete(println)
  }

  def getRequest(uri: String): Future[String] = {
    val request = HttpRequest(HttpMethods.GET, uri)
    for {
      response <- Http().singleRequest(request)
      content <- Unmarshal(response.entity).to[String]
    } yield content
  }

}