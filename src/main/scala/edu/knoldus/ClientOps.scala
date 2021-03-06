package edu.knoldus

import java.sql.Statement

/**
  * Created by ashish on 1/2/17.
  */
case class Client(id:Int, projectId:Int, name:String, address:String)

class ClientOps {

  def add(client: Client):Boolean = {
    try {
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val  output = statement.execute(s"Insert into employee values(${client.id},'${client.name}','${client.address}',${client.projectId})")
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

  def delete(clientId: Int): Boolean={
    try{
      DBConnection.getConnection() match {
        case Some(x) => {
          val connection = x
          val statement: Statement = connection.createStatement()
          val output = statement.executeUpdate(s"Delete from Client where id = $clientId")
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
