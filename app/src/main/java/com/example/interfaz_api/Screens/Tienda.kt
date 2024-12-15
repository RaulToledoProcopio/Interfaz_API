package com.example.interfaz_api.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.interfaz_api.Navigation.BottomNavigationBar
import com.example.interfaz_api.R

data class Producto(val imagen: Int, val precio: String)

@Composable
fun TiendaScreen(navController: NavController) {
    val productos = listOf(
        Producto(R.drawable.juego_tienda1, "Precio: €9.99"),
        Producto(R.drawable.juego_tienda2, "Precio: €29.99"),
        Producto(R.drawable.juego_tienda3, "Precio: €39.99"),
        Producto(R.drawable.juego_tienda4, "Precio: €49.99"),
        Producto(R.drawable.juego_tienda5, "Precio: €59.99")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo de pantalla",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp)
        ) {

            IconButton(
                onClick = { navController.navigate("principal") },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }

            Text(
                text = "Tienda",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)
        ) {
            items(productos.size) { index ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = productos[index].imagen),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                    )

                    Text(
                        text = productos[index].precio,
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                        onClick = {},
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text("Comprar")
                    }
                }
            }
        }
        
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            BottomNavigationBar(navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TiendaScreenPreview() {
   TiendaScreen(navController = rememberNavController())
}
