package com.example.main.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.mvrx.compose.mavericksViewModel
import com.airbnb.mvrx.hellohilt.ProductMavericksViewModel
import com.example.main.home.HomeRoute
import com.example.main.home.HomeViewModel
import com.example.main.home.LinkRoute

@Composable
fun MainNavHost(
    viewModel: HomeViewModel=  hiltViewModel(),
    viewModel1: ProductMavericksViewModel = mavericksViewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoute.MainScreen.name
    ) {
        composable(
            route = MainRoute.MainScreen.name,
            enterTransition = {
                // 홈에서 들어올 때는 기본 슬라이딩 없이 바로 표시
                null
            },
            exitTransition = {
                // 홈에서 상세로 갈 때는 왼쪽으로 슬라이딩
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            HomeRoute(
                viewModel = viewModel,
                viewModel2 = viewModel1,
                onNavigateToDetailScreen = { reservation ->
                    viewModel1.setLink(reservation)
                    navController.navigate(MainRoute.DetailScreen.name)
//                    navController.navigate("${MainRoute.DetailScreen.name}/")
                }
            )
        }
        composable(
            route = MainRoute.DetailScreen.name,
            arguments = listOf(
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) { backStackEntry ->
//            val url = backStackEntry.arguments?.getString("reservation")
//            val reservation = Json.decodeFromString<String>(reservationJson!!)
            LinkRoute(
                viewModel2 = viewModel1,
                onBack = { navController.popBackStack() }
            )
        }
    }
}