fun main(args: Array<String>) {
   var potezCounter = 0
   val skener = Scanner()
   var igraci:MutableList<Player> = ArrayList()
   val kockice:MutableList<Dice> = ArrayList()
   for (i in 0..5){
      var kockica:Dice = Dice()
      kockice.add(i,kockica)
   }

   println("DOBRO DOŠLI U MODIFICIRANU VERZIJU JAMBA :)")

   //unos cilja
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
   println("Unesite do koliko se igra (minimalno 100): ")
   var cilj = readLine()?.toIntOrNull()
   while(cilj == null || cilj < 100){
      println("Niste dobro unijeli broj igrača (minimalno 1). Molimo unesite ponovo: ")
      cilj = readLine()?.toIntOrNull()
   }
   println("--------------------------------------------------------------------------------------------------------------------------------------------")

   //unos broja igrača
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
   println("Unesite broj igrača (barem 1): ")
   var brojIgraca = readLine()?.toIntOrNull()
   while(brojIgraca == null || brojIgraca < 1){
      println("Niste dobro unijeli broj igrača (minimalno 1). Molimo unesite ponovo: ")
      brojIgraca = readLine()?.toIntOrNull()
   }
   println("--------------------------------------------------------------------------------------------------------------------------------------------")

   //stvaranje igrača i dodjela imena
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
   for (i in 0..brojIgraca-1){
      println("Unesite ime igrača${i + 1}: ")
      var imeIgraca = readLine()
      while(imeIgraca == null){
         println("Niste dobro unijeli ime igrača. Molimo unesite ponovo: ")
         imeIgraca = readLine()
      }
      var igrac = Player(imeIgraca,cilj)
      igraci.add(i,igrac)
   }
   println("--------------------------------------------------------------------------------------------------------------------------------------------")

   //igra
   var gotovo = false
   while(!gotovo){
      potezCounter++
      println("--------------------------------------------------------------------------------------------------------------------------------------------")
      println("$potezCounter. POTEZ:")
      println("--------------------------------------------------------------------------------------------------------------------------------------------")
      for (igrac in igraci){
         println("--------------------------------------------------------------------------------------------------------------------------------------------")
         println("Baca igrač ${igrac.name.uppercase()}:")
         var brojevi:MutableList<Int> = ArrayList()
         while (!igrac.isFinished){
            igrac.throwDice(kockice)
            println("--------------------------------------------------------------------------------------------------------------------------------------------")
            brojevi = igrac.lockDices(kockice)
            println("--------------------------------------------------------------------------------------------------------------------------------------------")
         }
         skener.set(brojevi)
         var rezultat = skener.scan()
         println("Izabrali ste: $brojevi i dobili ste $rezultat")
         igrac.writeScore(brojevi,rezultat)
         println("Rezultat nakon ovog bacanja:")
         println("--------------------------------------------------------------------------------------------------------------------------------------------")
         for (igrac in igraci){
            println("${igrac.name}: ${igrac.record.score}")
         }
         println("--------------------------------------------------------------------------------------------------------------------------------------------")
         if (igrac.isGoalReached()) gotovo = true
         igrac.resetThrow(kockice)
      }
   }

   //prikupljanje rezultata
   var rezultati:MutableList<Int> = ArrayList()
   for (igrac in igraci){
      var rezultat = igrac.record.score
      rezultati.add(rezultat)
   }

   //usporedba rezultata
   var najboljiRezultat = 0
   for (rezultat in rezultati){
      if (rezultat > najboljiRezultat) najboljiRezultat = rezultat
   }

   //proglasenje pobjednika
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
   println("PROGLAŠENJE POBJEDNIKA:")
   for (igrac in igraci){
      if(igrac.record.score==najboljiRezultat){
         println("${igrac.name.uppercase()}")
      }
   }
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
   println("IGRA JE ZAVRŠENA U $potezCounter POTEZA")
   println("HVALA NA IGRI :)")
   println("--------------------------------------------------------------------------------------------------------------------------------------------")
}
