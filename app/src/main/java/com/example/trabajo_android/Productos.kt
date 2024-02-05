package com.example.trabajo_android

import androidx.annotation.DrawableRes

data class Productos(
    var Nombre: String,
    var Precio: String,
    @DrawableRes var Imagen: Int,
    var Favorito: Boolean,
    var Cesta: Boolean
)

var ListaProductosPrincipal = mutableListOf(
    Productos("Paella valenciana", "20€", R.drawable.paella_valenciana, true, false),
    Productos("Hamburguesa", "14.99", R.drawable.hamburguesa, true, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, true, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
    Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
)