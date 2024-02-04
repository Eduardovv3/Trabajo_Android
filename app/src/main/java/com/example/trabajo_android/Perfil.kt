package com.example.trabajo_android

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MiPerfil(Usuarios: Usuarios){
    Column (
        modifier = Modifier
            .background(Color.Black)

    ){
        Image(
            painter = painterResource(id = Usuarios.Avatar),
            contentDescription = "Avatar",
            modifier = Modifier.size(175.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = Usuarios.Nombre,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = Usuarios.Apellidos,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = Usuarios.Direccion,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = Usuarios.Correo,
            modifier = Modifier.align(Alignment.Start)
        )

    }
}

@Composable
fun UsuariosView(innerPadding: PaddingValues) {
    getUsuarios().forEach { usuario ->
        if (usuario.Correo == Usuarios.Correo){
            MiPerfil(usuario)
        }
    }

}

@Composable
fun getUsuarios(): List<Usuarios> {
    return listOf(

    )

}