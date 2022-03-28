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
    val stepsV = m%board.length
    val stepsH = m%board(0).length
    arrows.foreach(ar => if (ar.id == id) {
      ar.name match
      {

        case "^" => board(calcPosVer(stepsV,ar))(ar.y) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
          ar.x = calcPosVer(stepsV,ar)
        case ">" => board(ar.x)(calcPosHor(stepsH,ar)) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
          ar.y = calcPosHor(stepsH,ar)
        case "v" => board(calcPosVer(stepsV,ar))(ar.y) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
          ar.x = calcPosVer(stepsV,ar)

        case "<" => board(ar.x)(calcPosHor(stepsH,ar)) = board(ar.x)(ar.y)
          board(ar.x)(ar.y) = None
          ar.y = calcPosHor(stepsH,ar)
      }
    })
  }
  def calcPosHor(delta: Int, arr: Arrow): Int={
    arr.name match {
      case "<" => if((arr.y - delta)<0){
        board(0).length - arr.y - delta
      }else{
        arr.y - delta
      }
      case ">" => if((arr.y + delta)>board(0).length-1){
        0 + (arr.y + delta - board(0).length)
      } else {
        arr.y + delta
      }
    }
  }
  def calcPosVer(delta: Int, arr: Arrow): Int={
    arr.name match {
      case "^" => if((arr.x - delta)<0){
        val x = board.length - arr.x - delta
        println(s"ar.x = $x")
        x
      }else{
        val x = arr.x-delta
        println(s"ar.x = $x")
        x
      }
      case "v" => if((arr.x + delta)>(board.length-1)){
        0 + (arr.x + delta - board.length)
      } else {
        arr.x + delta
      }
    }
  }
  def rotate(id: Int, d: Int) = {
    arrows.foreach(ar => if (ar.id == id) {
      ar.rotate(d)
    })

  }
}

