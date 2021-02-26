package raytracer

class HitRecord private constructor(val p: Point3d, val t: Double, val normal: Vec3d, val isFrontFace: Boolean) {
    companion object {
        fun create(p: Point3d, t: Double, ray: Ray, outwardNormal: Vec3d): HitRecord {
            val isFrontFace = ray.direction.dot(outwardNormal) < 0.0
            val normal = if (isFrontFace) outwardNormal else -outwardNormal
            return HitRecord(p, t, normal, isFrontFace)
        }
    }
}

interface Hittable {
    fun hit(ray: Ray, timeMin: Double, timeMax: Double): HitRecord?
}
