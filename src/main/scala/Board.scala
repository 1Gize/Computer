class Board (x: Int,y: Int){
  val board = createField(x,y)
  def createField(x: Int, y: Int)={
    val field = Array.ofDim[String](x,y)
    //field.foreach(arr => arr.foreach(s  => s =  ".")
   // var counter = 0
    for(i <- 0 until x){
      for(j <-  0 until y){
        field(i)(j) = " "
//        print(field(i)(j) + " ")
//        counter = counter + 1
      }
    }
    field
  }
}
