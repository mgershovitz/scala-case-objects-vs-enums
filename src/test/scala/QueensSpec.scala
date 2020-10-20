import org.scalatest.WordSpecLike
import QueensEnum.{getSong => getSongEnum}
import QueensCaseObject.{getSong => getSongCase}
import QueensEnumeratummm.{getSong => getSongEnumeratum}


class QueensSpec extends WordSpecLike{
  "Queens Enum" must {
    "Fail to catch match error in compilation" in {
      assert(getSongEnum(QueensEnum.shakira) equals Songs.shakira)
      assertThrows[MatchError] {getSongEnum(QueensEnum.beyonce)}
    }
    "Get all values" in {
      assert(QueensEnum.values.size equals 3)
    }
  }

  "Queens Case Object" must {
    "Succeed on defined input" in {
      assert(getSongCase(QueensCaseObject.shakira) equals Songs.shakira)
      assert(getSongCase(QueensCaseObject.beyonce) equals Songs.beyonce)
      assert(getSongCase(QueensCaseObject.gaga) equals Songs.gaga)
    }
    "Get only defined values" in {
      assert(QueensCaseObject.values.size != 3)
    }
  }

  "Queens Enumeratum" must {
    "Succeed on defined input" in {
      assert(getSongEnumeratum(QueensEnumeratummm.shakira) equals Songs.shakira)
      assert(getSongEnumeratum(QueensEnumeratummm.beyonce) equals Songs.beyonce)
      assert(getSongEnumeratum(QueensEnumeratummm.gaga) equals Songs.gaga)
    }
    "Get all values" in {
      assert(QueensEnumeratummm.values.size equals 3)
    }
  }
}
