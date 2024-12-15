package com.example.interfaz_api.Navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.interfaz_api.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Principal", R.drawable.icono_barra1, AppScreen.Principal.route),
        BottomNavItem("Biblioteca", R.drawable.icono_barra2, AppScreen.Biblioteca.route),
        BottomNavItem("Compras", R.drawable.icono_barra3, AppScreen.Tienda.route)
    )

    NavigationBar(
        containerColor = Color(0xFF333333)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        item.title,
                        color = Color(0xFFB0B0B0)
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (item.route.isNotEmpty() && currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(AppScreen.Principal.route) { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}

data class BottomNavItem(val title: String, val icon: Int, val route: String)
