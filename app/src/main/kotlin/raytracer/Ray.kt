package raytracer

class Ray(val origin: Point3d, val direction: Vec3d) {
    fun at(t: Double): Point3d = origin + direction * t
}
