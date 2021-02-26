package raytracer

import kotlin.math.sqrt

class Sphere(private val center: Point3d, private val radius: Double, private val material: Material) : Hittable {

    override fun hit(ray: Ray, timeMin: Double, timeMax: Double): Hit? {
        // t^2 * b * b + 2tb * (A - C) + (A - C) * (A - C) - r^2 = 0
        //   t: timestep
        //   A: ray origin
        //   b: ray direction
        //   C: center of the sphere
        //   r: radius of the sphere
        val oc = ray.origin - center
        val a = ray.direction.l2norm()
        val halfB = oc.dot(ray.direction)
        val c = oc.l2norm() - radius * radius
        val discriminant = halfB * halfB - a * c
        if (discriminant < 0) {
            return null
        }

        val sqrtd = sqrt(discriminant)
        var t = ((-halfB - sqrtd) / a)
        if (t < timeMin || timeMax < t) {
            t = (-halfB + sqrtd) / a
            if (t < timeMin || timeMax < t) {
                return null
            }
        }
        val p = ray.at(t)

        return Hit.create(p, t, ray, (p - center) / radius, material)
    }
}
