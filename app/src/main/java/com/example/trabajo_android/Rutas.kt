package com.example.trabajo_android

sealed class Rutas (var ruta:String){
    object LoginSceem:Rutas("LoginScreem")
    object MenuPrincipal:Rutas("MenuPrincipal")
    object Favoritos:Rutas("Favoritos")
    object ComidaChina:Rutas("ComidaChina")
    object ComidaJaponesa:Rutas("ComidaJaponesa")


}
