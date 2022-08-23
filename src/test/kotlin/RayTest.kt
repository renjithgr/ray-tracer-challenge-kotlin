import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RayTest {

    @Test
    fun `Computing a point from a distance`() {
        val ray = ray(point(2.0, 3.0, 4.0), vector(1.0, 0.0, 0.0))
        assertEquals(point(2.0, 3.0, 4.0), position(ray, 0.0))
        assertEquals(point(3.0, 3.0, 4.0), position(ray, 1.0))
        assertEquals(point(1.0, 3.0, 4.0), position(ray, -1.0))
        assertEquals(point(4.5, 3.0, 4.0), position(ray, 2.5))
    }
}