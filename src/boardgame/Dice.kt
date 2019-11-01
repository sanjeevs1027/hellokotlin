package boardgame

class Dice(private val output:List<Int>) {
    private var call = 0;
    fun roll():Int{
       val out = output[call];
        call++;
        return out;
    }
}