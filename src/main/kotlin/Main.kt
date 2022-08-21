interface Tuple {
    val x: Double
    val y: Double
    val z: Double
    val w: Double
}

class Point(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple {
    override val w: Double = 1.0
}

class Vector(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : Tuple {
    override val w: Double = 0.0
}


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}