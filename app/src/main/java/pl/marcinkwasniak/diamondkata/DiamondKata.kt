package pl.marcinkwasniak.diamondkata

class DiamondKata {

    fun render(target: Char): String = StringBuilder().apply {
        val diff = target - PEAK

        for (i in 0 until diff) {
            appendLine(line(letter = Char(PEAK.code + i), target = target))
        }

        appendLine(line(letter = target, target = target))

        for (i in 0 until diff) {
            appendLine(line(letter = Char(target.code - i - 1), target = target))
        }
    }.toString()

    private fun line(
        letter: Char,
        target: Char,
        maxDiff: Int = target - PEAK,
        lineSize: Int = 1 + maxDiff * 2
    ): String = CharArray(lineSize) { SEPARATOR }.also { line ->
        val diff = target - letter
        line[diff] = letter
        line[lineSize - 1 - diff] = letter
    }.joinToString(separator = CHAR_SEPARATOR)

    companion object {
        const val PEAK = 'A'
        private const val SEPARATOR = ' '
        private const val CHAR_SEPARATOR = ""
    }
}