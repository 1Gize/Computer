object Computer extends App{
  val board= new Board(4,4)
  board.createArrow("<",1,1)
  board.createArrow("^",2,2)
  board.move(0,1)
  board.move(1,2)
  board.rotate(1, 90)
  board.printBoard()
}
