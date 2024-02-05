package com.example.trabajo_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Rutas.LoginSceem.ruta) {
            composable(route = Rutas.LoginSceem.ruta) {
                LoginScreem(navController)
            }
            composable(route = Rutas.MenuPrincipal.ruta + "/{correo}",
                arguments = listOf(navArgument(name = "correo"){
                    type = NavType.StringType
                }))
            {
                Inicio(navController, it.arguments?.getString("correo"))
            }
            composable(route = Rutas.ComidaChina.ruta){
                ScaffoldChino(navController)
            }
            composable(route = Rutas.ComidaJaponesa.ruta){
                ScaffoldJapones(navController)
            }
            composable(route = Rutas.ComidaJaponesa.ruta){
                ScaffoldJapones(navController)
            }
            composable(route = Rutas.Valoracion.ruta){
                ScaffoldValorar(navController)
            }
            composable(route = Rutas.Cesta.ruta){
                ScaffoldCesta(navController)
            }
        }
    }




@Composable
fun MyNavigationDrawer(navController: NavHostController, onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(20.dp)) {

        Text(
            text = "Comida china",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable {
                    onCloseDrawer()
                    navController.navigate(Rutas.ComidaChina.ruta)
                }
        )
        Text(
            text = "Comida japonesa",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable {
                    onCloseDrawer()
                    navController.navigate(Rutas.ComidaJaponesa.ruta)
                }
        )
        Text(
            text = "Valora nuestra APP",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .clickable {
                    onCloseDrawer()
                    navController.navigate(Rutas.Valoracion.ruta)
                }
        )

    }
}







