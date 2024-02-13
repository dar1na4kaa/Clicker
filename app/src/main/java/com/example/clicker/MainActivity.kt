package com.example.clicker

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import com.example.clicker.ui.theme.ClickerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private lateinit var mainTextView: TextView
    private lateinit var colorText: TextView
    private lateinit var button: Button
    private lateinit var mainLayout: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainLayout = findViewById(R.id.main_layout)
        colorText = findViewById(R.id.color_text)
        mainTextView = findViewById(R.id.main_text)
        button = findViewById(R.id.generate_button)

        button.setOnClickListener {
            generateColor()
        }
    }

    private fun generateColor() {
        val rnd =  Random
        val color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        val text = color.toDrawable().toString().split("@")
        colorText.text = "#${text[1]}"

        mainLayout.background = color.toDrawable()
    }
}
