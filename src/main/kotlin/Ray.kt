data class Ray(val origin: Tuple, val direction: Tuple)
typealias ray = Ray

fun position(ray: Ray, t: Double): Tuple = ray.origin + ray.direction * t