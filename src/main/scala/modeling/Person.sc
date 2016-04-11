// This uses the new java.time API available since Java 8
import java.time.{Period, LocalDate}


case class Person(
                   name: String,
                   surname: String,
                   birthDate: LocalDate
                 ){

  def currentAgeInYears: Int = {
    val periodSinceBirth = Period.between(birthDate, LocalDate.now())
    val yearsSinceBirth = periodSinceBirth.getYears
    yearsSinceBirth
  }
}


val examplePersons = Seq(
  Person(
    name = "Mario",
    surname = "Rossi",
    birthDate = LocalDate.of(1989, 3, 23)
  ),
  Person(
    name = "Tizio",
    surname = "Caio",
    birthDate = LocalDate.of(1972, 5, 12)
  )
)


val personAges = examplePersons.map(person => person.currentAgeInYears)


val over30People = examplePersons.filter(person => person.currentAgeInYears > 30)