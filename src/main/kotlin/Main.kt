import java.io.File

data class Projectile(val position: Tuple, val velocity: Tuple)
data class Environment(val gravity: Tuple, val wind: Tuple)

fun tick(environment: Environment, projectile: Projectile): Projectile {
    val position = projectile.position + projectile.velocity
    val velocity = projectile.velocity + environment.gravity + environment.wind
    return Projectile(position, velocity)
}

fun main(args: Array<String>) {
    val width = 100
    val height = 100

    val file = PPMFile(width, height)

    val rayOrigin = point(0.0, 0.0, -5.0)
    val wallZ = 10.0
    val wallSize = 7.0
    val canvasPixels = 100
    val pixelSize = wallSize / canvasPixels
    val half = wallSize / 2
    val canvas = Canvas(canvasPixels, canvasPixels)
    val shape = sphere()
    val color = color(1.0, 0.0, 0.0)

    for (y in 0 until canvasPixels) {
        val worldY = half - pixelSize * y
        for (x in 0 until canvasPixels) {
            val worldX = -half + pixelSize * x
            val position = point(worldX, worldY, wallZ)
            val r = ray(rayOrigin, (position - rayOrigin).normalize())
            val xs = intersection(shape, r)

            if(xs.isNotEmpty() && xs.firstOrNull{ it.t >= 0 } != null) {
                canvas.writePixel(x, y, color)
            }
        }
    }

    canvas
        .getPixelColors()
        .map { it.to255Range().toList().joinToString(" ") }
        .chunked(width)
        .map { it.joinToString(" ")}
        .forEach { file.append(it) }

    File("test.ppm").writeText(file.content())
}