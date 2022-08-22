import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class ColorTest {

    @Test
    internal fun `convert (0,1) to (0, 255)`() {
        assertContentEquals(
            arrayOf(0, 0, 0),
            color(0.0, 0.0, 0.0).to255Range()
        )

        assertContentEquals(
            arrayOf(255, 255, 255),
            color(1.0, 1.0, 1.0).to255Range()
        )

        assertContentEquals(
            arrayOf(127, 127, 127),
            color(0.5, 0.5, 0.5).to255Range()
        )
    }
}