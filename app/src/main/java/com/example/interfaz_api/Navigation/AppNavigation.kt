package com.example.interfaz_api.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.interfaz_api.Screens.ApiScreen
import com.example.interfaz_api.Screens.PortadaScreen
import com.example.interfaz_api.Screens.PrincipalScreen
import com.example.interfaz_api.Screens.TiendaScreen
import com.example.interfaz_api.Screens.BibliotecaScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.Portada.route) {
        composable(AppScreen.Portada.route) { PortadaScreen(navController) }
        composable(AppScreen.Principal.route) { PrincipalScreen(navController) }
        composable(AppScreen.API.route) { ApiScreen(navController) }
        composable(AppScreen.Tienda.route) { TiendaScreen(navController) }
        composable(AppScreen.Biblioteca.route) { BibliotecaScreen(navController) }

    }
}