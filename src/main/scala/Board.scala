class Board (x: Int,y: Int){
  var idIter = 0
  val board = createField(x,y)
  def createField(x: Int, y: Int)={
    val field = Array.ofDim[Option[Arrow]](x,y)
    //field.foreach(arr => arr.foreach(s  => s =  ".")
   // var counter = 0
    for(i <- 0 until x){
      for(j <-  0 until y){
        field(i)(j) = None
//        print(field(i)(j) + " ")
//        counter = counter + 1
      }
    }
    field
  }
  def printBoard(): Unit ={
    for(i <- board.indices){
      for(j <- board(i).indices){
        if(board(i)(j).isDefined){
          print(board(i)(j).get.name)
        }else{
          print("x")
        }
      }
      println()
    }
  }
  def createArrow(n: String,xCord: Int,yCord: Int): Unit ={
    val arrow = new Arrow(n,idIter)
    board(xCord)(yCord) = Some(arrow)
    idIter = idIter + 1
  }
  def move(xCor: Int,yCor: Int,m: Int)={
    board(xCor)(yCor).get.name match {
      case "^" => board(xCor - m)(yCor) = board(xCor)(yCor)
      board(xCor)(yCor) = None

    }
  }
}
