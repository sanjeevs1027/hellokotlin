package boardgame



fun main(){
    val board = getBoard()
    val dice = getDice()
//    val players = getPlayers()


}



fun getDice(): Any? {
    return null
}

fun getBoard():  List<String> {
    println("Enter the board cells:")
    val cells = readLine() ?: ""
    return cells.split(",")
}
