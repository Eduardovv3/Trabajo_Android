package com.example.trabajo_android

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Shop2
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

var precio:Int = 0
@Composable
fun ProductosViewCes(innerPadding: PaddingValues) {
    precio =0
    val context = LocalContext.current
    LazyVerticalGrid(
        modifier = Modifier
            .consumeWindowInsets(innerPadding)
            .padding(vertical = 8.dp)
            .background(Color.Black)
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        items(ListaProductosPrincipal) {
            if(it.Cesta == true){
                precio = precio + it.Precio
                ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
            }
        }
        items(ListaProductosChinos) {
            if(it.Cesta == true){
                precio = precio + it.Precio
                ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
            }
        }
        items(ListaProductosJaponeses) {
            if(it.Cesta == true){
                precio = precio + it.Precio
                ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
            }
        }
    }
}

@Composable
fun ScaffoldCesta(navController: NavController){

    Scaffold(
        topBar = { topBarCesta(navController) },
        content = { innerPadding ->
            ProductosViewCes(innerPadding)
        },
        bottomBar = { bottomBarCesta(navController) }

        )


}


@Composable
fun topBarCesta(navController: NavController){
    Row {
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Pa tras")
        }
        Text(text = "Cesta",
            Modifier.align(Alignment.CenterVertically)
        )
    }
}
@Composable
fun bottomBarCesta(navController: NavController){
    val context = LocalContext.current

        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ){
                Text(text = "Precio Total: " + precio.toString() + "€",
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = 15.sp

                    )
            }
            Column (
                modifier = Modifier.weight(1f)
                    .align(Alignment.CenterVertically)
            ){
                Text(text = "Comprar",
                    Modifier.align(Alignment.End)
                )
                IconButton(onClick = {
                    navController.popBackStack()
                    Toast.makeText(context , "La compra se ha hecho sin problema ",  Toast.LENGTH_SHORT).show() },
                    Modifier.align(Alignment.End)) {
                    Icon(imageVector = Icons.Default.Shop2, contentDescription = "Comprar")
                }
            }
        }
}
