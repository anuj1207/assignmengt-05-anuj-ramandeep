package edu.knoldus

import org.scalatest.FlatSpec

/**
  * Created by ashish on 1/2/17.
  */
class DepartmentOpsTest extends FlatSpec{
  val departmentOps = new DepartmentOps

  it should "return true in adding Department" in {
    assert(departmentOps.add(Department(1,"Sales")))
  }

  it should "return true in deleting Department" in {
    assert(departmentOps.delete(1))
  }
}
