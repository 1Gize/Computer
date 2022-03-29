import scala.io.Source

object Computer extends App{
  println(args(0))
  val lines = Source.fromFile(args(0)).getLines
//  lines.foreach(println)
  val board = new Board(10,10)
  val execute = new Executing(args(0))
  execute.execute

//  board.createArrow(">",0,3)
//  board.printBoard()
//  board.move(0,1)
//  board.printBoard()
//  //board.createArrow("^",2,2)
//  board.move(0,40)
////  board.move(1,2)
////  board.rotate(1, 90)
//  board.printBoard()
}
