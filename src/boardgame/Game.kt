package boardgame

class Game(val players: List<Player>, val board: List<String>, val dice: Dice, val configuration: Configuration){
    private val hotelOwners:MutableMap<Int, Player> = mutableMapOf()

    fun play(){
        for(i in 1..Configuration.TOTAL_ROUNDS){
            round()
        }
    }

    private fun round() {
        for (player in players){
            player.position = (player.position +  dice.roll()) % board.size
            when (board[player.position]){
                "J" -> player.amount = player.amount - Configuration.JAIL_FINE
                "T" -> player.amount = player.amount + Configuration.TREASURE_BONUS
                "H" -> {
                    if(hotelOwners.containsKey(player.position)){
                       val owner = hotelOwners[player.position]
                        owner!!.amount = owner.amount + configuration.HOTEL_RENT
                        player.amount = player.amount - configuration.HOTEL_RENT
                    }
                    else{
                        player.amount = player.amount - configuration.HOTEL_AMOUNT
                        hotelOwners[player.position] = player
                    }
                }
                "E" -> {}
            }
        }
    }

    fun result() {
        players.sortedBy { it.amount }.reversed().forEach { println("${it.name} => ${it.amount}")}
    }
}