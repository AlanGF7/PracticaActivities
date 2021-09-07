package com.cupelli.practicaactivities

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MiddleActivity : AppCompatActivity() {

    private lateinit var imageSelected: Images
    private var ID: Int = 0 //No puedo usar lateinit porque es de tipo primitivo
    private var starredImage: Boolean = false

    private lateinit var mainImage: ImageView //No hallé forma de poner un onClick() en una imagen
    private lateinit var textPhotoMiddle: TextView
    private lateinit var photoPreferences: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle)

        imageSelected = intent.getParcelableExtra("selectedImage") ?: Images()
        ID = intent.getIntExtra("ID_Selected",0)
        starredImage = imageSelected.isFavorite

        initView()

    }

    private fun initView()
    {
        mainImage = findViewById(R.id.photoBinary)
        textPhotoMiddle = findViewById(R.id.textPhotoMiddle)
        photoPreferences = findViewById(R.id.photoPreferences)

        mainImage.setImageResource(imageSelected.image)

        textPhotoMiddle.setText(imageSelected.description.text)

    }

    //No puedo dejarlo sin un método, de lo contrario, no cambiaría en tiempo real la estrellita
    private fun detectFavorite() {

        if(starredImage) {photoPreferences.setImageResource(R.drawable.starpopped)}
        else {photoPreferences.setImageResource(R.drawable.starempty)}
    }
    fun clickPhoto(view: View) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra("source", imageSelected.image)
        })
    }

    fun clickFavorite(view: View) {

        starredImage = !starredImage
        Images().isFavorite(ID, starredImage)
        detectFavorite()
    }

}