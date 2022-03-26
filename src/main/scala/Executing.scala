import Computer.board
import scala.io.Source

class Executing(s: String) {

  val filename = s

  def nth(ns: Iterator[String], n: Int): Iterator[String] = {
    if (n == 1) ns.take(1)
    else ns.drop(n - 1).take(1)
  }

  val num_lines = Source.fromFile(filename).getLines.size

  def line_to_list(s: String, n: Int): Seq[String] = {
    nth(Source.fromFile(s).getLines, n).flatMap(line => line.split("\\s+")).toSeq
  }

  for {
    i <- 1 to num_lines
  } yield {
    val com = line_to_list(filename, i)
    if (com(0) == "CREATE") board.createArrow(com(1), com(2).toInt, com(3).toInt)
    else if (com(0) == "ROTATE") board.rotate(com(1).toInt, com(2).toInt)
    else if (com(0) == "MOVE") board.move(com(1).toInt, com(2).toInt)
    else println("Wrong command")
    board.printBoard()
    println("_" * 10)
  }

}
