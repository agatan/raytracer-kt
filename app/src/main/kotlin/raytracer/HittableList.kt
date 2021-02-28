package raytracer

class HittableList(private val objects: Iterable<Hittable>) : Hittable {
    constructor(vararg objects: Hittable) : this(listOf(*objects))

    override fun hit(ray: Ray, timeMin: Double, timeMax: Double): Hit? {
        return objects.fold(null as Hit?) { acc, obj ->
            obj.hit(ray, timeMin, acc?.t ?: timeMax) ?: acc
        }
    }
}
