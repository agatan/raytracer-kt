package raytracer

class Metal(val albedo: Color) : Material {
    override fun scatter(ray: Ray, hit: Hit): Scattered? {
        val reflected = ray.direction.reflect(hit.normal.unit())
        val scatteredRay = Ray(hit.p, reflected)
        val attenuation = albedo
        return Scattered(scatteredRay, attenuation)
    }
}
