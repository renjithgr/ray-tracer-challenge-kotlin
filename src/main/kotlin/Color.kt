data class Color(val red: Double, val green: Double, val blue: Double) {

    fun to255Range() = arrayOf(
        (red * 255).coerceIn(0.0, 255.0).toInt(),
        (green * 255).coerceIn(0.0, 255.0).toInt(),
        (blue * 255).coerceIn(0.0, 255.0).toInt()
    )

}

typealias color = Color