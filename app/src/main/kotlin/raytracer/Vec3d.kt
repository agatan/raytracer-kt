package raytracer

import java.io.Writer
import java.lang.IndexOutOfBoundsException
import kotlin.math.sqrt

class Vec3d(var x: Double = 0.0, var y: Double = 0.0, var z: Double = 0.0) {
    operator fun unaryMinus() = Vec3d(-x, -y, -z)

    operator fun get(i: Int) = when (i) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException()
    }

    operator fun plus(other: Vec3d) = Vec3d(x + other.x, y + other.y, z + other.z)
    operator fun plus(other: Double) = Vec3d(x + other, y + other, z + other)
    operator fun minus(other: Vec3d) = Vec3d(x - other.x, y - other.y, z - other.z)
    operator fun minus(other: Double) = Vec3d(x - other, y - other, z - other)
    operator fun times(other: Vec3d) = Vec3d(x * other.x, y * other.y, z * other.z)
    operator fun times(other: Double) = Vec3d(x * other, y * other, z * other)
    operator fun div(other: Vec3d) = Vec3d(x / other.x, y / other.y, z / other.z)
    operator fun div(other: Double) = Vec3d(x / other, y / other, z / other)

    fun l2norm(): Double = x * x + y * y + z * z
    fun length(): Double = sqrt(l2norm())
    fun unit() = this / length()

    fun dot(other: Vec3d) = x * other.x + y * other.y + z * other.z
    fun cross(other: Vec3d) = Vec3d(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )
}

inline class Point3d(val v: Vec3d)
inline class Color(val v: Vec3d) {
    constructor(x: Double, y: Double, z: Double): this(Vec3d(x, y, z))

    val translatedX
        get() =  (255.99 * v.x).toInt()
    val translatedY
        get() =  (255.99 * v.y).toInt()
    val translatedZ
        get() =  (255.99 * v.z).toInt()
    fun translatedString(): String = "$translatedX $translatedY $translatedZ"
}
