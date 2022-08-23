import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class IntersectionTest {

    @Test
    internal fun `A ray intersects a sphere at two points`() {
        val ray = ray(point(0.0, 0.0, -5.0), vector(0.0, 0.0, 1.0))
        val s = sphere()

        val xs = intersection(s, ray)

        assertEquals(2, xs.size)
        assertEquals(4.0, xs[0].t)
        assertEquals(6.0, xs[1].t)
    }

    @Test
    internal fun `A ray intersects a sphere at a tangent`() {
        val ray = ray(point(0.0, 1.0, -5.0), vector(0.0, 0.0, 1.0))
        val s = sphere()

        val xs = intersection(s, ray)

        assertEquals(2, xs.size)
        assertEquals(5.0, xs[0].t)
        assertEquals(5.0, xs[1].t)
    }

    @Test
    internal fun `A ray misses a sphere`() {
        val ray = ray(point(0.0, 2.0, -5.0), vector(0.0, 0.0, 1.0))
        val s = sphere()

        val xs = intersection(s, ray)

        assertEquals(0, xs.size)
    }

    @Test
    internal fun `A ray originates inside a sphere`() {
        val ray = ray(point(0.0, 0.0, 0.0), vector(0.0, 0.0, 1.0))
        val s = sphere()

        val xs = intersection(s, ray)

        assertEquals(2, xs.size)
        assertEquals(-1.0, xs[0].t)
        assertEquals(1.0, xs[1].t)
    }

    @Test
    internal fun `A sphere is behind a ray`() {
        val ray = ray(point(0.0, 0.0, 5.0), vector(0.0, 0.0, 1.0))
        val s = sphere()

        val xs = intersection(s, ray)

        assertEquals(2, xs.size)
        assertEquals(-6.0, xs[0].t)
        assertEquals(-4.0, xs[1].t)
    }
}