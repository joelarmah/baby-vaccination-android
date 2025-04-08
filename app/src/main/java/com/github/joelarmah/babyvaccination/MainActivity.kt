package com.github.joelarmah.babyvaccination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.SetupNavGraph
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyProfileViewModel
import com.github.joelarmah.babyvaccination.ui.theme.BabyVaccinationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val babyProfileViewModel by viewModels<BabyProfileViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BabyVaccinationTheme {
                Content(babyProfileViewModel)
            }
        }
    }
}

@Composable
fun Content(babyProfileViewModel: BabyProfileViewModel) {
    BabyVaccinationTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController, babyProfileViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Content(BabyProfileViewModel())
}