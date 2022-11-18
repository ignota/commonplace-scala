package controllers

import models.{Person, Place}
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.SessionFactory
import play.api.mvc._

import javax.inject._

import collection.JavaConverters._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    val config = new Configuration.Builder()
      .uri("bolt://localhost:7687")
      .credentials("neo4j", "commonplace")
      .build()

    val sessionFactory = new SessionFactory(config, "models")
    val session = sessionFactory.openSession()

    val person = new Person("John", 36)
    val txOne = session.beginTransaction()
    session.save(person)
    txOne.commit()
    txOne.close()


    val place = new Place("London")
    place.people = Set(person).asJava

    val txTwo = session.beginTransaction()
    session.save(place)
    txTwo.commit()
    txTwo.close()

    /**
     * You can tell whether the person and place will be created by their ids.
     * Integers are acceptable, longs are really not. For instance, if a
     * `Person` node comes up with ID 1, and a `Place` node with ID
     * 5788872481578621566, the `Person` node will be created, but the `Place`
     * node will not.
     */
    println("Saving person and place", person, place, person.uid, place.uid, person.id, place.id)
    println("place.people", place.people)


    Ok(views.html.index())
  }
}
