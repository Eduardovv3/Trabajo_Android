package com.example.trabajo_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Valorar(){
    Column (
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()

    ){
        Text(text = "Esta ventana es para que nos proporciones tu opinion sobre la pagina")
    }
}