package edu.knoldus

import java.sql.Statement

/**
  * Created by ashish on 1/2/17.
  */
case class Project(id:Int, deptId:Int, name:String, clientId:Int)

class ProjectOps {

  def add(project: Project):Boolean = {
    try{
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.execute(s"Insert into employee values(${project.id},'${project.name}',${project.deptId},${project.clientId})")
          DBConnection.closeConnection()
          output
        }
        case _ =>false
      }
      true
    }
    catch{
      case ex: Exception => false
    }
  }

  def delete(projID: Int): Boolean ={
    try {
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"Delete from Project where id = $projID")
          DBConnection.closeConnection()
          output
        }
        case _ =>false
      }
      true
    }
    catch{
      case ex: Exception => false
    }
  }

}
