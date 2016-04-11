package adt

import java.util.Date

object Adt {

  //Sum Type

  sealed trait Currency extends Instrument

  case object USD extends Currency

  case object EUR extends Currency

  case object INR extends Currency


  //Product Type
  sealed trait Instrument

  case class Equity(isIn: String, name: String, dateOfIssue: Date) extends Instrument

  case class FixedIncome(isIn: String, name: String, dateOfIssue: Date, issueCurrency: Currency, nominal: BigDecimal) extends Instrument


  case class Account(no: String, name: String, dateOfOpening: Date, balance: Balance)

  case class Balance(amount: BigDecimal, ins: Instrument, asOf: Date) {
    def getHolding(account: Account) = account.balance match {
      case Balance(a, c: Currency, _) => ???
      case Balance(a, e: Equity, _) => ???
      case Balance(a, FixedIncome(i, _, _, c, n), _) => ???
    }
  }


}
