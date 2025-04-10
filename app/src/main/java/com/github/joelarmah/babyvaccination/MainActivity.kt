package com.github.joelarmah.babyvaccination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.data.remote.repository.FakeVaccinationScheduleRepository
import com.github.joelarmah.babyvaccination.navigation.SetupNavGraph
import com.github.joelarmah.babyvaccination.ui.screens.home.VaccinationScheduleViewModel
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyProfileViewModel
import com.github.joelarmah.babyvaccination.ui.theme.BabyVaccinationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val babyProfileViewModel by viewModels<BabyProfileViewModel> ()
    private val vaccinationScheduleViewModel by viewModels<VaccinationScheduleViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BabyVaccinationTheme {
                Content(babyProfileViewModel, vaccinationScheduleViewModel)
            }
        }
    }
}

@Composable
fun Content(babyProfileViewModel: BabyProfileViewModel, vaccinationScheduleViewModel: VaccinationScheduleViewModel) {
    BabyVaccinationTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController, babyProfileViewModel, vaccinationScheduleViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Content(BabyProfileViewModel(), VaccinationScheduleViewModel(LocalContext.current, FakeVaccinationScheduleRepository()))
}