package task1

fun main() {
    val wheel = Wheel(-10.0)
    wheel.pumpUpWheel(2.0)
    wheel.pumpUpWheel(1.0)

    val wheel2 = Wheel(-10.0)
    wheel2.checkPressureLevel()
}