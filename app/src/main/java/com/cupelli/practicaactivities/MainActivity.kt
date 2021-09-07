package com.cupelli.practicaactivities

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var Imagenes: Images
    private var centinel = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Imagenes = Images()

        initView()
    }

    private lateinit var imagesArray: Array<Images> //Creamos un arreglo de tipo "Images", como nuestra clase
    private lateinit var btnBack: Button
    private lateinit var photoBinary: ImageView
    private lateinit var btnNext: Button
    private lateinit var btnInfo: Button
    private lateinit var btnFav: Button

    private fun initView(){
        btnBack = findViewById(R.id.btnBack)
        photoBinary = findViewById(R.id.photoBinary)
        btnNext = findViewById(R.id.btnNext)
        btnInfo = findViewById(R.id.btnInfo)
        //Cargamos las imágenes en nuestro arreglo, llamando la función getImages en Images
        imagesArray = Imagenes.getImages()

        bringImages()
        changeImagesByClick()
    }

    private fun changeImagesByClick(){
        btnBack.setOnClickListener{
            if(centinel == 0) { centinel = imagesArray.size - 1 }//En caso de que centinel sea 0, restaremos un valor al arreglo
            else { centinel -= 1 }
            bringImages()
        }

        btnInfo.setOnClickListener{
            startActivity(Intent(this, MiddleActivity::class.java).apply {
                putExtra("selectedImage", imagesArray[centinel])
            })
        }

        btnNext.setOnClickListener{
            if(centinel ==  imagesArray.size - 1) {centinel = 0} //En caso de que centinel sea 0, restaremos un valor al arreglo
            else centinel += 1
            bringImages()
        }
    }

    private fun bringImages()
    {
        photoBinary.setImageResource(imagesArray[centinel].image)
    }







}