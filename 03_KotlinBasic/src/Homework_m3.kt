val list = mutableListOf<Int>()
val map = mutableMapOf<Int, Int>()
fun main() {
    //1. Ввести число N с клавиатуры.
    messegeTask("Ввести число N с клавиатуры.")
    print("Введите число: ")
    val number: Int = readLine()?.toIntOrNull() ?: return

    //2. После этого ввести следующие N чисел каждое с новой строки
    // (если пользователь ввел не число — игнорируется эта строка) ( использовать цикл и нуллабельные типы).
    //
    //3. Сохранить числа в список.
    //4. Шаги 2–3 вынести в функцию, которая принимает число N и возвращает список из N чисел, введённых с клавиатуры.
    listNumber()

    //5. Вывести в консоль количество введенных положительных чисел. (Использовать if).
    positiveNumbers()

    //6. Вывести в консоль только четные введённые числа. (Использовать фильтрацию коллекции с помощью функции filter.)
    messegeTask("Вывод только четных введеных числе")
    print(list.filter { (it % 2 == 0) })

    //7. Вывести в консоль количество уникальных введенных чисел. (Использовать set.)
    inicalSet()

    //8. Вычислить сумму всех введенных чисел с помощью агрегирующей функции коллекции sum.
    messegeTask("Вывод суммы всех ввыеденых числе")
    println(list.sum())

    //9. Для каждого числа посчитать наибольший общий делитель (НОД) для этого числа и суммы из пункта 8.
    //
    //(Создать функцию для вычисления НОД, которая использует рекурсию с модификатором tailrec.)
    //
    //10. Создать Map, где ключ — число, а значение — НОД из пункта 9.
    nODinList()

    //11. Вывести все числа с НОД в формате: Число <>, сумма <>, НОД <>. Использовать итерацию
    // по Map из пункта 10. Для каждого из чисел использовать новую строку.
    outputAllNumbers()


}

fun messegeTask(messege: String) {
    println("\n=====================================\n")
    println("**********$messege**********\n")

}

fun listNumber(y: Int = 3) {

    for (i in 0..y) {
        print("Введите число: ")
        val numberTwo: Int? = readLine()?.toInt()
        if (numberTwo == null) {
        } else {
            println(numberTwo)
            list.add(numberTwo)
        }

    }
    messegeTask("Вывод массива ")
    for (i in 0..y) {
        println(list[i])
    }

}

fun positiveNumbers() {
    messegeTask("Функция вычисления положительных чисел")
    (0 until list.size).forEach { i ->
        if (list[i] > 0) {
            println(list[i])
        }
    }
}

fun inicalSet() {
    messegeTask("Функция выводящая уникальные числа")
    //объявляю коллекцию
    val set = setOf<Int>().union(list)
    println(set)
}

fun nODinList() {
    val listSum = list.sum()
    messegeTask("Функция вычисления НОД запущена")
    (0 until list.size).forEach { i ->
        map.put(list[i], nOD(list[i], listSum))
        println("Нод для числа ${list[i]} составляет: ${nOD(list[i], listSum)}")
    }
}

//Вычисление НОД
fun nOD(i: Int, y: Int): Int {
    var biggerNumber: Int
    var minNumber: Int
    var delen: Int

    if (i == y) return i

    if (i > y) {
        biggerNumber = i
        minNumber = y
    } else {
        biggerNumber = y
        minNumber = i
    }

    while (biggerNumber % minNumber != 0) {
        delen = biggerNumber % minNumber
        biggerNumber = minNumber
        minNumber = delen
    }
    return Math.abs(minNumber)
}

fun outputAllNumbers() {
    val listSum = list.sum()
    for ((key, value) in map) {
        println("Число(ключ) <$key> Сумма <$listSum> Нод(значение) <$value>")
    }
}




