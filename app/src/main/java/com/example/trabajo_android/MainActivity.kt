package com.example.trabajo_android

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trabajo_android.ui.theme.Trabajo_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trabajo_AndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Trabajo_AndroidTheme {
        Inicio()
    }
}

@Composable
fun Inicio(){
    Scaffold(
        topBar = { MyTopAppBar() },
        content = { innerPadding ->
            MyContent(innerPadding)
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
        title = { Text("Top App Bar") },
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
fun Itemproducto(productos: Productos, onItemSelected: (Productos)-> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
    modifier = Modifier.width(250.dp) .clickable { onItemSelected(productos)}){
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
                text = productos.Receta,
                modifier = Modifier.align(Alignment.End).padding(6.dp),
                fontSize = 10.sp
            )

        }

    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyContent(innerPadding: PaddingValues) {
    val colors = listOf(Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt()))
    LazyColumn(
        modifier = Modifier.consumeWindowInsets(innerPadding),
        contentPadding = innerPadding
    ) {
        items(100) { count ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(colors[count % colors.size])
            ) { Text(text = "Fila $count") }
        }
    }
}


/*@Composable
fun contenidoPopular(){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    )
}*/

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = Color.Red,
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