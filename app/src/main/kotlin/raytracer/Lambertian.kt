package raytracer

class Lambertian(val albedo: Color) : Material {
    override fun scatter(ray: Ray, hit: Hit): Scattered? {
        val scatterDirection = (hit.normal + Vec3d.randomInUnitSphere()).let {
            if (it.isNearZero()) {
                hit.normal
            } else {
                it
            }
        }
        val scatteredRay = Ray(hit.p, scatterDirection)
        val attenuation = albedo
        return Scattered(scatteredRay, attenuation)
    }
}
