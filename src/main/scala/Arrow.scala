class Arrow (n: String, xCord: Int, yCord: Int, i: Int){
  var x = xCord
  var y = yCord
  var name = n
  val id = i
  def rotate(d: Int)={
    name match {
      case "^" => d match {
        case 0 => name = "^"
        case 90  => name = ">"
        case -270 => name = ">"
        case 180  => name = "v"
        case -180 => name = "v"
        case 270  => name = "<"
        case -90 => name = "<"
      }
      case ">" => d match {
        case 0 => name = ">"
        case 90  => name = "v"
        case -270 => name = "v"
        case 180  => name = "<"
        case -180 => name = "<"
        case 270  => name = "^"
        case -90 => name = "^"
      }
      case "v" => d match {
        case 0 => name = "v"
        case 90  => name = "<"
        case -270 => name = "<"
        case 180  => name = "^"
        case -180 => name = "^"
        case 270  => name = ">"
        case -90 => name = ">"
      }
      case "<" => d match {
        case 0 => name = "<"
        case 90  => name = "^"
        case -270 => name = "^"
        case 180  => name = ">"
        case -180 => name = ">"
        case 270  => name = "v"
        case -90 => name = "v"
      }
    }
  }
}
