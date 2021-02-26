/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package raytracer

import me.tongfei.progressbar.ProgressBar
import java.io.File

fun main() {
    val imageWidth = 256
    val imageHeight = 256

    File("image.ppm").printWriter().use { out ->
        out.print("P3\n$imageWidth $imageHeight\n255\n")

        ProgressBar("Scanlines", imageHeight.toLong()).use { bar ->
            for (j in (imageHeight - 1) downTo 0) {
                bar.step()
                for (i in 0..imageWidth) {
                    val pixelColor = Color(
                        i.toDouble() / (imageWidth - 1),
                        j.toDouble() / (imageHeight - 1),
                        0.25
                    )
                    out.println("${pixelColor.translatedString()}")
                }
            }
        }
    }
}
