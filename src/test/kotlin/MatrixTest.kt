import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MatrixTest {

    @Test
    internal fun `multiplying two matrices`() {
        val a = Matrix.new(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 8, 7, 6),
            intArrayOf(5, 4, 3, 2),
        )

        val b = Matrix.new(
            intArrayOf(-2, 1, 2, 3),
            intArrayOf(3, 2, 1, -1),
            intArrayOf(4, 3, 6, 5),
            intArrayOf(1, 2, 7, 8),
        )

        val c = Matrix.new(
            intArrayOf(20, 22, 50, 48),
            intArrayOf(44, 54, 114, 108),
            intArrayOf(40, 58, 110, 102),
            intArrayOf(16, 26, 46, 42),
        )

        assertEquals(c, a * b)
    }

    @Test
    internal fun `A matrix multiplied by a tuple`() {
        val a = Matrix.new(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(2, 4, 4, 2),
            intArrayOf(8, 6, 4, 1),
            intArrayOf(0, 0, 0, 1),
        )

        val b = tuple(1.0, 2.0, 3.0, 1.0)

        assertEquals(tuple(18.0, 24.0, 33.0, 1.0), a * b)
    }
}