package boardgame



fun main(){
    val board = getBoard()
    val dice = getDice()
    val players = getPlayers()


}

fun getPlayers(): Any?{
    return null
}

fun getDice(): Dice {
    println("Enter the dice Input:")
    val diceIn = readLine()
    return Dice(diceIn!!.split(",").map { Integer.parseInt(it) })
}


fun getBoard():  List<String> {
    println("Enter the board cells:")
    val cells = readLine() ?: ""
    return cells.split(",")
}
