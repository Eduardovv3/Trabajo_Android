package com.example.trabajo_android

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

fun getProductosJaponesa(): List<Productos> {
    return listOf(
        Productos("Sushi", "20€", R.drawable.sushi, true, false),
        Productos("Tempura","14.99", R.drawable.tempura, true, false),
        Productos("Ramen", "Marvel", R.drawable.ramen, true, false),
        Productos("Soba", "Marvel", R.drawable.soba, false, false),
        Productos("Udon","Marvel", R.drawable.udon, false, false),
        Productos("Takoyaki", "Marvel", R.drawable.takoyaki, false, false),
        Productos("Onigiri", "Marvel", R.drawable.onigiri, false, false),
        Productos("Okonomiyaki", "Marvel", R.drawable.okonomiyaki, false, false),
        Productos("Yakitori", "Marvel", R.drawable.yakitori, false, false),
        Productos("Katsudon", "Marvel", R.drawable.katsudon, false, false),

        )
}

@Composable
fun ProductosViewJapones() {

        val context = LocalContext.current
        LazyVerticalGrid(
            modifier = Modifier

                .background(Color.Black)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
            items(getProductosJaponesa()) {
                ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
            }
        }
    }

