package com.cupelli.practicaactivities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Parcelize
class Images (
    var image: Int = R.drawable.purple1,
    var imageInfo: String = "",
    var isFavorite: Boolean = false
): Parcelable {
    companion object {
        val imagesArray = arrayOf(
            Images(R.drawable.purple1, "¿No estaría genial tener una vista así de la luna y el cielo?",false),
            Images(R.drawable.ic_piano, "Nunca sabremos porqué el piano tiene tanta armonía en sus notas",false),
            Images(R.drawable.purple2, "A pesar de esas tétricas varas, ¿No da cierta melancolía el paisaje?",false),
            Images(R.drawable.ic_cat, "C'est du pipi de chat mon ami, est-ce que vous avez écoutez cet expression idiomatique?",false),
            Images(R.drawable.purple3, "Parecieran las puertas del infierno, tornadas moradas, ¿O era lila?",false),
            Images(R.drawable.ic_dog, "Es imposible olvidar a los pequeños acompañantes que tenemos en esta gran vida, ¿Cierto?",false),
            Images(R.drawable.purple4, "Purple purple and just purple. Isn't that combination so perfect?",false),
            Images(R.drawable.ic_stock, "Trading. Es un mundo muy interesante, no estaría mal echarle un ojo más a menudo",false),
            Images(R.drawable.purple5, "¿Serán gotas moradas de agua en una hoja? No lo sabremos... Tiene aura misteriosa",false),
            Images(R.drawable.ic_violin, "To fiddle, to play the violin. Yep, I didn't know that verb too",false),
        )
    }

    fun isFavorite(position: Int, isFavorite: Boolean) { imagesArray[position].isFavorite = isFavorite }

    fun getImages() = imagesArray
}