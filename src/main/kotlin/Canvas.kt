class Canvas(val width: Int, val height: Int) {
    private val map = mutableMapOf<String, Color>()

    fun writePixel(x: Int, y: Int, color: Color) {
        this.map["$x-$y"] = color
    }

    fun getPixelColors(): List<Color> {
        val list = mutableListOf<Color>()

        for (x in 0 until height) {
            for (y in 0 until width) {
                list.add(this.map["$y-$x"] ?: color(0.0, 0.0, 0.0))
            }
        }

        return list.toList()
    }
}