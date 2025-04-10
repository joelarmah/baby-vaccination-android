package com.github.joelarmah.babyvaccination.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyDobScreen
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyGenderScreen
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyNameScreen
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyProfileViewModel
import com.github.joelarmah.babyvaccination.ui.screens.home.HomeScreen
import com.github.joelarmah.babyvaccination.ui.screens.SplashScreen
import com.github.joelarmah.babyvaccination.ui.screens.home.VaccinationScheduleViewModel

@Composable
fun SetupNavGraph(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel, vaccinationScheduleViewModel: VaccinationScheduleViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.BabyName.route
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
        composable(route = Screen.Home.route) {
          HomeScreen(babyProfileViewModel, vaccinationScheduleViewModel)
        }
    }
}