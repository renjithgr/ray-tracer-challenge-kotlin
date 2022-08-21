import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TupleTests {

    @Test
    fun `a point has w = 1_0`() {
        val point = Point(4.3, -4.2, 3.1)
        assertEquals(1.0, point.w)
    }

    @Test
    fun `a vector has w = 0_0`() {
        val point = Vector(4.3, -4.2, 3.1)
        assertEquals(0.0, point.w)
    }
}