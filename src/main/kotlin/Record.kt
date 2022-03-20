class Record(
    val goal:Int = 1000
    ) {
    var score:Int = 0
    var isDone:Boolean = false
    fun addJamb(numbers:MutableList<Int>) {
        when (numbers[0]) {
            1 -> score += 55
            2 -> score += 60
            3 -> score += 65
            4 -> score += 70
            5 -> score += 75
            6 -> score += 80
        }
        if (score >= goal) isDone = true
    }

    fun addPoker(numbers:MutableList<Int>){
        var counters:MutableList<Int> = mutableListOf(0,0,0,0,0,0)
        for (number in numbers){
            when(number){
                1-> counters.set(0,counters.get(0)+1)
                2-> counters.set(1,counters.get(1)+1)
                3-> counters.set(2,counters.get(2)+1)
                4-> counters.set(3,counters.get(3)+1)
                5-> counters.set(4,counters.get(4)+1)
                6-> counters.set(5,counters.get(5)+1)
            }
        }
        for (counter in counters){
            if (counter == 4) score += 4*(counters.indexOf(counter)+1)
            else if(counter == 1) score += counters.indexOf(counter)+1
        }
        score += 40
        if (score >= goal) isDone = true
    }

    fun addFull(numbers:MutableList<Int>){
        var counters:MutableList<Int> = mutableListOf(0,0,0,0,0,0)
        for (number in numbers){
            when(number){
                1-> counters.set(0,counters.get(0)+1)
                2-> counters.set(1,counters.get(1)+1)
                3-> counters.set(2,counters.get(2)+1)
                4-> counters.set(3,counters.get(3)+1)
                5-> counters.set(4,counters.get(4)+1)
                6-> counters.set(5,counters.get(5)+1)
            }
        }
        for (counter in counters){
            if (counter == 3) score += 3*(counters.indexOf(counter)+1)
            else if(counter == 2) score += 2*(counters.indexOf(counter)+1)
        }
        score += 30
        if (score >= goal) isDone = true
    }

    fun addTris(numbers:MutableList<Int>){
        var counters:MutableList<Int> = mutableListOf(0,0,0,0,0,0)
        for (number in numbers){
            when(number){
                1-> counters.set(0,counters.get(0)+1)
                2-> counters.set(1,counters.get(1)+1)
                3-> counters.set(2,counters.get(2)+1)
                4-> counters.set(3,counters.get(3)+1)
                5-> counters.set(4,counters.get(4)+1)
                6-> counters.set(5,counters.get(5)+1)
            }
        }
        for (counter in counters){
            if (counter == 3) score += 3*(counters.indexOf(counter)+1)
            else if(counter == 1) score += counters.indexOf(counter)+1
        }
        score += 10
        if (score >= goal) isDone = true
    }

    fun addSmallSkala(numbers:MutableList<Int>){
        score += 30
        if (score >= goal) isDone = true
    }

    fun addBigSkala(numbers:MutableList<Int>){
        score += 40
        if (score >= goal) isDone = true
    }
}