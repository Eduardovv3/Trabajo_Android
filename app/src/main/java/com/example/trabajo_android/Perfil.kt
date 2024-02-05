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
fun MiPerfil(innerPadding: PaddingValues,Usuarios: Usuarios){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)


    ){
        Image(
            painter = painterResource(id = Usuarios.Avatar),
            contentDescription = "Avatar",
            modifier = Modifier.size(175.dp)
                .padding(15.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Nombre : " + Usuarios.Nombre,
            modifier = Modifier.align(Alignment.Start)
                .padding(15.dp)
        )
        Text(
            text = "Apellidos : " + Usuarios.Apellidos,
            modifier = Modifier.align(Alignment.Start)
                .padding(15.dp)
        )
        Text(
            text = "Direccion : " + Usuarios.Direccion,
            modifier = Modifier.align(Alignment.Start)
                .padding(15.dp)
        )
        Text(
            text = "Correo : " + Usuarios.Correo,
            modifier = Modifier.align(Alignment.Start)
                .padding(15.dp)
        )

    }
}

@Composable
fun UsuariosView(innerPadding: PaddingValues, correo:String?) {
    ListaUsuarios.forEach {usuario ->
        if (usuario.Correo == correo){
            MiPerfil(innerPadding,usuario)
        }
    }

}

