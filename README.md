# MODIFICIRANI JAMB - DZ1 -> ANDROID PROGRAMIRANJE (KOTLIN)
Zadatak ovog projekta je bio napraviti modificiranu konzolnu aplikaciju za igru **Jamb**  pomoću IntelliJ Community Edition IDE u programskom jeziku **Kotlin**.
### PRAVILA IGRE
Pravila igre ovog modificiranog jamba su malo drugačija od tradicionalnog načina igre. Igrači na početku igre biraju **bodovni prag** (najmanje 100) te nema ograničen broj poteza. **MIN** i **MAX** elementi igre su *izbačeni* te se može samo *dobiti* **JAMB**,**POKER**,**FULL**,**TRIS**,**MALA SKALA** ili **VELIKA SKALA**. Svaki dobitak se nadodaje ukupnom broju bodova. U svakom **potezu** igrač mora kroz **3 bacanja** odabrati pet kockica koje će zaključati i ići na provjeru dobitka te samu dodjelu bodova ako dobitak postoji. Nakon svakog **poteza** provjerava se je li netko od igrača dostigao bodovni prag. **Pobjednik** je prvi igrač koji prijeđe bodovni prag. Ako je više igrača prešlo bodovni prag gleda se tko je sakupio više bodova. Ako je više igrača prešlo bodovni prag i imaju jednak broj bodova pobjednici su svi koji imaju najveći broj bodova (moguć je veći broj pobjednika).  

### [Dice](src/main/kotlin/Dice.kt)
U klasi Dice nalazi se logika za **kockicu**. Kockica se može baciti, zaključati, provjeriti je li zaključana i resetirati za ponovno bacanje.

### [Record](src/main/kotlin/Record.kt)
U klasi **Record** nalazi se logika za jedan **zapisnik bodova**. Svaki **igrač** ima svoj zapisnik. Zapisnik sadrži metode za dodavanje bodova na ukupan broj bodova ako je igrač dobio bilo koji od mogućih dobitaka te atribut **isDone** koji sadrži informaciju je li igrač dostigao bodovni prag. 

### [Scanner](src/main/kotlin/Scanner.kt)
U klasi **Scanner** nalazi se logika za **skener** koji provjerava moguće dobitke na osnovu **liste od 5 integera**. Metodom **scan()** jednostavno provjerava koji je dobitak ostvaren u bacanju (ako ga ima).

### [Player](src/main/kotlin/Player.kt)
Ova klasa predstavlja jednog **igrača**. U sebi sadrži referencu na **zapisnik** pomoću kojeg zapisuje bodove igrača. Igrač može baciti kockice koje nije prethodno zaključao. Tako maksimalno 3 puta. Nakon svakog bacanja igrač ima pravo **zaključati** kockice koje želi sve dok ne zaključa ukupno njih 5. Ako treće bacanje ne zaključa 5 kockica sustav ga prisiljava da to učini. Kada zaključa 5 kockica, igrač **zapisuje dobitke** (ako ih ima) te završava potez **resetirajući** *svoje counter-e* (priprema za idući potez) i *kockice* (priprema kockica za sljedećeg igrača).

### [Main(Driver)](src/main/kotlin/Main.kt)
*Main* predstavlja **driver** igre. U početku se inicijaliziraju sve **potrebne varijable** za rad te se odredi **bodovni prag i igrači**. Potom slijedi *igranje* same **igre**. Zatim se prikupljaju podaci te se obrađuju. Na kraju slijedi **proglašenje pobjednika**.
