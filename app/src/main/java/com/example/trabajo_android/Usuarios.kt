package com.example.trabajo_android

import androidx.annotation.DrawableRes

data class Usuarios(
    @DrawableRes var Avatar: Int,
    var Nombre:String,
    var Apellidos:String,
    var Direccion:String,
    var Correo:String,
    var Contrasenya:String

)

var ListaUsuarios = mutableListOf(
    Usuarios(R.drawable.hamburguesa, "Eduardo", "Vivo Medina", "giwgwbg", "eduardovivomedina@gmail.com", "12345")
)