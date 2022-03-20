class Scanner(
    var numbers:MutableList<Int> = ArrayList()
) {
    fun checkJamb():Boolean{
        return numbers[0] == numbers[1] && numbers[0] == numbers[2] && numbers[0] == numbers[3] && numbers[0] == numbers[4]
    }

    fun checkPoker():Boolean{
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
            if (counter == 4) return true
        }
        return false
    }

    fun checkFull():Boolean{
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
            if (counter == 3){
                for (counter1 in counters){
                    if (counter1 == 2) return true
                }
            }
        }
        return false
    }

    fun checkTris():Boolean{
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
            if (counter == 3) return true
        }
        return false
    }

    fun checkSmallSkala():Boolean{
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
        var skalaCounter = 0
        for (i in 0..4){
            if (counters.get(i) == 1) skalaCounter++
        }
        if(skalaCounter == 5) return true
        return false

    }

    fun checkBigSkala():Boolean{
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
        var skalaCounter = 0
        for (i in 1..5){
            if (counters.get(i) == 1) skalaCounter++
        }
        if(skalaCounter == 5) return true
        return false

    }

    fun scan():String{
        if(checkJamb()) return "jamb"
        else if(checkPoker()) return "poker"
        else if(checkFull()) return "full"
        else if(checkTris()) return "tris"
        else if(checkSmallSkala()) return "smallSkala"
        else if(checkBigSkala()) return "bigSkala"
        else return "nista"
    }

    fun set(numbers:MutableList<Int>){
        this.numbers = numbers
    }
}