package models

import org.neo4j.ogm.annotation.{GeneratedValue, Id, NodeEntity, Transient}
import com.softwaremill.id.pretty.{PrettyIdGenerator, StringIdGenerator}

import scala.util.Random

@NodeEntity
abstract class Entity {

  @Transient
  val generator: StringIdGenerator = PrettyIdGenerator.singleNode

  @Id
  @GeneratedValue
  var id: Long = Random.nextLong()

  var uid: String = generator.nextId()
}
