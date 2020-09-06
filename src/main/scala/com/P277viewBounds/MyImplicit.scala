package com.P277viewBounds

object MyImplicit {
  implicit def person3ToOrderedPerson3(p3:Person3)=new Ordered[Person3]{
    override def compare(that: Person3) = {  //自己的业务
      p3.age-that.age
    }
  }

}
