package android_basic.android_basic.KotlinHighOrderFunctionAndException.`01_Generics`

import java.lang.reflect.Type

/**
Задание 1. Функция, фильтрующая коллекцию целых и вещественных чисел по чётности
Что нужно сделать
Создайте generic-функцию, принимающую на вход список элементов типа T.
Отфильтруйте список таким образом, чтобы в нём остались только чётные элементы.
Верните из функции отфильтрованный список элементов типа T. Функция должна поддерживать списки любых типов, являющихся подтипами Number.
Отфильтруйте и выведите в консоль списки целых чисел и вещественных чисел.
 **/

fun main() {

    HomeWork()

    val a = HomeWork()
    val b = 2
    val object1 = Queue<Int>()
    val object2 = Queue<HomeWork>()

    println("Вывод результатвол задания два ")
    object1.enqueue(b)
    object1.enqueue(4)
    println(object1.dequeue())

    object2.enqueue(a)
    println(object2.dequeue())



}

class HomeWork() {
    val listOneInt = listOf<Int>(2, 32, 1, 3)
    val listOneDouble = listOf<Double>(2.3, 2.2)

    init {
        printGF<Int>(genericFunction<Int>(listOneDouble))
        printGF<Double>(genericFunction<Double>(listOneInt))
    }

    fun <T> genericFunction(input: List<Number>): List<Number> {
        val list: MutableList<Number> = mutableListOf()
        var iindex = 0
        for (index in input.indices) {
            iindex += 1
            if ((iindex + 1) % 2 == 0)
                list.add(input[iindex])
        }
        return list
    }

    fun <T> printGF(input: List<Number>) {
        for (index in input.indices) {
            print("${input[index]} \n ")
        }
    }

}

/**
Задание 2. Класс очереди, который хранит объекты любого типа в порядке очереди
Что нужно сделать
Напишите класс Queue<T>, который представляет из себя очередь. Есть два метода:
enqueue(item: T) — item становится в конец очереди;
dequeue(): T? — достаёт из очереди первый объект, если очередь пуста - возвращается null.
 **/

class Queue<T> {
    val list: MutableList<T> = mutableListOf()
    fun enqueue(item: T) {
        list.add(item)
    }

    fun dequeue(): T? {
        val out = list[0]
        list.removeAt(0)
        return out
    }
}

/**
Задание 3. Sealed-class, описывающий абстрактный результат операции

Что нужно сделать
Создайте sealed-class Result, который параметризован двумя типами — типом успешного результата (T) и типом ошибки (R).
Наследуйтесь от него двумя классами:
Success<T, R> - data class, принимает в конструктор объект типа T;
Error<T, R> - data class, принимает в конструктор объект типа R.
Создайте функцию, которая возвращает объект типа Result<Int, String>. Сделайте так, чтобы результат функции можно было
присвоить переменным со следующими типами:
Result<Number, String>
Result<Any, String>

И нельзя было присвоить переменным со следующими типами:
Result<Int, CharSequence>
Result<Int, Any>
то есть класс Result должен быть ковариантным по параметру T и инвариантным по параметру R.
 */

sealed class Result<out T : Any, R : String> {
    // T - тип успешного результата
    // R - тип ошибки
    data class SuccEs<T, R>(
        val objectSucces1: T
    )

    data class Erorr<T, R>(
        val objectErorr1: R
    )

    fun  funout() {


    }



}

// класс который создается чисто для типа










