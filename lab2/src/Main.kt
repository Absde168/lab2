fun main() {
    val N = 10000
    findAmicableNumbers(N)
}

fun sumOfDivisors(num: Int): Int {
    var sum = 1
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            sum += i
            if (i != num / i) {
                sum += num / i
            }
        }
    }
    return sum
}

fun findAmicableNumbers(N: Int) {
    val amicablePairs = mutableSetOf<Pair<Int, Int>>()

    for (i in 2 until N) {
        val sumDivisorsI = sumOfDivisors(i)
        if (sumDivisorsI > i && sumDivisorsI < N) {
            val sumDivisorsJ = sumOfDivisors(sumDivisorsI)
            if (sumDivisorsJ == i) {
                amicablePairs.add(Pair(i, sumDivisorsI))
            }
        }
    }

    if (amicablePairs.isNotEmpty()) {
        println("Пары дружественных чисел, не превышающих $N:")
        amicablePairs.forEach { pair ->
            println("${pair.first} и ${pair.second}")
        }
    } else {
        println("Нет дружественных чисел, не превышающих $N.")
    }
}
