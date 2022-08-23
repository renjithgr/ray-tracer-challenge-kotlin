import kotlin.math.sqrt

data class Intersection(val t: Double, val obj: Sphere)

data class Sphere(val center: Tuple = point(0.0, 0.0, 0.0))
typealias sphere = Sphere

fun intersection(sphere: Sphere, ray: Ray): List<Intersection> {
    val sphereToRay = ray.origin - sphere.center

    val a = ray.direction dot ray.direction
    val b = 2.0 * ray.direction dot sphereToRay
    val c = (sphereToRay dot  sphereToRay) - 1

    val discriminant = (b*b) - (4 * a * c)

    return if(discriminant < 0)
        emptyList()
    else {
        val t1 = (-b - sqrt(discriminant)) / (2 * a)
        val t2 = (-b + sqrt(discriminant)) / (2 * a)
        listOf(
            Intersection(t1, sphere),
            Intersection(t2, sphere),
        )
    }
}

