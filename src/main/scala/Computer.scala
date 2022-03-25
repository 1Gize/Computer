object Computer extends App{
  createField(3,3)
  def createField(x: Int, y: Int)={
    val field = Array.ofDim[String](x,y)
    //field.foreach(arr => arr.foreach(s  => s =  ".")
    var counter = 0
    for(i <- 0 to x-1){
      println()
      for(j <-  0 to y-1){
        field(i)(j) = counter.toString
        print(field(i)(j) + " ")
        counter = counter + 1
      }
    }
    field
  }
}
