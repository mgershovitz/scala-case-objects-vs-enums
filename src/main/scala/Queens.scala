import enumeratum.{Enum, EnumEntry}

sealed class Song(name: String)
object Songs {
  case object Shakira extends Song("Hips don't lie")
  case object Beyonce extends Song("Single Ladies")
  case object Gaga extends Song("Poker face")
}

object QueensEnum extends Enumeration{
  val Shakira: Value = Value("Shakira")
  val Beyonce: Value = Value("Beyoncé")
  val Gaga: Value = Value("Lady Gaga")

  def getSong(q: QueensEnum.Value): Song = q match {
    case QueensEnum.Shakira => Songs.Shakira
    case QueensEnum.Gaga => Songs.Gaga
  }
}

abstract class QueensCaseObject(name: String)
object QueensCaseObject {
  case object Shakira extends QueensCaseObject(name = "Shakira")
  case object Beyonce extends QueensCaseObject(name = "Beyoncé")
  case object Gaga extends QueensCaseObject(name = "Lady Gaga")
  
  def values: Seq[QueensCaseObject] = IndexedSeq(QueensCaseObject.Shakira)
  
  def getSong(q: QueensCaseObject): Song = q match {
    case QueensCaseObject.Shakira => Songs.Shakira
    case QueensCaseObject.Beyonce => Songs.Beyonce
    case QueensCaseObject.Gaga => Songs.Gaga
  }
}

sealed abstract class QueensEnumeratum(name: String) extends EnumEntry
object QueensEnumeratum extends Enum[QueensEnumeratum] {
  case object Shakira extends QueensEnumeratum(name = "Shakira")
  case object Beyonce extends QueensEnumeratum(name = "Beyoncé")
  case object Gaga extends QueensEnumeratum(name = "Lady Gaga")

  override def values: IndexedSeq[QueensEnumeratum] = findValues

  def getSong[T](q: T): Song = q match {
    case QueensEnumeratum.Shakira => Songs.Shakira
    case QueensEnumeratum.Beyonce => Songs.Beyonce
    case QueensEnumeratum.Gaga => Songs.Gaga
  }
}

