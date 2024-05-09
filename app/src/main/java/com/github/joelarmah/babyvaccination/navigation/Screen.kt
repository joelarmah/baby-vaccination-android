package com.github.joelarmah.babyvaccination.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object BabyName : Screen("baby_name_screen")
    data object BabyDoB : Screen("baby_dob_screen")
    data object BabyGender : Screen("baby_gender_screen")
    data object Home : Screen("home_screen")
    data object Congratulation : Screen("congratulation_screen")

}