data class Projectile(val position: Tuple, val velocity: Tuple)
data class Environment(val gravity: Tuple, val wind: Tuple)

fun tick(environment: Environment, projectile: Projectile): Projectile {
    val position = projectile.position + projectile.velocity
    val velocity = projectile.velocity + environment.gravity + environment.wind
    return Projectile(position, velocity)
}

fun main(args: Array<String>) {
    var projectile = Projectile(point(0.0, 1.0, 0.0), vector(1.0, 1.0, 0.0).normalize())
    val environment = Environment(vector(0.0, -0.1, 0.0), vector(-0.01, 0.0, 0.0))

    while(projectile.position.y >= 0) {
        projectile = tick(environment, projectile)
        println(projectile.position.y)
    }

}