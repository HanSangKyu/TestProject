package com.example.main.nav

sealed class MainRoute(
    val name: String
) {
    object MainScreen : MainRoute("MainScreen")
    object WebViewScreen : MainRoute("WebViewScreen")
}