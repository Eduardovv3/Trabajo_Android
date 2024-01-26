package com.example.trabajo_android

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true)
@Composable
fun LoginScreeem(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
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
fun Body(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        //Email()
        //Password()
        //ForgotPass()
        //LoginButton()
        //LoginDivisor()
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    //Image(
    //    painter = painterResource(id = ),
    //    contentDescription = "Logo"
    //)

}
