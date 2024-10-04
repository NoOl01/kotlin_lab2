import kotlin.math.abs
import kotlin.random.Random

data class DistanceResult(val maxDistance: Int, val point1: Int, val point2: Int)

fun main() {
    val result = points()
    println("Между точками ${result.point1 + 1} и ${result.point2 + 1} самое большое растояние: ${result.maxDistance}")
}

fun points(): DistanceResult {
    print("Введите количество точек: ")
    val pointsCount: Int = readln().toInt()
    val pointsArray = IntArray(pointsCount)
    for (i in 0..<pointsCount) {
        val random: Int = Random.nextInt(1, 100)
        pointsArray[i] = random
    }

    pointsArray.sort()

    for (i in 0..<pointsCount) {
        println("точка ${i + 1}: ${pointsArray[i]}")
    }

    return calcDist(pointsCount, pointsArray)
}

fun calcDist(pointsCount: Int, points: IntArray): DistanceResult {
    var maxDistance = 0
    var point1 = 0
    var point2 = 0
    for (i in 0..<pointsCount -1) {
        val distance: Int = abs(points[i] - points[i + 1])
        if (distance > maxDistance) {
            maxDistance = distance
            point1 = i
            point2 = i + 1
        }
    }

    return DistanceResult(maxDistance, point1, point2)
}