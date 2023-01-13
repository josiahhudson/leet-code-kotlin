class Solution {
    fun romanToInt(s: String): Int = s.romanNumeralInt()
    
    private fun String.romanNumeralInt():Int {
        return map { it.romanDigitInt() }.run {
            zipWithNext()
                .fold(last()) { acc, pair -> acc + pair.romanDigitContribution() }
        }
    }

    private fun Pair<Int, Int>.romanDigitContribution(): Int = if (first < second) { -1 } else { 1 } * first

    private fun Char.romanDigitInt(): Int = when (this) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> error("Illegal roman digit ${this}!")
    }
}
