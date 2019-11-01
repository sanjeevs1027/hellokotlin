package boardgame



object Configuration {
    const val JAIL_FINE = 150
    const val TREASURE_BONUS = 200
    const val HOTEL_RENT = 50
    const val HOTEL_AMOUNT = 400
    const val TOTAL_ROUNDS = 10
    const val START_AMOUNT = 2000.00
}

data class Player(val name: String) {
    var position: Int = 0
    var amount: Double = Configuration.START_AMOUNT
}

fun main(){
    val board = getBoard()
    val dice = getDice()
    val players = getPlayers()

    val game  =  Game(board=board, players = players, dice = dice, configuration = Configuration)
    game.play()
    game.result()
}


fun getPlayers(): List<Player> {
    println("Enter number of players:")
    val count = Integer.parseInt(readLine());
    val players: MutableList<Player> = mutableListOf()
    for (i in 1..count){
        players.add(Player("Player$i"))
    }
    return players.toList()
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
