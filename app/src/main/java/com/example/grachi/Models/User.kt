package com.example.grachi.Models

data class User (
    private var teachers1: ArrayList<String> =
        arrayListOf("ИЗО","Музыка","Физкультура","Окружающий мир","Русский язык","Литература","Математика"),
    private var teachers234: ArrayList<String> =
        arrayListOf("Английский язык","ИЗО","Музыка","Физкультура","Окружающий мир","Русский язык","Литература","Математика"),
    private var teachers5: ArrayList<String> =
        arrayListOf("Английский язык","Всеобщая история","ИЗО","Информатика","Литература",
            "Математика","Музыка","ОБЖ","Природоведение","Русский язык","Технология","Физкультура"),
    private var teachers6: ArrayList<String> =
        arrayListOf("Английский язык","Биология","Всеобщая история","География","ИЗО",
            "Информатика","История России","Литература", "Математика",
            "Музыка","ОБЖ","Русский язык","Технология","Физкультура"),
    private var teachers7: ArrayList<String> =
        arrayListOf("Алгебра","Английский язык","Биология","Всеобщая история","География",
            "Геометрия", "ИЗО", "Информатика","История России","Литература",
            "Музыка","ОБЖ","Обществознание","Русский язык","Технология","Физика","Физкультура"),
    private var teachers8: ArrayList<String> =
        arrayListOf("Алгебра","Английский язык","Биология","Всеобщая история","География",
            "Геометрия", "Информатика","История России","Краеведение","Литература",
            "Музыка","ОБЖ","Обществознание","Русский язык","Технология","Физика","Физкультура","Химия"),
    private var teachers9: ArrayList<String> =
        arrayListOf("Алгебра","Английский язык","Биология","Всеобщая история","География",
            "Геометрия", "Информатика","История России","Литература", "ОБЖ",
            "Обществознание","Русский язык","Физика","Физкультура","Химия"),
    private var teachers10: ArrayList<String> =
        arrayListOf("Алгебра","Английский язык","Астрономия","Биология","Всеобщая история","География",
            "Геометрия", "Информатика","История России","Литература", "ОБЖ",
            "Обществознание","Право","Русский язык","Физика","Физкультура","Химия"),
    private var teachers11: ArrayList<String> =
        arrayListOf("Алгебра","Английский язык","Биология","Всеобщая история",
            "Геометрия", "Информатика","История России","Литература", "ОБЖ",
            "Обществознание","Право","Русский язык","Физика","Физкультура","Химия"),
    private var teachers: ArrayList<String> = ArrayList<String>(),
    private  var kl:String = "",
    private  var letter:String = "",
    private var name: String = "",
    private var surname: String = "",
private var fields: ArrayList<String> = arrayListOf(kl,letter,name)
) {

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }
    fun getSurname(): String? {
        return surname
    }

    fun setSurname(surname: String?) {
        this.surname = surname!!
    }
    fun getLetter(): String? {
        return letter
    }

    fun setLetter(letter: String?) {
        this.letter = letter!!
    }

    fun getKl(): String? {
        return kl
    }

    fun setKl(kl: String?) {
        this.kl = kl!!
        when (kl)
        {
            "1" -> teachers = teachers1
            "2" -> teachers = teachers234
            "3" -> teachers = teachers234
            "4" -> teachers = teachers234
            "5" -> teachers = teachers5
            "6" -> teachers = teachers6
            "7" -> teachers = teachers7
            "8" -> teachers = teachers8
            "9" -> teachers = teachers9
            "10" -> teachers = teachers10
            "11" -> teachers = teachers11
        }
    }
    fun getteach(): ArrayList<String>? {
        return teachers
    }
}