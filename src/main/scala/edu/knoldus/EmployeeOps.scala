package edu.knoldus

import java.sql.Statement

/**
  * Created by ashish on 1/2/17.
  */
case class Employee(id:Int, name:String, address:String, phone:Long, deptId:Int, projectId:Int)

class EmployeeOps {

  def add(employee: Employee):Boolean = {
    try {
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"insert into Employee values" +
            s"(${employee.id},'${employee.name}','${employee.address}',${employee.phone},${employee.deptId},${employee.projectId})")
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

  def delete(empID: Int): Boolean ={
    try {
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"Delete from Employee where id = $empID")
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
