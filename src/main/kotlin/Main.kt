import org.w3c.dom.ranges.Range
import java.time.Year
import java.util.*
import kotlin.Exception
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    //    "gdfg".forEach ret@{ if (Character.isWhitespace(it)) return@ret }
    data class Person(val name: String, val age: Int)

    val people = listOf(
        Person("Alice", 25),
        Person("Bob", 30),
        Person("Charlie", 25),
        Person("Dave", 30)
    )
    val b = true
    "$b".print();
    val convert = Boolean::toString
    3 shl 1
    val map1 = "ACTG".zip("TGAC").toMap()
    val mapByName: Map<String, Person> = people.associate { person -> person.name to person }
    sum(intArrayOf(0, 1, -1, 2)).print()
//    repeatedNTimes(intArrayOf(1,4,3,3,5)).print()
    makeComplement("ATTGC").print()
    val isValidCharacter = { a: Char -> a in 'a'..'z' } // lamda function
    1 + 'a'.code
    val fn = { string: String, inverse: Boolean ->
        string.mapIndexed { index, value -> if ((index and 0x1 == 0) xor inverse) value.uppercase() else value.lowercase() }
    }
    val list = ListNode(3)
    list.next = ListNode(2)
    list.next = ListNode(1)
    val arrayOf = arrayOf(1, 3, 1, 4, 3, 4)
    val map: Map<Int, Int> = arrayOf.associateBy({ it }, { n -> arrayOf.count { it == n } })
//    minDeletionSize(arrayOf("zyx", "wvu", "tsr")).print()
    println(Int::class.isInstance('1' - '0'))
    println(Int::class.isInstance('0' + 1))


}


fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    return groupSizes.withIndex().groupBy { it.value }.flatMap { (size, nums) ->
        nums.map { it.index }.chunked(size)
    }
}
//class Solution {
//    fun groupThePeople(groupSizes: IntArray): List<List<Int>> =
//        groupSizes.withIndex().groupBy { it.value }.map { it.value.map { it1 -> it1.index }.chunked(it.key) }.flatten()
//}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var oddSum = 0

        for (i in 1..arr.size step 2) {
            oddSum += arr.asSequence().toList().windowed(i).map {
                it.sum()
            }.sum()
        }

        return oddSum
    }

    fun checkTreee(root: TreeNode?): Boolean {
        return if ((root?.`val` ?: 0) == (root?.right?.`val` ?: 0) + (root?.left?.`val` ?: 0)) true else false
    }

    fun checkTree(
        root: TreeNode?,
        isValid: Boolean = root!!.`val` == root!!.left!!.`val` + root!!.right!!.`val`
    ): Boolean = isValid

    fun recurstion(root: TreeNode?): Int {
        if (root == null) return 0
        return recurstion(root.right) + recurstion(root.left)
    }
}


fun minCostToMoveChips(position: IntArray): Int {
    val x = 40
    when (x) {
        3, 4 -> println("gf")
        else -> println()

    }
    val countEven = position.count { it % 2 == 0 }
    return minOf(countEven, position.size - countEven)
}

fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    Arrays.sort(nums)
    val result = IntArray(queries.size)
    for (i in 1 until nums.size) {
        nums[i] += nums[i - 1]
    }
    for (i in queries.indices) {
        val idx = Arrays.binarySearch(nums, queries[i])
        result[i] = Math.abs(idx + 1)
    }
    return result
}

fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    return target.sortedArray().contentEquals(arr.sortedArray())
}


fun canBeTypedWords(text: String, brokenLetters: String): Int {
    return text.split(" ").count { element ->
        element.none { brokenLetters.contains(it) }
    }

}

fun countGoodSubstrings(s: String): Int {
    return s.windowed(3, 1, false).count {
        it.toSet().size == 3
    }
}

fun smallestEqual(nums: IntArray): Int {
    return nums.withIndex().firstOrNull { (index, value) ->
        index.mod(10) == value
    }?.index ?: -1
}

fun minSubsequence(nums: IntArray): List<Int> {
    val temp = mutableListOf<Int>()
    for (lastIndex in nums.lastIndex downTo 0) {
        temp.add(nums[lastIndex])
        if (temp.sum() >= nums.slice(0..<lastIndex).sum()) break
    }
    return temp
}

fun countPrefixes(words: Array<String>, s: String): Int {

    return words.count { string ->
        var counter = 0
        string.all {
            s.getOrNull(counter++) ?: '%' == it
        }
    }
}

fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    arrayOf(*nums1, *nums2)
    return (nums1 + nums2).groupBy {
        it.first()
    }
        .map { entry -> intArrayOf(entry.key, entry.value.sumOf { it[1] }) }.sortedBy { it[0] }
        .toTypedArray()
}

fun generate(numRows: Int): List<List<Int>> {
    val list = mutableListOf<MutableList<Int>>()
    repeat(numRows) { row -> // 1
        list.add(MutableList(row + 1) { index ->
            when (index) {
                0, row -> 1
                else -> list[row - 1][index - 1] + list[row - 1][index]
            }
        })
    }
    for (verticalIndex in 0..numRows - 2) {
        val copy = list[verticalIndex].toList().toMutableList()
        if (verticalIndex == 0) {
            list.add(mutableListOf(1, 1))
            continue
        }
        for (listIndex in 0..<list[verticalIndex].lastIndex) {
            val sumOfTwoNeighbours = list[verticalIndex][listIndex] + list[verticalIndex][listIndex + 1]
            if (copy[listIndex + 1] != 1) copy.remove(copy[listIndex + 1])
            copy.add(listIndex + 1, sumOfTwoNeighbours)
        }
        list.add(copy)
    }
    return list
}


fun findEvenIndex(arr: IntArray): Int {
    // your code
    for (index in arr.indices) {

        var leftSum = arr.slice(0..<index).sum()
        var rightSum = arr.slice(index + 1..<arr.size).sum()
        if (leftSum == rightSum) return arr[index]
    }
    return -1
}

fun digPow(n: Int, p: Int): Int {
    // ...
    Int.MAX_VALUE
    var copy = p
    val result = "$n".fold(0) { acc, char ->
        acc + char.digitToInt().toDouble().pow(copy++).toInt()
    }
    println("result = $result")
    if (result % n == 0) return result / n else return -1
}

fun find(integers: Array<Int>): Int {
    return integers.singleOrNull { it % 2 == 0 } ?: integers.first { it % 2 == 0 }
}

fun duplicateCount(text: String): Int {

    return text.lowercase().toSet().count {// a b c
        text.lowercase().count(Char::equals) > 1
    }
}

fun spinWords(sentence: String): String {
    // Your code goes here!
    return sentence.split(" ").joinToString(" ") { if (it.count() >= 5) it.reversed() else it }
}

fun solution(number: Int) = (3..number step 3).union((5..<number step 5)).sum()

fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
    val listOfVowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
    return words.slice(left..right).count {
        it.first() in listOfVowels && it.last() in listOfVowels
    }
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = arr.associateBy({ it }, { n ->
        arr.count { it == n }
    })
    return map.values.size == map.values.distinct().size
}

fun minimizedStringLength(s: String): Int {
    return s.replace("(\\w)(?=.*\\1)".toRegex(), "").count()
}

fun numberOfPoints(nums: List<List<Int>>): Int {
    return hashSetOf<Int>().apply {
        nums.forEach {
            for (i in it[0]..it[1]) this.add(i)
        }
    }.count()
}

fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {

    val map = hashMapOf<Int, Int>().apply {
        items1.forEach {
            this[it[0]] = it[1]
        }
        items2.forEach { arr ->
            this[arr[0]] = this.getOrDefault(arr[0], 0) + arr[1]
        }
    }
    return map.toList().asSequence().sortedBy { it.first }.toMap().map { listOf(it.key, it.value) }
}


fun judgeCircle(moves: String): Boolean {
    return moves.fold(0 to 0) { acc, direction ->
        when (direction) {
            'U' -> (acc.first + 1) to acc.second
            'D' -> (acc.first - 1) to acc.second
            'L' -> acc.first to (acc.second + 1)
            else -> acc.first to (acc.second - 1)
        }
    }.let { it.first == 0 && it.second == 0 }
}

fun rowAndMaximumOnes(mat: Array<IntArray>) = mat.foldIndexed(intArrayOf(0, 0)) { index, intArray, row ->
    val count = row.count { it == 1 }
    if (count > intArray[1]) {
        intArray[0] = index;intArray[1] = count
        intArray
    } else intArray
}


fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    return endTime.foldIndexed(0) { index, acc, endTime ->
        if (queryTime in startTime[index]..endTime) acc + 1 else acc
    }
}

fun minTimeToType(word: String): Int {
    var seconds = 0
    var current = 'a'
    word.forEachIndexed { index, target ->
        if (current == word[index]) seconds += 1 // just read it
        else {
            seconds += min(abs(word[index] - current), 26 - abs((current - word[index]))) + 1
        }
        current = word[index]
    }
    return seconds
}

fun potatoes(initialWaterPercent: Int, initialWeight: Int, finalWaterPercent: Int): Int {
    return initialWeight * (100 - initialWaterPercent) / (100 - finalWaterPercent)
}

fun hidePasswordFromConnection(urlString: String): String {
    return "(?<=password=)[^&]*".toRegex().replace(urlString) {
        "*".repeat(it.value.length)
    }
}


fun moveTen(s: String): String {
    return s.map {
        'a' + (((it - 'a') + 10) % 26)
    }.joinToString("")
}

fun dbSort(a: Array<Any>): Array<Any> = (
        a.filterIsInstance<Int>().sortedBy { it } + a.filterIsInstance<String>().sortedBy { it }).toTypedArray()

fun argsCount(vararg args: Any): Int {
    Int::class.isInstance(3)
    String::class.isInstance("gdf")
    return args.size
}

fun outed(meet: Map<String, Int>, boss: String): String {
    return if ((meet.values.sum() + meet[boss]!!) / meet.size <= 5) "Get Out Now!" else "Nice Work Champ!"
}

fun maxRot(n: Long): Long {
    // your code
    val list = mutableListOf<String>(n.toString())
    for (i in 0..<"$n".length - 1) {
        var left = list[i].take(i)
        var right = list[i].drop(i).reversed()
        list.add((left.plus(right)))
    }
    return list.max().toLong()
}

fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
    var currentHeight = 0;
    var c = 0
    while (currentHeight < desiredHeight) {
        c++
        currentHeight += (upSpeed - downSpeed)
    }
    return c
}


fun vertMirror(strng: String): String {
    Year.of(4343).isLeap
    return strng.split("\n").map { it.reversed() }.joinToString("\n")
}

fun horMirror(strng: String): String {
    strng.splitToSequence("\n").forEach { println(it) }
    return strng.reversed()
}

fun oper(action: (String) -> String, s: String) {
    action(s)
}

val oper = { fn: (String) -> String, s: String ->
    fn(s)
}

fun fizzBuzz(n: Int): Array<String> {
    val list = (1..n).map { i ->
        when {
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> "$i"
        }
    }
    println(list)
    return list.toTypedArray()
}

fun evenNumbers(array: List<Int>, number: Int) = IntArray(number).apply {
    var c = 0
    for (index in array.lastIndex downTo number - 1) if (array[index] and 0x1 == 0) this[index] = array[index]
}

fun alphabetWar(fight: String): String {
    // code here
    val leftMap = mapOf<Char, Int>('w' to 4, 'p' to 3, 'b' to 2, 's' to 1)
    val rightMap = mapOf<Char, Int>('m' to 4, 'q' to 3, 'd' to 2, 'z' to 1)

    var leftSide = 0;
    var rightSide = 0
    fight.forEach {
        leftSide += leftMap.getOrDefault(it, 0)
        rightSide += rightMap.getOrDefault(it, 0)
    }
    return if (leftSide > rightSide) "Left side wins!"
    else if (rightSide > leftSide) "Right side wins!"
    else "Let's fight again!"
}

fun capitalize(text: String): List<String> {
    //TODO: Add your code!
    text.mapIndexed { index, value -> if (index and 0x1 == 0) value.uppercase() else value.lowercase() }.also {

    }
    val firstBuiler = StringBuilder()
    val secondBuilder = StringBuilder().apply {
        text.withIndex().forEach { (index, value) ->
            if (index and 0x1 == 0) {
                append(value + 26)
                firstBuiler.append(value)
            } else {
                append(value)
                firstBuiler.append(value + 26)
            }
        }
    }
    return listOf(firstBuiler.toString(), secondBuilder.toString())
}

fun solve(s: String): String {
    if (s.isEmpty()) return ""
    val countUpperCase = s.count(Char::isUpperCase)
    val isEven = s.length and 0x1 == 0
    return when {
        countUpperCase > s.length / 2 -> s.uppercase()
        countUpperCase < s.length / 2 -> s.lowercase()
        else -> s.lowercase()
    }
}

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
    return a1.flatMap { s1 -> a2.map { abs(s1.length - it.length) } }.max()
}

fun maxMultiple(divisor: Int, bound: Int): Int {
    return (bound downTo 1).find { divisor % bound == 0 } ?: 1
}

fun reverseLetter(str: String): String {

    return str.reversed().filter(Char::isLetter)
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    ages.sorted().slice(ages.lastIndex - 1..ages.lastIndex)
    return PriorityQueue<Int>().apply { ages.forEach { offer(it) } }.run {
        listOf(this.poll(), this.poll())
    }
}

fun printerError(s: String): String {
    return "${s.count { it !in 'a'..'m' }}" + "/${s.length}"
}

fun longest(s1: String, s2: String): String {
    return s1.plus(s2).toSortedSet().joinToString("")
}

fun makeComplement(dna: String): String {
    val map1 = "ACTG".zip("TGAC").toMap()
    println(map1.keys + "Value " + map1.values)
    dna.map {
        map1[it]
    }
    return StringBuilder().apply {
        dna.forEach {
            when (it) {
                'A' -> append('T')
                'T' -> append('A')
                'C' -> append('G')
                'G' -> append('C')
                else -> append("")
            }
        }
    }.toString()
}

fun accum(s: String) =
    s.mapIndexed { index, c -> c.uppercase() + c.lowercase().padEnd(index + 1, 'c') }.joinToString("-")

fun findShort(s: String): Int {
    return s.split(" ").minOfOrNull {
        it.length
    } ?: 1
}

fun squareSum(n: Array<Int>): Int {
    return n.sumOf { it.toDouble().pow(2.toDouble()) }.toInt()
}

fun getMiddle(word: String): String {
    return if ((word.length) and 0x1 == 0) "${word[word.length / 2 - 1]}${word[word.length / 2]}"
    else "${word[word.length / 2]}"
}

fun sum(numbers: IntArray) = numbers.fold(0) { acc, it ->
    if (it.coerceAtLeast(0) > 0) acc + it
    else acc
}

fun highAndLow(numbers: String): String {
    val queue = PriorityQueue<Int>()
    val list: List<String> = numbers.split(' ')
    return "${queue.max()} ${queue.min()}"
}

fun countSeniors(details: Array<String>): Int {
    val pattern = "^.{11}[6-9][0-9]".toRegex()
    return details.count { pattern.containsMatchIn(it) }
}

fun heightChecker(heights: IntArray) = heights.clone().sortedArray().foldIndexed(0) { index, acc, i ->
    if (heights[index] != i) acc + 1 else acc
}

fun sortArrayByParity(nums: IntArray): IntArray {
    var length = 0

    for (i in nums.indices) {
        if (nums[i] % 2 == 0) {
            nums.swap(length++, i)
        }
    }

    return nums
}

private fun IntArray.swap(first: Int, second: Int) {
    val temp = get(first)
    set(first, get(second))
    set(second, temp)
}

//fun repeatedNTimes(nums: IntArray): Int {
//return (nums - nums.toSet() ).size
//}
fun isplain(s: String): Int {
    var left = 0;
    var right = s.length - 1
    while (left <= right && s[left] == s[right]) {
        left++; right--
    }
    if (left > right) return 1 else return 2
}

fun distinctDifferenceArray(nums: IntArray): IntArray {
    val prefixMap = mutableMapOf<Int, Int>()
    val suffixMap = mutableMapOf<Int, Int>()
    val result = IntArray(nums.size)

    nums.forEach {
        suffixMap[it] = suffixMap.getOrDefault(it, 0) + 1
    }

    nums.forEachIndexed { i, num ->
        prefixMap[num] = prefixMap.getOrDefault(num, 0) + 1
        suffixMap[num] = suffixMap.getOrDefault(num, 0) - 1

        if (suffixMap[num] == 0)
            suffixMap.remove(num)

        result[i] = prefixMap.size - suffixMap.size
    }
    return result
}

fun sumZero(n: Int): IntArray {
    var k = 1
    val list = IntArray(n) { k++ }
    list[n - 1] -= n * k / 2
    return list
}

fun middleNode(head: ListNode?, fast: ListNode? = head): ListNode? =
    if (fast?.next == null) head else middleNode(head?.next, fast?.next?.next)

fun sumOfUnique(nums: IntArray): Int {
    var sum = 0
    val map = hashMapOf<Int, Int>().apply {
        nums.forEach {
            this[it] = this.getOrDefault(it, 0) + 1
            if (this.containsKey(it) && this[it] == 1) sum += it
            if (this[it] == 2) sum -= it
        }
    }
    return sum
}


fun findNonMinOrMax(nums: IntArray): Int {
    if (nums.size <= 2) return -1
    nums.indexOf(nums.min())
    val priorityQueue = PriorityQueue<Int>().apply {
        for (num in nums) this.add(num)
    }
    priorityQueue.poll()
    return priorityQueue.poll()
}

fun findNumbers(nums: IntArray): Int = nums.fold(0) { acc, it ->
    if ("$it".count() % 2 == 0) acc + 1 else acc
}

fun areOccurrencesEqual(s: String): Boolean {
    val map = hashMapOf<Int, Char>()
    val grouped = s.groupBy {
        it
    }
    grouped.forEach {
        println("${it.key} -> ${it.value}")
        map[it.value.size] = it.key
    }
    return map.size == 1

}

fun destCity(paths: List<List<String>>): String = hashMapOf<String, Int>().apply {
    paths.forEach {
        this[it.first()] = this.getOrDefault(it.first(), 0) + 1
        this[it.last()] = this.getOrDefault(it.last(), 0)
    }
}.run {
    this.entries.find {
        it.value == 0
    }!!.key
}

fun countNegatives(grid: Array<IntArray>): Int {
    return grid.sumOf {
        it.count { it < 0 }
    }
}

fun reverseString(s: CharArray): Unit {
    for (index in s.indices) {
        if (index == s.size / 2) break
        s[index] = s[s.lastIndex - index].also {
            s[s.lastIndex - index] = s[index]
        }
    }
}

tailrec fun reverseUsingRecursion(s: CharArray, index: Int) {
    if (index == s.size / 2) return
    val temp = s[index]
    s[index] = s[s.lastIndex - index]
    s[s.lastIndex - index] = temp
    reverseUsingRecursion(s, index + 1)
}


fun prefixCount(words: Array<String>, pref: String): Int {

    val pattern = "^${pref}".toRegex()
    return words.count { word ->
        pattern.containsMatchIn(word)
    }
}


fun halvesAreAlike(s: String): Boolean {

    val regex = """[aeiouAEIOU]""".toRegex()
    val pattern = "(.{${s.length / 2}})".toRegex()
    val list: List<String> = s.split(pattern)
    println(list.last())
    println(list.first())
    return regex.findAll(list.first()).count() == regex.findAll(list.elementAt(1)).count()
}


fun countBits(n: Int): IntArray {
    val list = mutableListOf<Int>()
    countRecursive(0, n, list)
    return list.toIntArray()
}

tailrec fun countRecursive(number: Int, n: Int, list: MutableList<Int>) {
    if (number > n) return
    list.add(Integer.toBinaryString(number).count { it == '1' })
    countRecursive(number + 1, n, list)
}

fun generateTheString(n: Int): String {
    var result = StringBuilder()

    repeat(n - 1) {
        result.append('a')
    }
    if (n % 2 == 0) return result.append('z').toString() else return result.append('a').toString()
}

fun arrayPairSum(nums: IntArray): Int {
    val queue = PriorityQueue<Int>()
    for (i in nums) queue.offer(i)
    return queue.filterIndexed { index, i -> index % 2 == 0 }.sum()
}

fun diStringMatch(S: String): List<Int> {
    var i = 0
    var d = S.length
    return S.plus(S[d - 1]).map {
        if (it == 'I') i++
        else d--
    }
}

fun squareIsWhite(coordinates: String) = (coordinates[0].toInt() + coordinates[1].toInt()) % 2 != 0
fun selfDividingNumbers(left: Int, right: Int) = (left..right).filter {
    !"$left".contains('0') && "$left".all { left % (it - '0') == 0 }
}

fun selfRecursive(left: Int, right: Int, result: MutableList<Int>) {

    if (left > right) return

    if ("$left".contains('0') && "$left".all { left % (it - '0') == 0 }) result.add(left)

    selfRecursive(left + 1, right, result)
}

fun deleteGreatestValue(grid: Array<IntArray>): Int {
    val sortedGrid = mutableListOf<PriorityQueue<Int>>()
//    val sortedGrid: List<List<Int>> = grid.map { it.sorted() }

    // now adding priority queue
    grid.forEach {
        val priorityQueue = PriorityQueue<Int>()
        for (i in it) priorityQueue.offer(i)
        sortedGrid.add(priorityQueue)
    }
    val columns: IntRange = sortedGrid.first().indices
    return columns.sumOf { vertical ->
        sortedGrid.map { horizontal -> horizontal.poll() }.reduce(::maxOf)
    }
}

fun separateDigits(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()
    nums.asSequence().map {
        "$it".forEach {
            result.add(it - '0')
        }
    }
    return result.toIntArray()
}

fun isSameAfterReversals(num: Int) = num == 0 || num % 10 != 0

fun increasingBST(root: TreeNode?): TreeNode? {
    val list = mutableListOf<Int>()
    inOrder(root, list)
    val ans = TreeNode(0)
    var current = ans
    list.forEach {
        current.right = TreeNode(it)
        current = current.right!!
    }
    return ans.right

}

fun inOrder(node: TreeNode?, vals: MutableList<Int>) {
    node ?: return
    inOrder(node.left, vals) // find left most node
    vals.add(node.`val`) // add value of left most node
    inOrder(node.right, vals) // find the right most node
}

fun findDifference(nums1: IntArray, nums2: IntArray) = run {
    val result = nums1.toSet()
    val list1 = nums2.toSet()
    listOf(
        result.filter { it !in list1 },
        list1.filter { it !in result }
    )
}

fun countGoodRectangles(rectangles: Array<IntArray>) = run {
    val map = TreeMap<Int, Int>()
    rectangles.forEach {
        val min = it.min()
        map[min] = map.getOrDefault(min, 0) + 1
    }
    map.getOrDefault(map.lastKey(), -1)
}


fun sumOfSquares(nums: IntArray) = run {
    val size = nums.size
    nums.foldIndexed(0) { index, acc, i ->
        if (size.mod(i) == 0 || size.mod(i) == size) {
            println(acc + i * i)
            i * i + acc
        } else acc
    }
}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    root ?: return null
    if (root?.`val` == `val`) return root
    val left = searchBST(root?.left, `val`)
    val right = searchBST(root?.right, `val`)
    if (left == null && right == null) return null
    if (left != null) return left
    return right
}


fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1
    root1.`val` += root2.`val`
    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)
    return root1
}

fun firstPalindrome(words: Array<String>): String =
    words.find { it == it.reversed() } ?: ""

fun commonFactorsRecursive(a: Int, b: Int, k: Int): Int {
    if (k == 1) return 1
    if (a % k == 0 && b % k == 0) {
        return 1 + commonFactorsRecursive(a, b, k = if (k % 2 == 0) k / 2 else k - 1)
    } else {
        return commonFactorsRecursive(a, b, (k - 1) / 2)
    }
}

fun commonFactors(a: Int, b: Int): Int {
    return (1..min(a, b)).count { a % it == 0 && b % it == 0 }
}

fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int) =
    (arrivalTime + delayedTime >= 24) ?: {
        (arrivalTime + delayedTime) - 24
        (arrivalTime + delayedTime)
    }

fun mergeAlternately(word1: String, word2: String): String {

    var i1 = 0
    var i2 = 0
    val result = StringBuilder(word1)
    while (i1 < word1.length && i2 < word2.length) {
        result.append(word1[i1++]).append(word2[i2++])
    }
    if (i1 < word1.length) result.append(word1.substring(i1))
    if (i2 < word2.length) result.append(word2.substring(i2))
    return result.toString()
}

fun countPairs(nums: IntArray, k: Int): Int {
    val grouped = nums.withIndex().groupBy { (index, num) ->
        num
    }
    val mapped = grouped.map { (_, value) -> value.map { it.index } }
    val countPairs = mapped.map { countValidPairs(it, k, 0) }
    return countPairs.sum()
}

private tailrec fun countValidPairs(indexes: List<Int>, k: Int, validPairs: Int): Int =
    if (indexes.size < 2) validPairs
    else {
        val newValidPairs = indexes.count {
            it != indexes.first() && (indexes.first() * it) % k == 0
        }
        countValidPairs(indexes.drop(1), k, validPairs + newValidPairs)
    }

fun freqAlphabets(s: String): String {
    var result = String(s.toCharArray())
    val map = buildMap()
    map.keys.forEach {
        result =
            result.replace(
                it,
                map[it].toString()
            ) // Replace all occurences of '#' strings with it's correspondng chars
    }
    result = """([123456789])""".toRegex().replace(result) { char -> "${char.value[0] + 48}" } // explained above
    return result
}

// builds map from 10#:j....26#:z
fun buildMap(): Map<String, Char> { // Map of <String, Char> to save space instead of <String,String>
    val map = HashMap<String, Char>()
    var ascii = 106 // ascii value of 'j'
    for (i in 10..26) { // Iterating from 10 to 26
        map[i.toString().plus("#")] = ascii.toChar()
        ascii++
    }
    return map
}

fun reversePrefix(word: String, ch: Char): String {
    return if (!word.contains(ch)) ""
    else StringBuilder().apply {
        val indexOf = word.indexOf(ch)
        append(word.slice(0..indexOf).reversed())
        append(word.subSequence(indexOf..word.lastIndex))
    }.toString()
}

fun pivotInteger(n: Int): Int {
    (n downTo 1).forEach {
        if (
            (1..it).sum() == (it..n).sum()
        ) return it
    }
    return -1
}

fun sortPeople(names: Array<String>, heights: IntArray) = names.withIndex()
    .sortedByDescending {
        heights[it.index]
    }.map {
        it.value
    }
//    return map.values.toList()


fun maximumNumberOfStringPairs(words: Array<String>): Int {
    words.groupingBy { it.toSortedSet() }.eachCount().count {
        it.value > 1
    }
    var counter = 0
    words.forEach { word ->
        if (words.contains(word.reversed()) && word != word.reversed()) counter += 1
    }
    return if (counter % 2 == 0) counter / 2 else (counter + 1) / 2
}

fun replaceDigits(s: String): String {
    val result = StringBuilder()
    var char = 'a'
    for (i in s.indices) {
        if (s[i].isLetter()) {
            char = s[i]
            result.append(char)
        }
        result.append((s[i].toInt() - '0'.toInt()))
    }
    return result.toString()
}

fun maxProductDifference(nums: IntArray): Int {
    var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    var minHeap = PriorityQueue<Int>()

    nums.forEach {
        maxHeap.offer(it)
        if (maxHeap.size > 2) {
            maxHeap.poll()
        }
    }
    nums.forEach {
        minHeap.offer(it)
        if (minHeap.size > 2) {
            minHeap.poll()
        }
    }

    return Math.abs((maxHeap.poll() * maxHeap.poll()) - (minHeap.poll() * minHeap.poll()))
}

fun flipAndInvertImage(image: Array<IntArray>) =
    image.map { it.map { if (it == 1) 0 }.reversed() }

fun getDecimalValue(head: ListNode?): Int {
    return helper(head, mutableListOf()).toString().toInt(2)
}

fun helper(current: ListNode?, list: MutableList<Int>): List<Int> {
    if (current == null) return list
    list.add(current.`val`)
    return helper(current.next, list)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun maximizeSum(nums: IntArray, k: Int): Int {
    var sum = 0
    repeat(k) {
        val temp = nums.max()
        sum += temp
        val indexOfMax = nums.indexOf(temp)
        nums[indexOfMax] = temp + 1
    }
    return sum
}

fun maxDepth(s: String): Int {
    var max = Int.MIN_VALUE
    s.fold(0) { acc, it ->
        if (acc > max) max = acc
        when (it) {
            '(' -> acc + 1
            ')' -> acc - 1
            else -> acc
        }
    }
    return max
}

fun countAsterisks(s: String): Int {
    return s.windowed(1, 2).map { string ->
        string.count { it == '*' }
    }.sum()
}

fun reverseWords(s: String): String {
    return s.split(' ').joinToString(" ") { it.reversed() }
}

fun maximum69Number(num: Int): Int =
    num + 3 * (arrayOf(1000, 100, 10, 1).firstOrNull { num / it % 9 != 0 } ?: 0)

fun finalString(s: String): String = StringBuilder().apply {
    s.forEach { if (it == 'i') this.reverse() else this.append(it) }
}.toString()

//
//fun uniqueMorseRepresentations(words: Array<String>): Int =
//    words.map { word ->
//        word.map { char -> array[char - 'a'] }.joinToString("")
//    }.distinct().size


fun countConsistentStrings(allowed: String, words: Array<String>): Int = words.count { word ->
    word.all { allowed.contains(it) }
}

fun diagonalSum(mat: Array<IntArray>): Int {
    var sum = 0
    for ((i, j) in mat.indices.withIndex())
        sum += mat[i][j] + mat[i][mat.size - 1 - j]
    if (mat.size % 2 != 0)
        sum -= mat[mat.size / 2][mat.size / 2]
    return sum
}


fun toLowerCase(s: String): String = StringBuilder().apply {
    s.forEach {
        if (it in 'A'..'Z') append(it + 32) else append(it)
    }
}.toString()

fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
//    val firstArray = grid[0].toList().chunked(3).map {
//        it.max()
//    }.max()
    val result: MutableList<IntArray> = mutableListOf<IntArray>()
    val horizontalArray = Array(if (grid[0].size / 2 == 0) grid[0].size / 2 else grid[0].size / 2 + 1) { 0 }
    for (vertical in 0..grid[0].size - 3) {
        // max of horizontal
        for (i in 0..grid[vertical].size - 3) {
            val firstMax = grid[vertical].slice(i..i + 2).max()
            val secondMax = grid[vertical + 1].slice(i..i + 2).max()
            val thirdMax = grid[vertical + 2].slice(i..i + 2).max()
            val max = maxOf(firstMax, secondMax, thirdMax)
            horizontalArray[i] = max
        }
        result.add(vertical, horizontalArray.toIntArray())
    }
    return result.toTypedArray()
}

fun countKDifference(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var count = 0
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
        println(map[num])
        count += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0)
    }
    return count
}


fun numberOfMatches(n: Int): Int {

    var totalMatches = 0
    var teams = n
    while (teams > 1)
        if (teams % 2 == 0) {
            teams /= 2
            totalMatches += teams
        } else {
            teams = (teams - 1) / 2
            totalMatches += teams
        }
    return totalMatches
}


fun sumOddLengthSubarrays(arr: IntArray): Int {
    var sum = 0
    var oddFrame = 1
    val arraySize = arr.size
    while (oddFrame <= arraySize) {

        for (index in 0..arraySize - oddFrame) {
            val subArray = arr.slice(index..index + oddFrame - 1)
            sum += subArray.sum()
        }
        oddFrame += 2
    }
    return sum
}

//    fun sumOddRecursive(arr: IntArray, firstIndex: Int, lastIndex: Int): Int {
//        if (lastIndex >= arr.size) return 0
//        var sum = 0
//        for (index in firstIndex..lastIndex) sum += arr[index]
//        return sum + sumOddRecursive(arr, index + 2)
//    }

fun sortSentence(s: String): String =
    s.split(' ').asSequence().sortedBy { sentence -> sentence.last() - '0' }.joinToString(" ") { sentence ->
        sentence.dropLast(1)
    }

fun countDigits(num: Int): Int = "$num".fold(0) { acc, it -> if (num - (it - '0') == 0) acc + 1 else acc }


fun arithmeticTriplets(nums: IntArray, diff: Int): Int = nums.fold(0) { acc, it ->
    if (nums.contains(it + diff) && nums.contains(it + 2 * diff)) {
        acc + 1
    } else {
        acc

    }
}


fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    return word1.contentToString() == word2.contentToString()
}

fun differenceOfSum(nums: IntArray): Int = nums.sumOf { number ->
    abs(number - number.toString().sumOf { it - '0' })
}

fun decodeMessage(key: String, message: String): String {

    val map = HashMap<Char, Char>()
    for (char in key) if (char != ' ') map.putIfAbsent(char, 'a' + map.size)
    val builder = StringBuilder()
    for (char in message) builder.append(map.getOrDefault(char, ' '))
    return builder.toString()

}

// one's + tens after sorting.
fun minimumSum(num: Int): Int {
    val digits = "$num".map { Character.getNumericValue(it) }.sorted()
    return "${digits[0]}${digits[2]}".toInt() + "${digits[1]}${digits[3]}".toInt()
}

fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    val sum = 0
    return hours.sumOf { hours ->
        if (hours >= target) sum + 1 else sum
    }
}

fun sumOfMultiples(ni: Int): Int = (1..ni).fold(0) { acc, it ->
    if (it % 3 == 0 || it % 5 == 0 || it % 7 == 0) acc + it
    else acc
}

fun cellsInRange(s: String): List<String> {
    val linkedList = LinkedList<String>()
    for (row in s[0]..s[3]) {
        for (col in s[1]..s[4]) linkedList.add("$row$col")
    }
    return linkedList
}

fun recursiveCells(
    firstChar: Char,
    lastChar: Char,
    smallNumber: Int,
    largeNumber: Int,
    result: MutableList<String>
): MutableList<String> {
    if (firstChar > lastChar) return result
    for (number in smallNumber..largeNumber)
        result.add("${firstChar}${number}")


    return recursiveCells(firstChar + 1, lastChar, smallNumber, largeNumber, result)
}


fun findIntLength(n: Int): Int {
    if (n <= 9) return 1
    return 1 + findIntLength(n.div(10))
}

//        nums[index] = start + 2 * index
fun truncateSentence(s: String, k: Int): String {

    return trecursive(s.split(' '), StringBuilder(), k).toString()
}

fun trecursive(original: List<String>, string: StringBuilder, k: Int): StringBuilder {
    if (k == 0) return string
    return trecursive(
        original.dropWhile { it != " " },
        string.append(" ${original.take(2)}"), k - 1
    )

}


fun balancedStringSplit(s: String): Int {
    var result = 0
    s.foldIndexed(0) { index, acc, currentChar ->
        if (acc == 0 && index != 0) result += 1
        if (currentChar == 'L') {
            acc + 1
        } else {
            acc - 1
        }
    }
    return result
}

fun recursion(s: String, index: Int): Int {
    if (index > s.length) return 0

    val left = s.substring(0, index)
    val right = s.substring(index, s.length)
    println("left = $left, right = $right")
    if (isStringBalanced(left, right)) return 1 + recursion(s, index + 1)
    else return recursion(s, index + 1)
}

fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    val sortedArray = students.sortedArray()
    var totalMoves = 0
    seats.sortedArray().forEachIndexed { index, value ->
        totalMoves += abs(value.minus(sortedArray[index]))
    }
    return totalMoves
}

fun recursive(
    numberOfRepetitions: Int,
    repeatedNumber: Int,
    list: MutableList<Int>,
    nums: IntArray
): List<Int> {
    if (nums.isEmpty()) return listOf()
    repeat(numberOfRepetitions) {
        list.add(repeatedNumber)
    }
    return recursive(nums.first(), nums[1], list, nums.drop(2).toIntArray())
}

fun decompressRLElist(nums: IntArray): IntArray {
    if (nums.size % 2 != 0) nums.dropLast(1)
    val list = mutableListOf<Int>()

    return recursive(nums[0], nums[1], list, nums.drop(2).toIntArray()).toIntArray()
}

fun decompressRLgElist(nums: IntArray): IntArray {
    val list = mutableListOf<Int>()
    decompress(nums, 0, mutableListOf<Int>())
    return list.toIntArray()
}


private fun isStringBalanced(left: String, right: String): Boolean =
    (left.count { it == 'R' } == left.count { it == 'L' })
            && (right.count { it == 'R' } == right.count { it == 'L' })


fun decompress(nums: IntArray, index: Int, result: MutableList<Int>) {
    if (index >= nums.size) {
        return
    }
    val frequency = nums[index]
    val value = nums[index + 1]
    repeat(frequency) {
        result.add(value)
    }
    decompress(nums, index + 2, result)
}

fun decode(encoded: IntArray, first: Int): IntArray {
    val result = IntArray(encoded.size + 1)
    result[0] = first
    encoded.forEachIndexed { index, value ->
        result[index + 1] = value xor result[index]
    }
    return result
}

fun leftRightDifference(nums: IntArray): IntArray {
    var rightSum = nums.sum()
    var rights = (1 until nums.size).sumOf { nums[it] }
    var leftSum = 0

    for (index in nums.indices) {
        nums[index] = abs(leftSum - (rightSum - nums[index]))
        leftSum += nums[index]
    }
    return nums
}

fun subtractProductAndSum(n: Int): Int {
    var product = 1
    val digits = "$n".map(Character::getNumericValue)
    digits.forEach { product *= it }
    return product - digits.sum()
}

private fun Any.print() {
    println(this)
}

fun maxProfit(prices: IntArray): Int {
    prices.foldIndexed<Int>(prices[0]) { i, min, n ->
        prices[i] = n - min
        if (n < min) n else min
    }
    if (prices.isEmpty()) return 0
    var small = 0
    var large = 1
    var result = 0
    while (large < prices.size) {
        val currentDifference = prices[large] - prices[small]
        result = max(currentDifference, result)
        if (currentDifference < 0) small = large
        large++
    }
    return result
}

fun countListItems(list: List<Int>): Int {
    if (list.isEmpty()) return 0
    return 1 + countListItems(list.drop(1))
}

fun maxOfList(list: List<Int>): Int {
    if (list.size == 1) return list[0]

    val first = list[0]
    val rest = list.drop(1)
    val max = maxOfList(rest)

    return if (first > max) first else max
}

fun simpleArraySum(ar: Array<Int>): Int {
    return arraySum(ar, index = 0)

}

fun arraySum(ar: Array<Int>, index: Int = 0): Int {
    if (ar.size == index) return 0
    return ar[index] + arraySum(ar, index + 1)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>(nums.size)
    nums.forEachIndexed { index, i ->
        map.put(i, index)
    }
    var test = 0
    for (index in 0 until nums.size) {
        test = target - nums[index]
        val value = map.get(test)
        if ((value != null) && !value.equals(index)) {
            return intArrayOf(index, value)
        }
    }
    return intArrayOf()
}

fun String.isValidParentheses(): Boolean {
    val p = '(' to ')'
    val b = '[' to ']'
    val k = '{' to '}'

    for ((index, value) in withIndex()) {
        if (index % 2 == 0) {
            val nextChar = getOrNull(index + 1)
            if (!when (value) {
                    p.first -> p.second == nextChar
                    b.first -> b.second == nextChar
                    k.first -> k.second == nextChar
                    else -> false
                }
            ) {
                return false
            }
        }
    }

    return true
}

fun isValid(s: String): Boolean {
    if (s.isEmpty() || s.last() == '(' || s.last() == '{' || s.last() == '[') return false
    val stack = Stack<Char>()
    var counter = 0
    var flag = false
    try {
        while ((counter < s.length)) {
            when (s[counter]) {
                '(' -> stack.push('(')
                '{' -> stack.push('{')
                '[' -> stack.push('[')
                ')' -> if (stack.peek() != '(') {
                    flag = false
                    return false
                } else {
                    stack.pop(); flag = true
                }

                '}' -> if (stack.peek() != '{') {
                    flag = false
                    return false
                } else {
                    stack.pop(); flag = true
                }

                ']' -> if (stack.peek() != '[') {
                    flag = false
                    return false
                } else {
                    stack.pop(); flag = true
                }

                else -> flag = false
            }
            counter++
        }
    } catch (e: Exception) {
        return false
    }
    return flag
}


fun interpret(command: String): String {
    var result = StringBuilder()

    for ((index, char) in command.withIndex()) {
        if (char == 'G') {
            result.append('G')
            continue
        } else if (command.get(index + 1) == ')' && char == '(') {
            result.append('o')
        } else if (command.get(+1) == 'a' && char == '(') {
            result.append("al")
        }
    }

    return result.toString()
}

fun countPairs(nums: List<Int>, target: Int): Int {
    var result = 0
    for (i in 0 until nums.size - 1) {

        for (j in i.plus(1) until nums.size) {
            if (nums[i] + nums[j] < target) result += 1
        }
    }
    return result
}

fun findJewels(jewels: String, stones: String): Int {
    val stoneCounts = mutableMapOf<Char, Int>()
    for (stone in stones) {
        stoneCounts[stone] = stoneCounts.getOrDefault(stone, 0) + 1
    }
    println(stoneCounts)

    var count = 0
    for (jewel in jewels) {
        count += stoneCounts[jewel] ?: 0
    }

    return count
}

fun defangedIp(ip: String): String {
    ip.replace(".", "[.]")
    var result: String = ""
    ip.forEach {
        if (it == '.') result += "[.]" else result += it
    }
    return result
}

fun <Int> List<Int>.common(list: List<Int>): List<Int> {
    val common = mutableListOf<Int>()

    this.forEach {
        if (list.contains(it)) common.add(it)
    }
    list.forEach {
        if (this.contains(it)) common.add(it)
    }

    return common

}