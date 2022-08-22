private const val PPM_MAGIC_NUMBER = "P3"
private const val PPM_MAXIMUM_COLOR_VALUE = "255"

data class PPMFile(val width: Int, val height: Int) {

    private val header = """
            |$PPM_MAGIC_NUMBER
            |$width $height
            |$PPM_MAXIMUM_COLOR_VALUE
        """.trimIndent().trimMargin()

    private val builder = StringBuilder().append(header).append("\n")

    fun append(line: String) {
        builder.append(line).append("\n")
    }

    fun content(): String {
        return builder.toString()
    }
}