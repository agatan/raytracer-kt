package raytracer

class Hit private constructor(
    val p: Point3d,
    val t: Double,
    val normal: Vec3d,
    val isFrontFace: Boolean,
    val material: Material
) {
    companion object {
        fun create(p: Point3d, t: Double, ray: Ray, outwardNormal: Vec3d, material: Material): Hit {
            val isFrontFace = ray.direction.dot(outwardNormal) < 0.0
            val normal = if (isFrontFace) outwardNormal else -outwardNormal
            return Hit(p, t, normal, isFrontFace, material)
        }
    }

    fun scatter(ray: Ray): Scattered? = material.scatter(ray, this)
}
