package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.db.Database
import play.api.test._

class HomeControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "access the database which requires evolutions to run" in {
    val database = inject[Database]
    val value = database.withConnection(connection => {
      val rs = connection
        .prepareStatement("select * from table1")
        .executeQuery()
      rs.next() mustBe true
      rs.getString(1)
    })
    value mustBe "hello"
  }
}
