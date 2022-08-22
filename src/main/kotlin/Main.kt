import java.io.File

data class Projectile(val position: Tuple, val velocity: Tuple)
data class Environment(val gravity: Tuple, val wind: Tuple)

fun tick(environment: Environment, projectile: Projectile): Projectile {
    val position = projectile.position + projectile.velocity
    val velocity = projectile.velocity + environment.gravity + environment.wind
    return Projectile(position, velocity)
}

fun main(args: Array<String>) {
    var width = 900
    var height = 550

    var projectile = Projectile(point(0.0, 1.0, 0.0), vector(1.0, 1.8, 0.0).normalize() * 11.25)
    val environment = Environment(vector(0.0, -0.1, 0.0), vector(-0.01, 0.0, 0.0))
    val canvas = Canvas(width, height)

    while(projectile.position.y >= 0) {
        projectile = tick(environment, projectile)
        val y = (height - projectile.position.y).toInt()
        val x = (width - projectile.position.x).toInt()
        println("${projectile.position.y} - (${x}, ${y})")
        canvas.writePixel(x, y, color(255.0, 0.0, 0.0))
    }

    val file = PPMFile(width, height)

    canvas
        .getPixelColors()
        .map { it.to255Range().toList().joinToString(" ") }
        .chunked(width)
        .map { it.joinToString(" ")}
        .forEach { file.append(it) }

    File("test.ppm").writeText(file.content())
}