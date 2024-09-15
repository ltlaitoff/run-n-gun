package org.gunnrun

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.beans.binding.Bindings
import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.stage.Stage

class MyApp : Application() {
    val width = 400.0
    val height = 400.0
    val title = "Run 'n Gun"
    val playerRadius = 10.0

    val movementValue = 2.0

    var WKeyWasPressed = false
    var AKeyWasPressed = false
    var SKeyWasPressed = false
    var DKeyWasPressed = false

    override fun start(stage: Stage) {
        val player = Circle(width / 2, height / 2, playerRadius, Color.FIREBRICK)

        addDragHandling(player)

        val root = Pane(player)

        stage.scene = Scene(root, width, height)
        stage.title = title
        stage.show()

        player.requestFocus()
    }


    private fun addDragHandling(circle: Circle) {
        var timer = object : AnimationTimer() {
            override fun handle(p0: Long) {
                if (WKeyWasPressed) {
                    circle.centerY -= movementValue
                }
                if (AKeyWasPressed) {
                    circle.centerX -= movementValue
                }
                if (SKeyWasPressed) {
                    circle.centerY += movementValue
                }
                if (DKeyWasPressed) {
                    circle.centerX += movementValue
                }
            }
        }

        timer.start()

        circle.setOnKeyPressed { event: KeyEvent ->
            if (event.code === KeyCode.W) {
                WKeyWasPressed = true
            }
            if (event.code === KeyCode.A) {
                AKeyWasPressed = true
            }
            if (event.code === KeyCode.S) {
                SKeyWasPressed = true
            }
            if (event.code === KeyCode.D) {
                DKeyWasPressed = true
            }

            event.consume()
        }

        circle.setOnKeyReleased { event: KeyEvent ->
            if (event.code === KeyCode.W) {
                WKeyWasPressed = false
            }
            if (event.code === KeyCode.A) {
                AKeyWasPressed = false
            }
            if (event.code === KeyCode.S) {
                SKeyWasPressed = false
            }
            if (event.code === KeyCode.D) {
                DKeyWasPressed = false
            }

            event.consume()
        }
    }
}

fun main() {
    Application.launch(MyApp::class.java)
}
