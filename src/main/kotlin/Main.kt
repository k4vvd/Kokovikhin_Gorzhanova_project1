import kotlin.math.pow
fun main()
{
    while (true)
    {
        println("\nМеню:")
        println("1. Подсчитать количество подряд идущих одинаковых символов")
        println("2. Подсчитать количество различных символов")
        println("3. Перевести число из 10-й в 2-ю систему")
        println("4. Калькулятор двух чисел (+ - * /)")
        println("5. Проверить существование целочисленного показателя степени")
        println("6. Составить нечетное число из двух цифр")
        println("0. Выход")
        print("Выберите задачу: ")

        when (readLine()?.toIntOrNull())
        {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            6 -> task6()
            0 -> {
                println("Выход из программы.")
                return
            }
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}
fun task1()
{
    print("Введите строку: ")
    val stroke1 = readLine() ?: ""
    var result = ""
    var count = 1

    for (i in 1..stroke1.length)
    {
        if (i < stroke1.length && stroke1[i] == stroke1[i - 1])
        {
            count++
        } else
        {
            result += stroke1[i - 1]
            if (count > 1) result += count.toString()
            count = 1
        }
    }
    println("Результат: $result")
}

fun task2()
{
    print("Введите строку: ")
    val stroke2 = readLine() ?: ""
    val map = mutableMapOf<Char, Int>()

    for (char in stroke2)
    {
        map[char] = map.getOrDefault(char, 0) + 1
    }

    val sortkey = map.keys.sorted()
    for (key in sortkey) {
        println("$key - ${map[key]}")
    }
}

fun task3()
{
    print("Введите натуральное число: ")
    val num_1 = readLine()?.toIntOrNull()
    if (num_1 == null || num_1 < 0)
    {
        println("Некорректнный ввод")
        return
    }
    println("В двоичной системе: ${num_1.toString(2)}")
}

fun task4()
{
    print("Введите выражение (ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ): ")
    val input = readLine()?.split(" ") ?: return
    if (input.size != 3) {
        println("Неверный формат ввода")
        return
    }

    val num_1 = input[0].toDoubleOrNull()
    val num_2 = input[1].toDoubleOrNull()
    val sign = input[2]

    if (num_1 == null || num_2 == null) {
        println("Ошибка: числа введены неверно")
        return
    }

    val result: Any = when (sign) {
        "+" -> num_1 + num_2
        "-" -> num_1 - num_2
        "*" -> num_1 * num_2
        "/" -> if (num_2 != 0.0) num_1 / num_2 else return println("Ошибка: деление на ноль!")
        else -> return println("Неизвестная операция")
    }

// Проверяем результат: если без дробной части — выводим как Int
    if (result is Double) {
        if (result % 1.0 == 0.0) {
            println("Результат: ${result.toInt()}")
        } else {
            println("Результат: $result")
        }
    } else {
        println("Результат: $result")
    }
}
fun task5() {
    print("Введите число n: ")
    val n = readLine()?.toIntOrNull() ?: return
    print("Введите основание степени x: ")
    val x = readLine()?.toIntOrNull() ?: return
    var found = false
    for (y in 1..100) { // ограничим перебор
        if (x.toDouble().pow(y.toDouble()).toInt() == n)
        {
            println("Целочисленный показатель существует: y = $y")
            found = true
            break
        }
    }
    if (!found) println("Целочисленный показатель не существует")
}
fun task6() {
    print("Введите первую цифру: ")
    val num_1 = readLine()?.toIntOrNull()
    print("Введите вторую цифру: ")
    val num_2 = readLine()?.toIntOrNull()
    if (num_1 == null || num_2 == null || num_1 !in 0..9 || num_2 !in 0..9) {
        println("Ошибка: нужно вводить только цифры (0–9)")
        return
    }
    val new_num1 = num_1 * 10 + num_2
    val new_num2 = num_2 * 10 + num_1

    var found = false

    if (new_num1 % 2 == 1) {
        println("возможное нечетное число: $new_num2")
        found = true
    }

        if (!found)
        {
            println("создать нечетное число не удалось")
        }
}
