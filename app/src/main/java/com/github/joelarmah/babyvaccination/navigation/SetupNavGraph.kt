package com.github.joelarmah.babyvaccination.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.joelarmah.babyvaccination.ui.screens.BabyDobScreen
import com.github.joelarmah.babyvaccination.ui.screens.BabyGenderScreen
import com.github.joelarmah.babyvaccination.ui.screens.BabyNameScreen
import com.github.joelarmah.babyvaccination.ui.screens.BabyProfileViewModel
import com.github.joelarmah.babyvaccination.ui.screens.CongratulationScreen
import com.github.joelarmah.babyvaccination.ui.screens.home.HomeScreen
import com.github.joelarmah.babyvaccination.ui.screens.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.BabyName.route) {
            BabyNameScreen(navController = navController, babyProfileViewModel)
        }
        composable(route = Screen.BabyDoB.route) {
            BabyDobScreen(navController = navController, babyProfileViewModel)
        }
        composable(route = Screen.BabyGender.route) {
            BabyGenderScreen(navController = navController, babyProfileViewModel)
        }
        composable(route = Screen.Congratulation.route) {
            CongratulationScreen(navController = navController, babyProfileViewModel)
        }
        composable(route = Screen.Home.route) {
          HomeScreen(babyProfileViewModel)
        }
    }
}