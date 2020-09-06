package com.P120homework5

object P120_04 {

  def main(args: Array[String]): Unit = {
    val checkingAccount = new CheckingAccount(10)
    checkingAccount.deposit(100)
    checkingAccount.query()
    checkingAccount.withdraw(50)
    checkingAccount.query()

    println("===================")
    val savingsAccount = new SavingsAccount(100)
    savingsAccount.query()   //100
    savingsAccount.earnMonthlyInterest()
    savingsAccount.query()    //101
    savingsAccount.deposit(50)
    savingsAccount.withdraw(50)
    savingsAccount.withdraw(50)
    savingsAccount.withdraw(50)
    savingsAccount.query()    //0
  }

}

class BankAccount(initialBalance:Double){
  private var balance = initialBalance
  def deposit(amount:Double) = { balance += amount; balance}    //存款
  def withdraw(amount:Double) = {balance -= amount; balance}    //取款
  def query(): Unit ={
    println("当前余额为："+balance)
  }
}

class CheckingAccount(initialBalance:Double) extends BankAccount(initialBalance){
  override def deposit(amount: Double): Double = super.deposit(amount-1)

  override def withdraw(amount: Double): Double = super.withdraw(amount+1)
}

class SavingsAccount(initialBalance:Double) extends BankAccount(initialBalance){
  private var num:Int = _
  def earnMonthlyInterest(): Double ={
    num = 3
    super.deposit(1)
  }

  override def deposit(amount: Double): Double = {
    num -= 1
    if (num<0){
      super.deposit(amount-1)
    }else {
      super.deposit(amount)
    }
  }

  override def withdraw(amount: Double): Double = {
    num -= 1
    if (num<0) super.withdraw(amount+1) else super.withdraw(amount)
  }
}
