package boardgame

class Game(val players: List<Player>, val board: List<String>, val dice: Dice, val configuration: Configuration){

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
                "H" -> {}
                "E" -> {}
            }
        }
    }

    fun result() {
    }
}