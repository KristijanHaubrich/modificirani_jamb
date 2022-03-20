import java.util.Random

class Dice (
    private var locked:Boolean = false,
            var score:Int = 0
        ){

    fun throwDice():Int{
        score = Random().nextInt(1,7)
        return score
    }

    fun lock(){
        locked = true
    }

    fun isLocked():Boolean{
        return locked
    }

    fun reset(){
        locked = false
        score = 0
    }
}