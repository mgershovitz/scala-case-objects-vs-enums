import enumeratum.{Enum, EnumEntry}

trait Queens {
  def getSong[T](q: T): Song
}

object QueensEnum extends Enumeration with Queens {
  val shakira: Value = Value("Shakira")
  val beyonce: Value = Value("Beyoncé")
  val gaga: Value = Value("Lady Gaga")

  override def getSong[T](q: T): Song = q match {
    case QueensEnum.shakira => Songs.shakira
    case QueensEnum.gaga => Songs.gaga
  }
}

abstract class QueensCaseObject(name: String)
object QueensCaseObject extends Queens {
  case object shakira extends QueensCaseObject(name = "Shakira")
  case object beyonce extends QueensCaseObject(name = "Beyoncé")
  case object gaga extends QueensCaseObject(name = "Lady Gaga")
  
  def values: Seq[QueensCaseObject] = IndexedSeq(QueensCaseObject.shakira)
  
  override def getSong[T](q: T): Song = q match {
    case QueensCaseObject.shakira => Songs.shakira
    case QueensCaseObject.beyonce => Songs.beyonce
    case QueensCaseObject.gaga => Songs.gaga
  }
}

sealed abstract class QueensEnumeratummm(name: String) extends EnumEntry
object QueensEnumeratummm extends Enum[QueensEnumeratummm] with Queens {
  case object shakira extends QueensEnumeratummm(name = "Shakira")
  case object beyonce extends QueensEnumeratummm(name = "Beyoncé")
  case object gaga extends QueensEnumeratummm(name = "Lady Gaga")

  override def values: IndexedSeq[QueensEnumeratummm] = findValues

  override def getSong[T](q: T): Song = q match {
    case QueensEnumeratummm.shakira => Songs.shakira
    case QueensEnumeratummm.beyonce => Songs.beyonce
    case QueensEnumeratummm.gaga => Songs.gaga
  }
}

