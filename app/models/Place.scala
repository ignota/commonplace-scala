package models

import org.neo4j.ogm.annotation.{GeneratedValue, Id, NodeEntity, Relationship}

import java.util.{Set => JSet}

@NodeEntity
class Place(var name: String) extends Entity {
  @Relationship(`type` = "IS_IN", direction = Relationship.INCOMING)
  var people: JSet[Person] = _

  def this() = {
    this("")
  }
}
