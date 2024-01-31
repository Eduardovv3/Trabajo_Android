package com.example.trabajo_android

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.DrawerState
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
import androidx.compose.runtime.mutableStateOf
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
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Inicio(NavController: NavHostController, scope: CoroutineScope, drawerState: DrawerState, ){

    var currentScreen by rememberSaveable { mutableStateOf(ScreenScaffold.MenuPrincipal) }
    Scaffold(
        modifier = Modifier.background(Color.Black),
        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
        content = { innerPadding ->
            ProductosView(innerPadding)
            when (currentScreen) {
                ScreenScaffold.MenuPrincipal -> ProductosView(innerPadding)
                ScreenScaffold.Favoritos -> ProductosViewFav(innerPadding)
                else -> {}
            }
        },
        bottomBar = { MyBottomNavigation( currentScreen, onTabSelected = { screen -> currentScreen = screen }) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFAB() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(OnOpen: () -> Unit) {
    val activity = LocalContext.current as? Activity
    TopAppBar(
        title = { Text("Platos más populares") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black),
        navigationIcon = {
            IconButton(onClick = { OnOpen()}) { Icon(Icons.Filled.Menu, contentDescription = "Desc") }
        },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Filled.Add, contentDescription = "Desc") }
            Spacer(modifier = Modifier.size(6.dp))
            IconButton(onClick = {activity?.finish() }) { Icon(Icons.Filled.Close, contentDescription = "Desc") }
        }
    )
}

@Composable
fun ItemProducto(productos: Productos, onItemSelected: (Productos)-> Unit) {
    var favorito :Boolean by rememberSaveable { mutableStateOf(productos.Favorito) }
    var cesta :Boolean by rememberSaveable { mutableStateOf(productos.Cesta) }
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(175.dp)
            .clickable { onItemSelected(productos) }){
        Column(){
            Image(
                painter = painterResource(id = productos.Imagen),
                contentDescription = "Imagen comida",
                modifier = Modifier.size(175.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = productos.Nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)

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
                    checked = favorito,
                    onCheckedChange = { favorito = !favorito }
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
                    checked = cesta,
                    onCheckedChange = { cesta = !cesta }
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
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(Color.Black)
            .fillMaxSize(),
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
        Productos("Paella valenciana", "20€", R.drawable.paella_valenciana, true, false),
        Productos("Hamburguesa", "14.99", R.drawable.hamburguesa, true, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, true, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
        Productos("Paella valenciana", "Marvel", R.drawable.paella_valenciana, false, false),
        Productos("Hamburguesa", "Marvel", R.drawable.hamburguesa, false, false),
    )
}

@Composable
fun MyBottomNavigation(currentScreen: ScreenScaffold, onTabSelected: (ScreenScaffold) -> Unit) {

    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentScreen ==  ScreenScaffold.MenuPrincipal,
            onClick = {onTabSelected(ScreenScaffold.MenuPrincipal)},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentScreen ==  ScreenScaffold.Favoritos,
            onClick = { onTabSelected(ScreenScaffold.Favoritos)},
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Fav Icon"
                )
            },
            label = { Text("FAV") }
        )
        NavigationBarItem(
            selected = currentScreen ==  ScreenScaffold.Perfil,
            onClick = {onTabSelected(ScreenScaffold.Perfil)},
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