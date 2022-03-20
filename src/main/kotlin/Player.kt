class Player(val name:String, goal:Int = 1000)
{
    val record:Record = Record(goal)
    var lockedCounter = 0
    var throwCounter = 0
    var isFinished = false

    fun throwDice(dices:MutableList<Dice>){
        throwCounter++
        println("$throwCounter. bacanje:")
        for (dice in dices){
            if(!dice.isLocked()){
                dice.throwDice()
                println("Kockica${dices.indexOf(dice)+1}: ${dice.score}")
            }
            else println("Kockica${dices.indexOf(dice)+1}: ${dice.score} (zaključano)")
        }
    }

    fun lockDices(dices:MutableList<Dice>):MutableList<Int>{
        var scores = mutableListOf<Int>()
        for (dice in dices){
            if (!dice.isLocked() && lockedCounter < 5){
                println("Želite li zaključati Kockicu${dices.indexOf(dice)+1}? (da/ne): ")
                val answear = readLine()
                if(answear!=null && answear == "da"){
                    dice.lock()
                    lockedCounter++
                }
            }
            if (lockedCounter == 5) isFinished = true
        }
        if (throwCounter == 3 && lockedCounter < 5){
            while (lockedCounter<5){
                println("Niste zaključali dovoljno kockica. Pokušajte ponovo:")
                for (dice in dices){
                    if (!dice.isLocked() && lockedCounter < 5){
                        println("Želite li zaključati Kockicu${dices.indexOf(dice)+1}? (da/ne): ")
                        val answear = readLine()
                        if(answear!=null && answear == "da"){
                            dice.lock()
                            lockedCounter++
                        }
                    }
                }

            }
            isFinished = true
        }
        for (dice in dices) {
            if(dice.isLocked()) scores.add(dice.score)
        }
        return scores
    }

    fun resetThrow(dices:MutableList<Dice>){
        for (dice in dices) dice.reset()
        throwCounter = 0
        lockedCounter = 0
        isFinished = false
    }

    fun writeScore(numbers:MutableList<Int>,state:String){
        if (state=="tris") record.addTris(numbers)
        else if (state=="full") record.addFull(numbers)
        else if (state=="poker") record.addPoker(numbers)
        else if (state=="jamb") record.addJamb(numbers)
        else if (state =="smallSkala") record.addSmallSkala(numbers)
        else if (state =="bigSkala") record.addBigSkala(numbers)

    }

    fun isGoalReached():Boolean{
        return record.isDone
    }

}