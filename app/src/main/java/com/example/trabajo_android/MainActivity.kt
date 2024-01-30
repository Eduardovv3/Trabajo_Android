package com.example.trabajo_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trabajo_android.ui.theme.Trabajo_AndroidTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Trabajo_AndroidTheme {
                Navegacion()
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Trabajo_AndroidTheme {
        Navegacion()
    }
}

@Composable
fun Navegacion(){
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer() { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Rutas.LoginSceem.ruta) {
            composable(route = Rutas.LoginSceem.ruta) {
                LoginScreem(navController)
            }
            composable(route = Rutas.MenuPrincipal.ruta) {
                Inicio(navController)
            }
        }
    }
}



@Composable
fun MyNavigationDrawer(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        repeat(5) {
            Text(
                text = "Opción ${it + 1}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onCloseDrawer() }
            )
        }
    }
}







