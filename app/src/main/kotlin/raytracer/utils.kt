package raytracer

import kotlin.math.PI

fun degreesToRadians(degrees: Double) = degrees * PI / 180.0
fun Double.clamp(min: Double, max: Double): Double = when {
    this < min -> min
    this > max -> max
    else -> this
}
