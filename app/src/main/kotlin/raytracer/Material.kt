package raytracer

data class Scattered(val ray: Ray, val attenuation: Color)

interface Material {
    fun scatter(ray: Ray, hit: Hit): Scattered?
}
