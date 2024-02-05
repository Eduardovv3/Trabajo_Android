package com.example.trabajo_android

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun LoginScreem(NavController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), NavController)
        //Footer(Modifier.align(Alignment.BottomCenter)
    }
}

@Composable
fun Header(modifier: Modifier){
    val activity = LocalContext.current as? Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Cerrar APP",
        modifier = modifier.clickable { activity?.finish() })
}
@Composable
fun Body(modifier: Modifier, NavController: NavHostController) {
    //var nombre by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var contrasenya by rememberSaveable { mutableStateOf("")}

    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        //Spacer(modifier = Modifier.size(20.dp))
        //Nombre(nombre){nombre = it}
        Spacer(modifier = Modifier.size(8.dp))
        Email(email) {email = it}
        Spacer(modifier = Modifier.size(8.dp))
        Password(contrasenya) {contrasenya = it}
        Spacer(modifier = Modifier.size(8.dp))
        //ForgotPass()
        LoginButton( email, contrasenya, NavController)
        //LoginDivisor()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = modifier
    )

}

/*@Composable
fun Nombre(nombre: String, funtion: (String) -> Unit){
    TextField(
        value = nombre,
        onValueChange = {funtion(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text( text = "Nombre")},
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, funtion: (String) -> Unit) {

    TextField(
        value = email,
        onValueChange = {funtion(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text( text = "Email")},
        maxLines = 1,
        singleLine = true,
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color(0xFFB2B2B2),
//            containerColor = Color(0xFFFAFAFA),
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}
@Composable
fun Password(contrasenya: String, funtion: (String) -> Unit) {
    var passVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = contrasenya,
        onValueChange = {funtion(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {Text( text = "Contraseña")},
        maxLines = 1,
        singleLine = true,
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color(0xFFB2B2B2),
//            containerColor = Color(0xFFFAFAFA),
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if(passVisibility)
                Icons.Filled.VisibilityOff
            else
                Icons.Filled.Visibility
            IconButton(onClick ={passVisibility = !passVisibility}) {
                Icon(imageVector = imagen, contentDescription = "Ver contraseña")
            }
        },
        visualTransformation =
        if(passVisibility)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}
@Composable
fun LoginButton(correo:String, contrasenya:String, NavController: NavHostController) {
    val context = LocalContext.current
    Button(
        onClick = {
            ListaUsuarios.forEach { usuario ->
                if (usuario.Correo == correo && usuario.Contrasenya == contrasenya){
                    NavController.navigate(route = Rutas.MenuPrincipal.ruta + "/" + correo)
                }else{
                    Toast.makeText(context , "El correo o contraseña no son correctos",  Toast.LENGTH_SHORT).show()

                }
            }  },
        enabled = true,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text("Log In")
    }
}


