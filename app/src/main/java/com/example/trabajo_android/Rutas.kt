package com.example.trabajo_android

sealed class Rutas (var ruta:String){
    object LoginSceem:Rutas("LoginScreem")
    object MenuPrincipal:Rutas("MenuPrincipal")
    object Favoritos:Rutas("Favoritos")
    object Perfil:Rutas("Perfil")
    object ComidaChina:Rutas("ComidaChina")
    object ComidaJaponesa:Rutas("ComidaJaponesa")
    object Valoracion:Rutas("Valoracion")


}
