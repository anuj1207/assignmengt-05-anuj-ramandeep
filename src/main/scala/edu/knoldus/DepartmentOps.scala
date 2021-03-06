package edu.knoldus

import java.sql.Statement

/**
  * Created by ashish on 1/2/17.
  */
case class Department(id:Int, name:String)

class DepartmentOps {

  def add(department: Department):Boolean = {
    try {
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"Insert into Department values(${department.id},'${department.name}')")
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

  def delete(deptId: Int): Boolean = {
    try{
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"Delete from Department where id = $deptId")
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

