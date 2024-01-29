package com.example.trabajo_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trabajo_android.ui.theme.Trabajo_AndroidTheme

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
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Rutas.LoginSceem.ruta ){
        composable(route = Rutas.LoginSceem.ruta){
            LoginScreem(navController)
        }
        composable(route = Rutas.MenuPrincipal.ruta){
            Inicio(navController)
        }
    }
}











