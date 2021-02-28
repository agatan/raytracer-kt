package raytracer

import kotlin.math.tan

class Camera(
    lookFrom: Point3d,
    lookAt: Point3d,
    vup: Vec3d,
    verticalFieldOfViewInDegrees: Double,
    aspectRatio: Double,
    aperture: Double,
    focusDist: Double
) {
    private val w: Vec3d
    private val u: Vec3d
    private val v: Vec3d
    private val origin: Point3d
    private val horizontal: Vec3d
    private val vertical: Vec3d
    private val lowerLeftCorner: Point3d
    private val lensRadius: Double

    init {
        val theta = degreesToRadians(verticalFieldOfViewInDegrees)
        val h = tan(theta / 2.0)
        val viewportHeight = 2.0 * h
        val viewportWidth = aspectRatio * viewportHeight

        this.w = (lookFrom - lookAt).unit()
        this.u = vup.cross(w).unit()
        this.v = w.cross(u)

        this.origin = lookFrom
        this.horizontal = u * viewportWidth * focusDist
        this.vertical = v * viewportHeight * focusDist
        this.lowerLeftCorner = origin - horizontal / 2.0 - vertical / 2.0 - w * focusDist
        this.lensRadius = aperture / 2.0
    }

    fun ray(s: Double, t: Double): Ray {
        val rd = Vec3d.randomInUnitDisk() * lensRadius
        val offset = u * rd.x + v * rd.y
        return Ray(
            origin + offset,
            lowerLeftCorner + horizontal * s + vertical * t - origin - offset
        )
    }
}
