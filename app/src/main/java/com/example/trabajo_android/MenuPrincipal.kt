package com.example.trabajo_android

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.RemoveShoppingCart
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun Inicio(NavController: NavHostController, correo: String?){

    var currentScreen by rememberSaveable { mutableStateOf(ScreenScaffold.MenuPrincipal) }

    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer(NavController) { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            modifier = Modifier.background(Color.Black),
            topBar = { MyTopAppBar (currentScreen){scope.launch { drawerState.open() } } },
            content = { innerPadding ->
                when (currentScreen) {
                    ScreenScaffold.MenuPrincipal -> ProductosView(innerPadding)
                    ScreenScaffold.Favoritos -> ProductosViewFav(innerPadding)
                    ScreenScaffold.Perfil -> UsuariosView(innerPadding, correo)

                }
            },
            bottomBar = {
                MyBottomNavigation(
                    currentScreen,
                    onTabSelected = { screen -> currentScreen = screen })
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { MyFAB(NavController) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(currentScreen: ScreenScaffold,OnOpen: () -> Unit) {
    val activity = LocalContext.current as? Activity
    TopAppBar(
        title = { when (currentScreen) {
            ScreenScaffold.MenuPrincipal -> Text(text = "Platos principales")
            ScreenScaffold.Favoritos -> Text(text = "Favoritos")
            ScreenScaffold.Perfil -> Text(text = "Perfil")

        } },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black),
        navigationIcon = {
            IconButton(onClick = { OnOpen()}) { Icon(Icons.Filled.Menu, contentDescription = "Desc") }
        },
        actions = {
            IconButton(onClick = {activity?.finish() }) { Icon(Icons.Filled.Close, contentDescription = "Desc") }
        }
    )
}

@Composable
fun ItemProducto(productos: Productos, onItemSelected: (Productos)-> Unit) {
    val checkedStateFav = remember { mutableStateOf(productos.Favorito) }
    productos.Favorito = checkedStateFav.value
    var interactionSourceFav: MutableInteractionSource = remember { MutableInteractionSource() }
    val checkedStateCes = remember { mutableStateOf(productos.Cesta) }
    productos.Cesta = checkedStateCes.value
    var interactionSourceCes: MutableInteractionSource = remember { MutableInteractionSource() }
    Card(border = BorderStroke(2.dp, Color.White),
        modifier = Modifier
            .width(175.dp)
            .clickable { onItemSelected(productos) }){
        Column(){
            Image(
                painter = painterResource(id = productos.Imagen),
                contentDescription = "Imagen comida",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = productos.Nombre,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
            Text(
                text = productos.Precio.toString() + "€",
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
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                        .clickable(
                            interactionSource = interactionSourceFav,
                            indication = null,
                            onClick = { checkedStateFav.value = !checkedStateFav.value })
                ){
                    if (checkedStateFav.value) {
                        productos.Favorito = checkedStateFav.value
                        Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "estado")
                    }else{
                        productos.Favorito = checkedStateFav.value
                        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "estado")
                    }
                }
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
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                        .clickable(
                            interactionSource = interactionSourceCes,
                            indication = null,
                            onClick = { checkedStateCes.value = !checkedStateCes.value })
                ){
                    if (checkedStateCes.value) {
                        productos.Cesta = checkedStateCes.value
                        Icon(imageVector = Icons.Outlined.AddShoppingCart, contentDescription = "estado")
                    }else{
                        productos.Cesta = checkedStateCes.value
                        Icon(imageVector = Icons.Outlined.RemoveShoppingCart, contentDescription = "estado")
                    }
                }

            }


        }

    }
}


@Composable
fun ProductosView(innerPadding: PaddingValues) {
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
        items(ListaProductos) {
            if(it.Categoria.equals("española")){
                ItemProducto(it) { Toast.makeText(context, it.Nombre, Toast.LENGTH_SHORT).show() }
            }

        }
    }
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
fun MyFAB(navController: NavHostController) {
    FloatingActionButton(
        onClick = { navController.navigate(Rutas.Cesta.ruta)}
    ) {
        Text(text = "Cesta")
    }
}