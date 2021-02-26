package raytracer

class HittableList(private val objects: List<Hittable>) : Hittable {
    constructor(vararg objects: Hittable) : this(listOf(*objects))

    override fun hit(ray: Ray, timeMin: Double, timeMax: Double): HitRecord? {
        return objects.fold(null as HitRecord?) { acc, obj ->
            obj.hit(ray, timeMin, acc?.t ?: timeMax) ?: acc
        }
    }
}
