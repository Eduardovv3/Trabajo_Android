package com.example.trabajo_android

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

fun getProductosChinos(): List<Productos> {
    return listOf(
        Productos("Pato a la pekinsa", "20€", R.drawable.pato_pekines, true, false),
        Productos("Fideos misua","14.99", R.drawable.fideos_misua, true, false),
        Productos("Rollito de primavera", "Marvel", R.drawable.rollito_primavera, true, false),
        Productos("Pollo Kung Pao", "Marvel", R.drawable.pollo_kung_pao, false, false),
        Productos("Galleta de luna","Marvel", R.drawable.galleta_luna, false, false),
        Productos("Sopa wantán", "Marvel", R.drawable.sopa_wantan, false, false),

    )
}

@Composable
fun ProductosViewChinos(innerPadding: PaddingValues) {
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        items(getProductosChinos()) {
            ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
        }
    }
}

@Composable
fun ScaffoldChino(navController: NavController){
    Scaffold(
        topBar = { topBarChino(navController) },
        content = { innerPadding ->
            ProductosViewChinos(innerPadding)
        },

        )


}


@Composable
fun topBarChino(navController: NavController){
    Row {
        IconButton(onClick = {navController.popBackStack()},) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Pa tras")
        }
        Text(text = "Platos",
            Modifier.align(Alignment.CenterVertically)
        )
    }
}