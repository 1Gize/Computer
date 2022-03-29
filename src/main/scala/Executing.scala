import Computer.board
import scala.io.Source

class Executing(s: String) {

  val filename = s


  def execute = {
    val lines = Source.fromFile(s).getLines.toSeq
    lines.foreach(println)
    lines.map { line =>
      println(line)
      val com = line.split("\\s+")
      com(0) match {
        case "CREATE" => board.createArrow(com(1), com(2).toInt, com(3).toInt)
        case "ROTATE" => board.rotate(com(1).toInt, com(2).toInt)
        case "MOVE" => board.move(com(1).toInt, com(2).toInt)
        case _ => println("Wrong command")
      }

      board.printBoard()
      println("_" * 10)
    }
  }

}
