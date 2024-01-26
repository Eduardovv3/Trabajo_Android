package com.example.trabajo_android

import androidx.annotation.DrawableRes

data class Productos(
    var Nombre: String,
    var Ingredientes: String,
    var Precio: String,
    @DrawableRes var Imagen: Int,
    var Favorito: Boolean,
    var Cesta: Boolean
)