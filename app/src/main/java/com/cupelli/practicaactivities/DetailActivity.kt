package com.cupelli.practicaactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {
    private var source: Int = 0
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        source = intent.getIntExtra("source", R.drawable.purple1)

        image = findViewById(R.id.photoDetail)
        image.setImageResource(source)
    }

}