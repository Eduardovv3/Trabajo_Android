package com.example.trabajo_android

import androidx.annotation.DrawableRes

data class Productos(
    var Nombre: String,
    var Precio: Int,
    @DrawableRes var Imagen: Int,
    var Favorito: Boolean,
    var Cesta: Boolean,
    var Categoria: String
)

var ListaProductos = mutableListOf(
    Productos("Paella valenciana", 20, R.drawable.paella_valenciana, true, false, "española"),
    Productos("Hamburguesa", 14.99.toInt(), R.drawable.hamburguesa, true, false, "española"),
    Productos("Pato a la pekinsa", 20, R.drawable.pato_pekines, true, false, "china"),
    Productos("Fideos misua", 14.99.toInt(), R.drawable.fideos_misua, true, false, "china"),
    Productos("Rollito de primavera", 1, R.drawable.rollito_primavera, true, false, "china"),
    Productos("Pollo Kung Pao", 1, R.drawable.pollo_kung_pao, false, false, "china"),
    Productos("Galleta de luna",1, R.drawable.galleta_luna, false, false, "china"),
    Productos("Sopa wantán", 1, R.drawable.sopa_wantan, false, false, "china"),
    Productos("Sushi", 20, R.drawable.sushi, true, false, "japonesa"),
    Productos("Tempura", 14.99.toInt(), R.drawable.tempura, true, false, "japonesa"),
    Productos("Ramen", 1, R.drawable.ramen, true, false, "japonesa"),
    Productos("Soba", 1, R.drawable.soba, false, false, "japonesa"),
    Productos("Udon",1, R.drawable.udon, false, false, "japonesa"),
    Productos("Takoyaki", 1, R.drawable.takoyaki, false, false, "japonesa"),
    Productos("Onigiri", 1, R.drawable.onigiri, false, false, "japonesa"),
    Productos("Okonomiyaki", 1, R.drawable.okonomiyaki, false, false, "japonesa"),
    Productos("Yakitori", 1, R.drawable.yakitori, false, false, "japonesa"),
    Productos("Katsudon", 1, R.drawable.katsudon, false, false, "japonesa"),
)

