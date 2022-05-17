package task1

object PressureCheck {
    private val MESSAGE_TooHighPressure = "процедура удалась. Эксплуатация невозможна — давление превышает нормальное"
    private val MESSAGE_TooLowPressure = "процедура удалась. Эксплуатация невозможна — давление ниже нормального"
    private val MESSAGE_IncorrectPressure = "процедура не удалась"

    @Throws(PressureException::class)
    fun pressureCheck(pressure: Double) {
        if (pressure > 10.0 || pressure < 0.0) throw IncorrectPressure(MESSAGE_IncorrectPressure)
        else if (pressure > 6.0 && pressure < 10.0) throw TooHighPressure(MESSAGE_TooHighPressure)
        else if (pressure < 1.6) throw  TooLowPressure(MESSAGE_TooLowPressure)
    }
}


open class PressureException(message: String?) : Throwable(message)

/***
 * Класс исключение для слишком высокого давления
 */
class TooHighPressure(message: String) : PressureException(message)

/***
 * Класс исключение для слишком низкого давления
 */
class TooLowPressure(message: String) : PressureException(message = message)

/***
 * Класс исключение для недопустимого давления: отрицательное или превышающее 10 атмосфер
 */
class IncorrectPressure(message: String) : PressureException(message = message)