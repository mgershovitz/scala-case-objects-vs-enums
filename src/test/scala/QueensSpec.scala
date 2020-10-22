import org.scalatest.WordSpecLike
import QueensEnum.{getSong => getSongEnum}
import QueensCaseObject.{getSong => getSongCase}
import QueensEnumeratum.{getSong => getSongEnumeratum}


class QueensSpec extends WordSpecLike{
  "Queens Enum" must {
    "Fail to catch match error in compilation" in {
      assert(getSongEnum(QueensEnum.Shakira) equals Songs.Shakira)
      assertThrows[MatchError] {getSongEnum(QueensEnum.Beyonce)}
    }
    "Get all values" in {
      assert(QueensEnum.values.size equals 3)
    }
    "Implements and guarantee order" in {
      assert(QueensEnum.Shakira < QueensEnum.Gaga)
    }
  }

  "Queens Case Object" must {
    "Succeed on defined input" in {
      assert(getSongCase(QueensCaseObject.Shakira) equals Songs.Shakira)
      assert(getSongCase(QueensCaseObject.Beyonce) equals Songs.Beyonce)
      assert(getSongCase(QueensCaseObject.Gaga) equals Songs.Gaga)
    }
    "Get only defined values" in {
      assert(QueensCaseObject.values.size != 3)
    }
  }

  "Queens Enumeratum" must {
    "Succeed on defined input" in {
      assert(getSongEnumeratum(QueensEnumeratum.Shakira) equals Songs.Shakira)
      assert(getSongEnumeratum(QueensEnumeratum.Beyonce) equals Songs.Beyonce)
      assert(getSongEnumeratum(QueensEnumeratum.Gaga) equals Songs.Gaga)
    }
    "Get all values" in {
      assert(QueensEnumeratum.values.size equals 3)
    }
    "Allows to implements and guarantee order" in {
      assert(QueensEnumeratum.Shakira.value < QueensEnumeratum.Gaga.value)
    }
  }
}
