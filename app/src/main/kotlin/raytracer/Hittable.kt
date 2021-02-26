package raytracer

interface Hittable {
    fun hit(ray: Ray, timeMin: Double, timeMax: Double): Hit?
}
