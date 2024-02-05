package com.example.trabajo_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Valorar(innerPadding: PaddingValues){
    var sliderPosition by rememberSaveable { mutableStateOf(0f) }
    var texto by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Text(text = "Esta ventana es para que nos proporciones tu opinion sobre la pagina",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp),
            fontSize = 15.sp,
            color = Color.White

        )
        TextField(
            value = texto,
            onValueChange = {texto = it},
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp),
            placeholder = {Text( text = "Danos tu opinion")},
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color(0xFFB2B2B2),
//            containerColor = Color(0xFFFAFAFA),
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..10f,
            steps = 9,
            modifier = Modifier
                .padding(horizontal = 20.dp)

        )
        Text(text = "%.0f".format(sliderPosition),
            color = Color.White)
    }
}
@Composable
fun ScaffoldValorar(navController: NavController){
    Scaffold(
        topBar = { topBarValorar(navController) },
        content = { innerPadding ->
            Valorar(innerPadding)
        },

        )


}


@Composable
fun topBarValorar(navController: NavController){
    Row {
        IconButton(onClick = {navController.popBackStack()},) {
            Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Pa tras")
        }
        Text(text = "Valoracion",
            Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun valoracionPreview(){
    val navController = rememberNavController()
    ScaffoldValorar(navController)
}