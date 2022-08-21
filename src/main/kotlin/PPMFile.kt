private const val PPM_MAGIC_NUMBER = "P3"
private const val PPM_MAXIMUM_COLOR_VALUE = "255"

data class PPMFile(val width: Int, val height: Int) {

    private val header = """
            |$PPM_MAGIC_NUMBER
            |$width $height
            |$PPM_MAXIMUM_COLOR_VALUE
        """.trimIndent().trimMargin()

    fun content(): String {
        val builder = StringBuilder()
        builder.append(header)
        repeat(height) {
            builder.append("\n")
            repeat(width) {
                builder.append("255 0 0")
            }
        }
        builder.append("\n")
        return builder.toString()
    }
}