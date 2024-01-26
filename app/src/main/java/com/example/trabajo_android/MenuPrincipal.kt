package com.example.trabajo_android

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Inicio(){
    Scaffold(
        topBar = { MyTopAppBar() },
        content = { innerPadding ->
            ProductosView(innerPadding)
        },
        bottomBar = { MyBottomNavigation() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFAB() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text("Platos más populares") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        navigationIcon = {
            IconButton(onClick = { }) { Icon(Icons.Filled.Menu, contentDescription = "Desc") }
        },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Filled.Add, contentDescription = "Desc") }
            Spacer(modifier = Modifier.size(6.dp))
            IconButton(onClick = {}) { Icon(Icons.Filled.Close, contentDescription = "Desc") }
        }
    )
}

@Composable
fun ItemProducto(productos: Productos, onItemSelected: (Productos)-> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(175.dp)
            .clickable { onItemSelected(productos) }){
        Column(){
            Image(
                painter = painterResource(id = productos.Imagen),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = productos.Nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
            Text(
                text = productos.Ingredientes,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = productos.Precio,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp),
                fontSize = 15.sp
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Marcar como favorito",
                    modifier = Modifier,
                    fontSize = 12.sp
                )
                Checkbox(
                    checked = productos.Favorito,
                    onCheckedChange = { productos.Favorito = it },
                    modifier = Modifier
                )
            }
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Añadir a la cesta",
                    modifier = Modifier,
                    fontSize = 12.sp
                )
                Checkbox(
                    checked = productos.Cesta,
                    onCheckedChange = { productos.Cesta = it },
                    modifier = Modifier
                )

            }


        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductosView(innerPadding: PaddingValues) {
    val context = LocalContext.current

    LazyVerticalGrid(
        modifier = Modifier
            .consumeWindowInsets(innerPadding)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),

        ) {
        items(getProductos()) {
            ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
        }
    }
}



fun getProductos(): List<Productos> {
    return listOf(
        Productos("Paella valenciana", "Peter Parker", "20€", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "14.99", R.drawable.hamburguesa, true, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Peter Parker", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Peter Parker", "Marvel", R.drawable.hamburguesa, false, false),
    )
}

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = Color.Gray,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Fav Icon"
                )
            },
            label = { Text("FAV") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
            label = { Text("Person") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /* fab click handler */ }
    ) {
        Icon(imageVector = Icons.Default.Check, contentDescription = "FAB Check")
    }
}