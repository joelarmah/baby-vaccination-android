package com.github.joelarmah.babyvaccination.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity
import com.github.joelarmah.babyvaccination.data.local.database.entity.Vaccine
import com.github.joelarmah.babyvaccination.data.remote.repository.FakeVaccinationScheduleRepository
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyProfileViewModel
import com.google.gson.Gson

@Composable
fun HomeScreen(babyProfileViewModel: BabyProfileViewModel, vaccinationScheduleViewModel: VaccinationScheduleViewModel) {

    val vaccineSchedule by vaccinationScheduleViewModel.vaccinationSchedule.collectAsState()
    val babyProfile by babyProfileViewModel.baby.collectAsState()

    Log.d("HomeScreen", "Vaccination Schedule ==> ${Gson().toJson(vaccineSchedule)}")

    LaunchedEffect(babyProfile) {
        if (babyProfile.dob.isNotEmpty()) {
            vaccinationScheduleViewModel.loadSchedule(babyProfile.dob)
        }
    }

    val vaccinesData = listOf(
        VaccinationScheduleEntity(
            0,
            0, "At Birth", "April 21, 2024",
            listOf(
                Vaccine("BCG", ""),
                Vaccine("OPV 0", ""),
                Vaccine("Hepatitis B", "")
        ), "", "Deworming")
    )

    val vaccines = vaccinesData[0].vaccines

    val dates = vaccineSchedule.map { vaccine -> VaccineDates(vaccine.actualDate, vaccine.ageUserFriendly) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0628))
            .padding(bottom = 16.dp)
    ) {
        ProfileHeader(babyProfile)
        NextVaccineCard()
        DateChips(dates)
        VaccinesList(vaccines)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        BabyProfileViewModel(),
        VaccinationScheduleViewModel(LocalContext.current, FakeVaccinationScheduleRepository())
    )
}