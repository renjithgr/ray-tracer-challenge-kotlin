import kotlin.math.sqrt

data class Tuple(
    val x: Double,
    val y: Double,
    val z: Double,
    val w: Double
) {
    operator fun plus(b: Tuple): Tuple = Tuple(x + b.x, y + b.y, z + b.z, w + b.w)
    operator fun minus(b: Tuple): Tuple = Tuple(x - b.x, y - b.y, z - b.z, w - b.w)
    operator fun unaryMinus() = Tuple(-x, -y, -z, -w)
    operator fun times(scalar: Double) = Tuple(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun div(scalar: Double) = Tuple(x / scalar, y / scalar, z / scalar, w / scalar)
    fun magnitude(): Double = sqrt( x * x + y * y + z * z)
    fun normalize(): Tuple {
        val magnitude = magnitude()
        return Tuple(x / magnitude, y / magnitude, z / magnitude, w / magnitude)
    }
}

typealias tuple = Tuple
fun point(x: Double, y: Double, z: Double) = Tuple(x, y, z, 1.0)
fun vector(x: Double, y: Double, z: Double) = Tuple(x, y, z, 0.0)


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}