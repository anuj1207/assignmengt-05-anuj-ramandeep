package edu.knoldus

import org.scalatest.FlatSpec

/**
  * Created by ashish on 1/2/17.
  */
class ClientOpsTest extends FlatSpec{

  val clientOps = new ClientOps

  it should "return true in adding Client" in {
    assert(clientOps.add(Client(101,"New","Sales",12)))
  }

  it should "return true in deleting client" in {
    assert(clientOps.delete(101))
  }

}
