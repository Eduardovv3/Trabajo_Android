package com.example.trabajo_android

import androidx.annotation.DrawableRes

data class Productos(
    var Nombre: String,
    var Precio: Int,
    @DrawableRes var Imagen: Int,
    var Favorito: Boolean,
    var Cesta: Boolean
)

var ListaProductosPrincipal = mutableListOf(
    Productos("Paella valenciana", 20, R.drawable.paella_valenciana, true, false),
    Productos("Hamburguesa", 14.99.toInt(), R.drawable.hamburguesa, true, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, true, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", 1, R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", 1, R.drawable.hamburguesa, false, false),
)
var ListaProductosChinos = mutableListOf(
    Productos("Pato a la pekinsa", 20, R.drawable.pato_pekines, true, false),
    Productos("Fideos misua", 14.99.toInt(), R.drawable.fideos_misua, true, false),
    Productos("Rollito de primavera", 1, R.drawable.rollito_primavera, true, false),
    Productos("Pollo Kung Pao", 1, R.drawable.pollo_kung_pao, false, false),
    Productos("Galleta de luna",1, R.drawable.galleta_luna, false, false),
    Productos("Sopa wantán", 1, R.drawable.sopa_wantan, false, false),
)
var ListaProductosJaponeses = mutableListOf(
    Productos("Sushi", 20, R.drawable.sushi, true, false),
    Productos("Tempura", 14.99.toInt(), R.drawable.tempura, true, false),
    Productos("Ramen", 1, R.drawable.ramen, true, false),
    Productos("Soba", 1, R.drawable.soba, false, false),
    Productos("Udon",1, R.drawable.udon, false, false),
    Productos("Takoyaki", 1, R.drawable.takoyaki, false, false),
    Productos("Onigiri", 1, R.drawable.onigiri, false, false),
    Productos("Okonomiyaki", 1, R.drawable.okonomiyaki, false, false),
    Productos("Yakitori", 1, R.drawable.yakitori, false, false),
    Productos("Katsudon", 1, R.drawable.katsudon, false, false),
)

