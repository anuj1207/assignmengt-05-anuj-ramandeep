package edu.knoldus

import org.scalatest.FlatSpec

/**
  * Created by ashish on 1/2/17.
  */
class EmployeeOpsTest extends FlatSpec{

  val employeeOps = new EmployeeOps

  it should "return true in adding employee" in {
    assert(employeeOps.add(Employee(1,"Anuj","subhash Nagar",999,111,333)))
  }

  it should "return true in deleting employee" in {
    assert(employeeOps.delete(1))
  }

}
