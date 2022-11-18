package models

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Person(var name: String, var age: Int) extends Entity {
  def this() = {
    this("", 0)
  }
}
