package raytracer

class Metal(val albedo: Color, f: Double) : Material {
    val fuzz: Double

    init {
        this.fuzz = if (f < 1) {
            f
        } else {
            1.0
        }
    }

    override fun scatter(ray: Ray, hit: Hit): Scattered? {
        val reflected = ray.direction.reflect(hit.normal.unit())
        val scatteredRay = Ray(hit.p, reflected + Vec3d.randomInUnitSphere() * fuzz)
        val attenuation = albedo
        return Scattered(scatteredRay, attenuation)
    }
}
