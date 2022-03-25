object Computer extends App{
  val board= new Board(4,4)
  board.createArrow("^",1,1)
 // board.board(1)(1).get.rotate(90)
  board.move(1,1,1)
  board.printBoard()
}
