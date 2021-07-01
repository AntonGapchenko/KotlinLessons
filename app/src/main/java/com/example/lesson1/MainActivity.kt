package com.example.lesson1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


private lateinit var sendBtn: Button
private lateinit var rainbowBtn: Button
private lateinit var sampleEditText: EditText
private lateinit var sampleTextView: TextView
private lateinit var layoutConst: ConstraintLayout
private var changeColor = false
private var counter = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        sendBtn.setOnClickListener {
            val string = sampleEditText.text
            sampleTextView.text = string
        }
        rainbowBtn.setOnClickListener() { changeLayoutColor() }
    }

    private fun init() {
        sendBtn = findViewById(R.id.button_send)
        rainbowBtn = findViewById(R.id.button_rainbow)
        sampleEditText = findViewById(R.id.edit_text)
        sampleTextView = findViewById(R.id.text_view_sample)
        layoutConst = findViewById(R.id.main_layout)
    }

    private fun changeLayoutColor() {
        Thread {
            changeColor = true
            while (changeColor) {
                Thread.sleep(1000)
                runOnUiThread {
                    when (counter) {
                        2 -> layoutConst.setBackgroundColor(Color.RED)
                        4 -> layoutConst.setBackgroundColor(Color.YELLOW)
                        6 -> layoutConst.setBackgroundColor(Color.GREEN)
                        8 -> layoutConst.setBackgroundColor(Color.BLUE)
                        10 -> layoutConst.setBackgroundColor(Color.WHITE)
                        11 -> resetRainbow()
                    }
                    counter++
                }
            }

        }.start()
    }

    private fun resetRainbow() {
        changeColor = false
        counter = 0
    }
}