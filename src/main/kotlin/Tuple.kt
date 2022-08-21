import kotlin.math.sqrt

data class Tuple(val x: Double, val y: Double, val z: Double, val w: Double) {
    operator fun plus(b: Tuple): Tuple = Tuple(x + b.x, y + b.y, z + b.z, w + b.w)
    operator fun minus(b: Tuple): Tuple = Tuple(x - b.x, y - b.y, z - b.z, w - b.w)
    operator fun unaryMinus() = Tuple(-x, -y, -z, -w)
    operator fun times(scalar: Double) = Tuple(x * scalar, y * scalar, z * scalar, w * scalar)
    operator fun div(scalar: Double) = Tuple(x / scalar, y / scalar, z / scalar, w / scalar)

    fun magnitude(): Double = sqrt(x * x + y * y + z * z)
    fun normalize(): Tuple {
        val magnitude = magnitude()
        return Tuple(x / magnitude, y / magnitude, z / magnitude, w / magnitude)
    }

    infix fun dot(vector: Tuple) = x * vector.x + y * vector.y + z * vector.z + w * vector.w
    infix fun cross(vector: Tuple) = vector(
        y * vector.z - z * vector.y,
        z * vector.x - x * vector.z,
        x * vector.y - y * vector.x
    )
}

typealias tuple = Tuple

fun point(x: Double, y: Double, z: Double) = Tuple(x, y, z, 1.0)
fun vector(x: Double, y: Double, z: Double) = Tuple(x, y, z, 0.0)
