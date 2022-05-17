package task1

/***
 * @param currentPressure текущее давление
 */
class Wheel(
        private var currentPressure: Double
) {

    /***
     * Накачать колесо
     * @param value подаваемое давление
     */
    fun pumpUpWheel(value: Double) {
        try {
            PressureCheck.pressureCheck(value)
            currentPressure = value
            println("При накачке $value атмосфер процедура удалась")
        } catch (e: PressureException) {
            println("При накачке $value атмосфер ${e.message}")
        }
    }

    /***
     * Проверить уровень давления
     * @param value подаваемое давление
     */
    fun checkPressureLevel() {
        PressureCheck.pressureCheck(currentPressure)
        println("Давление в колесе составляет $currentPressure атмосфер")
    }

}