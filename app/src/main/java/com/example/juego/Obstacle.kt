package com.example.juego

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Obstacle(var x: Float, var height: Float, private val gap: Float = 300f, private val canvasHeight: Float = 1080f) {
    private val paint: Paint = Paint().apply {
        color = Color.GREEN // Color de los obstáculos
    }
    private val width: Float = 50f // Ancho de los obstáculos

    fun draw(canvas: Canvas) {
        canvas.drawRect(x, 0f, x + width, height, paint) // Dibuja el obstáculo superior
        canvas.drawRect(x, height + gap, x + width, canvas.height.toFloat(), paint) // Dibuja el obstáculo inferior
    }

    fun update() {
        x -= 5 // Mueve el obstáculo a la izquierda
    }

    fun getUpperBounds(): FloatArray {
        return floatArrayOf(x, 0f, x + width, height)
    }

    fun getLowerBounds(): FloatArray {
        return floatArrayOf(x, height + gap, x + width, height + gap)
    }
}
