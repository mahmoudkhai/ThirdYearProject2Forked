import java.time.LocalDate

fun main() {

}
fun sortByBits(a: IntArray) = a.sortedWith(compareBy<Int> { Integer.bitCount(it) }.thenBy { it }).toIntArray()

//https://leetcode.com/problems/two-out-of-three/description/
fun twoOutOfThree(a: IntArray, b: IntArray, c: IntArray) = (a + b + c).toSet().filter {
    arrayOf(a, b, c).count { ar -> ar.contains(it) } > 1
}
fun twoOutOfThreeAnotherSolution(a: IntArray, b: IntArray, c: IntArray) = (a + b + c).toSet().filter {
    a.contains(it) && b.contains(it) || b.contains(it) && c.contains(it) || a.contains(it) && c.contains(it)
}


fun toCamelCase(str: String) =
    str.split('-', '_').mapIndexed { i, it -> if (i != 0) it.capitalize() else it }.joinToString("")
fun toCamelCaseUsimgRegex(str:String):String = str.split(Regex("_|-")).reduce{ fullString, word -> fullString + word.capitalize() }


//https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/kotlin
fun persistence(num: Int) = generateSequence("$num") {
    it.map(Character::getNumericValue).reduce(Int::times).toString()
}.takeWhile { it.count() > 1 }.count()
//https://leetcode.com/problems/count-operations-to-obtain-zero/description/
fun countOperations(num1: Int, num2: Int): Int {
    var res = 0
    var first = num1 // always bigger than num2
    var second = num2
    while (second > 0) {
        res += first / second // coefficient
        first = second.also {
            second = first % second // remainder
        }
    }
    return res
}
fun reverseList(head: ListNode?, previousNode: ListNode? = null): ListNode? {
    return when (head) {
        null -> previousNode
        else -> {
            val transNode = head.next
            head.next = previousNode
            reverseList(transNode, head)
        }
    }
}
// https://www.codewars.com/kata/64cac86333ab6a14f70c6fb6/train/kotlin
fun checkLogs(log: Array<String>): Int {
    val zipWithNext: List<Boolean> = log.toList().zipWithNext { first, second -> first < second }
    return log.size - zipWithNext.count()
}

// note: it's allowed to subtract a lower char from higher char , but not vice versa
fun addLetters(arr: List<Char>) = 'z' - arr.sumOf { 'z' - it } % 26

fun dateNbDays(initialMoney:Double, target:Double, intersetRate:Double) =
    "${
        LocalDate.of(2016, 1, 1).plusDays(
        generateSequence(initialMoney){it+it*intersetRate/36000}.takeWhile { it < target }.count().toLong())
    }"

fun nbYear(initialPopulation: Int, percent: Double, newPeople: Int, desiredPopulation: Int): Int {
    return generateSequence(initialPopulation.toDouble()) { it * (1 + percent / 100) + newPeople }
        .takeWhile { // you can use indexOfFirst
            it < desiredPopulation
        }.count()
}


fun partlist(list: Array<String>): Array<Array<String>> {
    return list.toList().windowed(list.size, 1, true).mapIndexedNotNull { index, tail ->
        if (index == 0) null else {
            arrayOf(
                list.take(index).joinToString(" "),
                tail.joinToString(" ")
            )
        }
    }.toTypedArray()
}

// another sol fun repeats(arr: IntArray): Int =
//    2 * arr.distinct().sum() - arr.sum()
fun repeats(arr: IntArray): Int = arr.groupBy { it }.filterValues { it.size < 2 }.keys.sum()
