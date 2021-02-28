package raytracer

import kotlin.math.tan

class Camera(
    lookFrom: Point3d,
    lookAt: Point3d,
    vup: Vec3d,
    verticalFieldOfViewInDegrees: Double,
    aspectRatio: Double
) {
    private val origin: Point3d
    private val horizontal: Vec3d
    private val vertical: Vec3d
    private val lowerLeftCorner: Point3d

    init {
        val theta = degreesToRadians(verticalFieldOfViewInDegrees)
        val h = tan(theta / 2.0)
        val viewportHeight = 2.0 * h
        val viewportWidth = aspectRatio * viewportHeight

        val w = (lookFrom - lookAt).unit()
        val u = vup.cross(w).unit()
        val v = w.cross(u)

        this.origin = lookFrom
        this.horizontal = u * viewportWidth
        this.vertical = v * viewportHeight
        this.lowerLeftCorner = origin - horizontal / 2.0 - vertical / 2.0 - w
    }

    fun ray(s: Double, t: Double): Ray = Ray(
        origin,
        lowerLeftCorner + horizontal * s + vertical * t - origin
    )
}
