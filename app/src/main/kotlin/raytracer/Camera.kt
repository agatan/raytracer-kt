package raytracer

class Camera {
    private val origin: Point3d
    private val horizontal: Vec3d
    private val vertical: Vec3d
    private val lowerLeftCorner: Point3d

    constructor() {
        val aspectRatio = 16.0 / 9.0

        val viewportHeight = 2.0
        val viewportWidth = aspectRatio * viewportHeight
        val focalLength = 1.0

        this.origin = Point3d(0.0, 0.0, 0.0)
        this.horizontal = Vec3d(viewportWidth, 0.0, 0.0)
        this.vertical = Vec3d(0.0, viewportHeight, 0.0)
        this.lowerLeftCorner = origin - horizontal / 2.0 - vertical / 2.0 - Vec3d(0.0, 0.0, focalLength)
    }

    fun ray(u: Double, v: Double): Ray = Ray(
        origin,
        lowerLeftCorner + horizontal * u + vertical * v - origin
    )
}
