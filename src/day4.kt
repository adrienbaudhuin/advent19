fun main() {
    val low = 402328
    val up = 864247
    var current = low
    var count = 0;

    println(checkRules(112233.digits()))
    println(checkRules(123444.digits()))
    println(checkRules(111122.digits()))

    while (current <= up) {
        val digits = current.digits()
        if (checkRules(digits)) {
            count++
        }
        current++
    }
    println(count)
}

fun checkRules(digits: Array<Int>): Boolean {
    var adjacentDigits = mutableMapOf<Int, Int>()
    for (i in 0..4) {
        if (digits[i] == digits[i + 1]) {
            adjacentDigits[digits[i]] = adjacentDigits.getOrDefault(digits[i], 0) + 1
        }
    }
    return adjacentDigits.containsValue(1) && digits.sortedArray().contentEquals(digits)
}

fun Int.digits(): Array<Int> {
    var clone = this;
    val result = mutableListOf<Int>()
    while (clone > 0) {
        result.add(clone % 10);
        clone /= 10;
    }
    return result.toTypedArray().reversedArray()
}