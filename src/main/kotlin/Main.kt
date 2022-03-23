import java.io.File

fun main(args: Array<String>) {


    val imie_lekarza = "Grzegorz"
    val naziwsko_lekarza = "Gruszczynski"

    var dzialanie_programu:Int

    println("Witaj w programie.")

    do{
        println("Wcisnij 1 aby wystawic recepte, wcisnij 2 aby zakonczyc dzialanie programu: ")
        dzialanie_programu = readLine()!!.toInt()
        if(dzialanie_programu == 1){
            var name:String
            var surrname:String
            var pesel:Long
            var day:Int
            var month:Int
            var year:Int
            var wybor: Int


            println("Przygotuj dane do wystawienia recepty: ")
            println("Podaj imię pacjenta : ")
            name = readLine()!!
            println("Podaj nazwisko pacjenta : ")
            surrname = readLine()!!
            do {
                println("Podaj numer PESEL: ")
                pesel = readLine()!!.toLong()
                var pesel_string = pesel.toString()
                var length = pesel.toString().length

            }while(length!=11 || (pesel_string[3] == '0' && pesel_string[3] == '1') || (pesel_string[5]>'3' && pesel_string[6]<'2') || (pesel_string[5]=='0' && pesel_string[6] == '0' ))

            do{
                println("Podaj datę wizyty - dzień: ")
                day = readLine()!!.toInt()

            }while(day>=32 || day<=0 )

            do{
                println("Podaj date wizyty - miesiąc: ")
                month = readLine()!!.toInt()
            }while(month>12 || month<=0)

            do{
                println("Podaj datę wizyty - rok: ")
                year = readLine()!!.toInt()
            }while(year>2025 || year<2022)

            var leczenie:String
            do{
                println("Wybierz przebieg leczenia:")
                println("1: Wypisać leki")
                println("2. Wypisac skierowanie")
                println("3. Wizyta u specjalisty")
                println("4. Zalecic kolejna wizyte za tydzien")
                println("5. Wypisać indywidualnie")
                wybor = readLine()!!.toInt()
                when (wybor) {
                    1 -> leczenie = "Wypisac leki"
                    2 -> leczenie = "Wypisac skierowanie"
                    3 -> leczenie = "Wizyta u specalisty"
                    4 -> leczenie = "Zlecic kolejna wizyte za tydzien"
                    5 -> leczenie = readLine()!!
                    else -> {
                        leczenie = "Nie podano leczenia"
                    }
                }
            }while(wybor>5 || wybor < 0)
            wypisywanie_koncowe(day,month,year,name,surrname, pesel , imie_lekarza,naziwsko_lekarza, leczenie)
            zapisywanie_txt(day,month,year,name,surrname, pesel , imie_lekarza,naziwsko_lekarza, leczenie)
            dzialanie_programu = 3

        }

    }while(dzialanie_programu != 1 && dzialanie_programu != 2)






}



fun wypisywanie_koncowe(dzien:Int, miesiac:Int, rok:Int, imie:String, nazwisko:String, pesel:Long, imie_lekarza:String, nazwisko_lekarza: String, leczenie:String){

    var puste_znaki = "                                            "


    var dzien_string = dzien.toString()
    if(dzien < 10){
        dzien_string = "0$dzien"
    }

    var miesiac_string = miesiac.toString()
    if(miesiac < 10){
        miesiac_string = "0$miesiac"
    }

    println("==============================================")
    println("=$puste_znaki=")
    println("= Formularz recepcyjny:                      =")
    println("=                               $dzien_string-$miesiac_string-$rok   =")
    println("= Imie: $imie" + ile_znakow(imie,puste_znaki,7) + "=")
    println("= Nazwisko: $nazwisko" + ile_znakow(nazwisko,puste_znaki,11) + "=")
    println("= Pesel: $pesel                         =")
    println("==============================================")
    println("= Przebieg leczenia:                         =")
    println("= $leczenie" + ile_znakow(leczenie,puste_znaki,1) + "=")
    println("==============================================")
    println("= Lekarz prowadzacy: $imie_lekarza $nazwisko_lekarza" +  ile_znakow(imie_lekarza,nazwisko_lekarza,puste_znaki,21) + "=" )
    println("==============================================")

}


fun zapisywanie_txt(dzien:Int, miesiac:Int, rok:Int, imie:String, nazwisko:String, pesel:Long, imie_lekarza:String, nazwisko_lekarza: String, leczenie:String){
    var puste_znaki = "                                            "
    var dzien_string = dzien.toString()
    if(dzien < 10){
        dzien_string = "0$dzien"
    }
    var miesiac_string = miesiac.toString()
    if(miesiac < 10){
        miesiac_string = "0$miesiac"
    }

    var rok_string = rok.toString()
    var rok_str:String
    rok_str = (rok_string[2] + rok_string[3].toString())


    val fileName = "$dzien_string$miesiac_string$rok_str-$imie" +  "_$nazwisko.txt"
    val file = File(fileName)

    file.writeText("==============================================\n"+
            "=$puste_znaki=\n"+
            "= Formularz recepcyjny:                      =\n"+
            "=                               $dzien_string-$miesiac_string-$rok   =\n"+
            "= Imie: $imie" + ile_znakow(imie,puste_znaki,7) + "=\n"+
            "= Nazwisko: $nazwisko" + ile_znakow(nazwisko,puste_znaki,11) + "=\n" +
            "= Pesel: $pesel                         =\n" +
            "==============================================\n" +
            "= Przebieg leczenia:                         =\n" +
            "= $leczenie" + ile_znakow(leczenie,puste_znaki,1) + "=\n" +
            "==============================================\n"+
            "= Lekarz prowadzacy: $imie_lekarza $nazwisko_lekarza" +  ile_znakow(imie_lekarza,nazwisko_lekarza,puste_znaki,21) + "=\n"+
            "==============================================\n"
    )


}



fun ile_znakow(word:String, puste:String, dlugosc_startowa:Int):String{
    var word_len = word.length
    var puste_len = puste.length
    var ile_pustych = puste_len - word_len - (dlugosc_startowa+2)
    var pusty_string = " "
    for(i in 0..ile_pustych){
        pusty_string = "$pusty_string "
    }
    return pusty_string
}

fun ile_znakow(word:String,word2:String, puste:String, dlugosc_startowa:Int):String{
    var word_len = word.length
    var word_len2 = word2.length
    var puste_len = puste.length
    var ile_pustych = puste_len - word_len - word_len2 - (dlugosc_startowa+2)
    var pusty_string = " "
    for(i in 0..ile_pustych){
        pusty_string = "$pusty_string "
    }
    return pusty_string
}
