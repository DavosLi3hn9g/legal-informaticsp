package com.zdog.demo.ui.basic

import com.zdog.demo.ui.shapes.World
import com.zdog.library.render.duration
import com.zdog.library.render.repeat
import com.zdog.library.render.*

class Shapes {
    val shapes = Array(15) {
        World()
    }

    init {
        var index = 0
        shape {
            addTo = shapes[index++].illo
            path(
                move(x = -40f),
                line(x = 40f)
            )
            stroke = 20f
            color = "#636"
        }

        shape {
            addTo = shapes[index++].illo
            path(
                move(x = -32f, y = -40f),
                line(x = 32f, y = -40f),
                line(x = -32f, y = 40f),
                line(x = 32f, y = 40f)
            )
            closed = false
            stroke = 20f
            color = "#636"
        }

        shape {
            addTo = shapes[index++].illo
            path(
                move(x = -32f, y = -40f, z = 40f),
                line(x = 32f, y = -40f),
                line(x = 32f, y = 40f, z = 40f),
                line(x = 32f, y = 40f, z = -40f)
            )
            closed = false
            stroke = 20f
            color = "#636"
        }

        shape {
            addTo = shapes[index++].illo
            path(
                move(x = -60f, y = -60f),
                arc(
                    vector(x = 20f, y = -60f),
                    vector(x = 20f, y = 20f)
                ),
                arc(
                    vector(x = 20f, y = 60f),
                    vector(x = 60f, y = 60f)
                )
            )
            closed = false
            stroke = 20f
            color = "#636"
        }

        shape {
            addTo = shapes[index++].illo
            path(
                move(x = -60f, y = -60f),
                bezier(
                    vector(x = 20f, y = -60f),
                    vector(x = 20f, y = 60f),
                    vector(x = 60f, y = 60f)
                )
            )
            closed = false
            stroke = 20f
            color = "#636"
        }

        val triangle = shape {
            addTo = shapes[index++].illo
            path(
                move(x = 0f, y = -40f),
                line(x = 40f, y = 40f),
                line(x = -40f, y = 40f)
            )
            stroke = 20f
            color = "#636"
        }

        triangle.copy {
            addTo = shapes[index++].illo
            closed = false
        }

        hemisphere {
            addTo = shapes[index++].illo
            diameter = 120f
            stroke = 0f
            color = "#C25"
            backface = "#EA0"
        }

        cone {
            addTo = shapes[index++].illo
            diameter = 70f
            length = 90f
            stroke = 0f
            color = "#636"
            backface = "#C25"
        }

        cylinder {
            addTo = shapes[index++].illo
            diameter = 80f
            length = 120f
            stroke = 0f
            color = "#C25"
            backface = "#E62"
        }

        cylinder {
            addTo = shapes[index++].illo
            diameter = 80f
            length = 120f
            stroke = 0f
            color = "#C25"
            frontFace = "#EA0"
            backface = "#636"
        }

        val box = box {
            addTo = shapes[index++].illo
            width = 120f
            height = 100f
            depth = 80f
            stroke = 0f
            color = "#C25"
            leftFace = "#EA0"
            rightFace = "#E62"
            topFace = "#ED0"
            bottomFace = "#636"
        }

        box.copy {
            addTo = shapes[index++].illo
            leftFace = null
            rightFace = null
            rearFace = "#EA0"
        }

        val distance = 40f

        shapes[index].illo.rotate(x = -(TAU / 16).toFloat())
        val dot = shape {
            addTo = shapes[index++].illo
            translate(y = -distance)
            stroke = 80f
            color = "#636"
        }
        dot.copy {
            translate(x = -distance)
            color = "#EA0"
        }
        dot.copy {
            translate(z = distance)
            color = "#C25"
        }
        dot.copy {
            translate(x = distance)
            color = "#E62"
        }
        dot.copy {
            translate(z = -distance)
            color = "#C25"
        }
        dot.copy {
            translate(y = distance)
        }

        shapes[index].illo.rotate(x = -(TAU / 16).toFloat())
        val dot2 = dot.copy {
            addTo = shapes[index++].illo
        }
        dot2.copy {
            translate(x = -distance)
        }
        dot2.copy {
            translate(z = distance)
        }
        dot2.copy {
            translate(x = distance)
        }
        dot2.copy {
            translate(z = -distance)
        }
        dot2.copy {
            translate(y = distance)
        }

        shapes.forEach {
            it.apply {
                play(
                    illo.rotateTo(y = TAU.toFloat()).duration(3000).repeat()
                )
            }
        }
    }
}