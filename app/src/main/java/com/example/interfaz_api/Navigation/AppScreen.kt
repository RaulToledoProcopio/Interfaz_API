package com.example.interfaz_api.Navigation

sealed class AppScreen(val route: String) {
    object Portada : AppScreen("portada")
    object Principal : AppScreen("principal")
    object API : AppScreen("api")
    object Tienda : AppScreen("tienda")
    object Biblioteca : AppScreen("biblioteca")
}