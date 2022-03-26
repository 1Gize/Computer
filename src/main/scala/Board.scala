import scala.collection.mutable.ListBuffer

class Board(x: Int, y: Int) {
  val arrows = new ListBuffer[Arrow]
  var idIter = 0
  val board = createField(x, y)

  def createField(x: Int, y: Int) = {
    val field = Array.ofDim[Option[Arrow]](x, y)
    //field.foreach(arr => arr.foreach(s  => s =  ".")
    // var counter = 0
    for (i <- 0 until x) {
      for (j <- 0 until y) {
        field(i)(j) = None
        //        print(field(i)(j) + " ")
        //        counter = counter + 1
      }
    }
    field
  }

  def printBoard(): Unit = {
    for (i <- board.indices) {
      for (j <- board(i).indices) {
        if (board(i)(j).isDefined) {
          print(board(i)(j).get.name)
        } else {
          print(".")
        }
      }
      println()
    }
  }

  def createArrow(n: String, xCord: Int, yCord: Int): Unit = {
    val arrow = new Arrow(n, xCord, yCord, idIter)
    arrows += arrow
    board(xCord)(yCord) = Some(arrow)
    idIter = idIter + 1
  }

  def move(id: Int, m: Int) = {
    arrows.foreach(ar => if (ar.id == id) {
      ar.name match
      {
        case "^" => board(ar.x - m)(ar.y) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
        case ">" => board(ar.x)(ar.y + m) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
        case "v" => board(ar.x + m)(ar.y) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
        case "<" => board(ar.x)(ar.y - m) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
      }
    })
  }

  def rotate(id: Int, d: Int) = {
    arrows.foreach(ar => if (ar.id == id) {
      ar.rotate(d)
    })

  }
}

