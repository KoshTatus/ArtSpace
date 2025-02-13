package com.example.lr2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Console

data class Photo(
    val imageId: Int,
    val name: String,
    val location: String
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private val imageIds: Array<Int> = arrayOf(
        R.drawable.piza,
        R.drawable.coliseum,
        R.drawable.cremle
    )

    private val names: Array<Array<String>> = arrayOf(
        arrayOf(
            "Leaning Tower of Pisa",
            "Pisa, Italy"
        ),
        arrayOf(
            "Coliseum",
            "Rome, Italy"
        ),
        arrayOf(
            "Kremlin",
            "Moscow, Russia"
        )
    )

    private val photos: List<Photo> = listOf(
        Photo(R.drawable.piza, "Leaning Tower of Pisa", "Pisa, Italy"),
        Photo(R.drawable.coliseum, "Coliseum", "Rome, Italy"),
        Photo(R.drawable.cremle, "Kremlin", "Moscow, Russia"),
        Photo(R.drawable.eifel, "Eifel Tower", "Paris, France")
    )

    private var currImage: Int = 0

    fun changeInfo(view: View){
        var direction = 1
        if (findViewById<Button>(view.id).text == "Previous")
            direction = -1
        val imageView = findViewById<ImageView>(R.id.imageView)
        val nameView = findViewById<TextView>(R.id.textView2)
        val locationView = findViewById<TextView>(R.id.textView3)
        currImage += direction
        if (currImage == -1)
            currImage = 2
        if (currImage == photos.size)
            currImage = 0
        imageView.setImageResource(photos[currImage].imageId)
        nameView.text = photos[currImage].name
        locationView.text = photos[currImage].location
    }
}