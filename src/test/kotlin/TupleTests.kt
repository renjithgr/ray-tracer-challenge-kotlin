import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.math.sqrt
import kotlin.test.assertEquals

class TupleTests {

    @Test
    fun `a point has w = 1_0`() {
        val point = point(4.3, -4.2, 3.1)
        assertEquals(1.0, point.w)
    }

    @Test
    fun `a vector has w = 0_0`() {
        val point = vector(4.3, -4.2, 3.1)
        assertEquals(0.0, point.w)
    }

    @Nested
    @DisplayName("Operations")
    inner class Operations {
        @Test
        internal fun `adding two tuples`() {
            val result = tuple(3.0, -2.0, 5.0, 1.0) + tuple(-2.0, 3.0, 1.0, 0.0)
            assertEquals(tuple(1.0, 1.0, 6.0, 1.0), result)
        }

        @Test
        internal fun `subtracting two points`() {
            val result = point(3.0, 2.0, 1.0) - point(5.0, 6.0, 7.0)
            assertEquals(vector(-2.0, -4.0, -6.0), result)
        }

        @Test
        internal fun `subtracting a vector from a point`() {
            val result = point(3.0, 2.0, 1.0) - vector(5.0, 6.0, 7.0)
            assertEquals(point(-2.0, -4.0, -6.0), result)
        }

        @Test
        internal fun `subtracting a vector from a vector`() {
            val result = vector(3.0, 2.0, 1.0) - vector(5.0, 6.0, 7.0)
            assertEquals(vector(-2.0, -4.0, -6.0), result)
        }

        @Test
        internal fun `negating a tuple`() {
            assertEquals(tuple(-1.0, 2.0, -3.0, 4.0), -tuple(1.0, -2.0, 3.0, -4.0))
        }

        @Test
        internal fun `multiplying a tuple by a scalar`() {
            assertEquals(
                tuple(3.5, -7.0, 10.5, -14.0),
                tuple(1.0, -2.0, 3.0, -4.0) * 3.5
            )
        }

        @Test
        internal fun `dividing a tuple by a scalar`() {
            assertEquals(
                tuple(0.5, -1.0, 1.5, -2.0),
                tuple(1.0, -2.0, 3.0, -4.0)/ 2.0
            )
        }

        @Test
        internal fun `computing the magnitudes`() {
            assertEquals(1.0, vector(1.0, 0.0 ,0.0).magnitude())
            assertEquals(1.0, vector(0.0, 1.0 ,0.0).magnitude())
            assertEquals(1.0, vector(0.0, 0.0 ,1.0).magnitude())
            assertEquals(sqrt(14.0), vector(1.0, 2.0 ,3.0).magnitude())
            assertEquals(sqrt(14.0), vector(-1.0, -2.0 ,-3.0).magnitude())
        }

        @Test
        internal fun `normalizing vector (4, 0, 0) gives (1, 0, 0)`() {
            assertEquals(vector(1.0, 0.0 ,0.0), vector(4.0, 0.0 ,0.0).normalize())
        }

        @Test
        internal fun `normalizing vector (1, 2, 3)`() {
            assertEquals(
                vector(0.2672612419124244, 0.5345224838248488,0.8017837257372732),
                vector(1.0, 2.0 ,3.0).normalize()
            )
        }

        @Test
        internal fun `magnitude of a normalized vector is 1`() {
            assertEquals(
                1.0,
                vector(1.0, 2.0 ,3.0).normalize().magnitude()
            )
        }
    }
}