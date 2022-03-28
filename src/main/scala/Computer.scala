object Computer extends App{
  val board = new Board(4,4)
//  val execute = new Executing(args(0))
  board.createArrow(">",0,3)
  board.printBoard()
  board.move(0,1)
  board.printBoard()
  //board.createArrow("^",2,2)
  board.move(0,40)
//  board.move(1,2)
//  board.rotate(1, 90)
  board.printBoard()
}
