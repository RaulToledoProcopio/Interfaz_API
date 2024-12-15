package com.example.interfaz_api.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import com.example.interfaz_api.R
import com.example.interfaz_api.Navigation.AppScreen

@Composable
fun PortadaScreen(navController: NavController) {
    var isLoading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp) // Altura ajustable
                    .padding(top = 32.dp, bottom = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                IconElement(R.drawable.icono1, "Icono 1")
                IconElement(R.drawable.icono2, "Icono 2")
                IconElement(R.drawable.icono3, "Icono 3")
                IconElement(R.drawable.icono4, "Icono 4")
                IconElement(R.drawable.icono5, "Icono 5")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    isLoading = true
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
            ) {
                Text("Acceder", fontSize = 18.sp, color = Color.White)
            }
        }

        if (isLoading) {
            LaunchedEffect(Unit) {
                delay(5000) // Simular carga por 5 segundos
                isLoading = false
                navController.navigate(AppScreen.Principal.route) // Navegar a Principal
            }

            CircularProgressIndicator(modifier = Modifier.size(80.dp), color = Color.Red)
        }
    }
}

@Composable
fun IconElement(iconRes: Int, contentDescription: String) {
    Icon(
        painter = painterResource(id = iconRes),
        contentDescription = contentDescription,
        tint = Color.Unspecified,
        modifier = Modifier.size(50.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PortadaScreenPreview() {
    PortadaScreen(navController = rememberNavController())
}
