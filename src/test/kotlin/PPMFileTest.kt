import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PPMFileTest {
    @Test
    internal fun `content test`() {
        assertEquals(
            listOf("P3", "5 5", "255"),
            PPMFile(5, 5).content().split("\n").take(3)
        )
    }
}