package raytracer

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SphereTest {
    @Test
    fun testHit() {
        val sphere = Sphere(Point3d(0.0, 0.0, -1.0), 0.5)
        val ray = Ray(Point3d(0.0, 0.0, 0.0), Vec3d(0.0, 0.0, -1.0))
        val hit = sphere.hit(ray, 0.0, 1.0)!!
        assertEquals(0.5, hit.t)
        assertEquals(Point3d(0.0, 0.0, -0.5), hit.p)
        assertEquals(Vec3d(0.0, 0.0, 1.0), hit.normal)
    }

    @Test
    fun testHitOutOfTimeRange() {
        val sphere = Sphere(Point3d(0.0, 0.0, -1.0), 0.5)
        val ray = Ray(Point3d(0.0, 0.0, 0.0), Vec3d(0.0, 0.0, -1.0))
        assertNull(sphere.hit(ray, 0.6, 1.0))
        assertNull(sphere.hit(ray, 0.0, 0.4))
    }
}
