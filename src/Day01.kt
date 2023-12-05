fun main() {
    fun part1(input: List<String>): Int {
        val onlyDigits = input.map { it.filter { char -> char.isDigit() } }
        val firstAndLastDigits = onlyDigits.map { it.first().toString() + it.last() }
        val calibrationValues = firstAndLastDigits.map { it.toInt() }

        return calibrationValues.sum()
    }

    fun part2(input: List<String>): Int {
        val words = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        // Keep first and last letters to avoid precedence issues with adjoined words e.g., twone
        val numbers = listOf("o1e", "t2o", "t3e", "f4r", "f5e", "s6x", "s7n", "e8t", "n9e")

        val wordsToNumbers = input.map {
            words.zip(numbers).fold(it) { str, (word, number) -> str.replace(word, number) }
        }

        return part1(wordsToNumbers)
    }

    // Test if implementation meets criteria from the description
    val sampleInput1 = readInput("Day01_sample1")
    check(part1(sampleInput1) == 142)
    val sampleInput2 = readInput("Day01_sample2")
    check(part2(sampleInput2) == 281)

    // Get answers
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
