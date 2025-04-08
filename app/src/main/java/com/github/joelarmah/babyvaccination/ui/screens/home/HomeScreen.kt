package com.github.joelarmah.babyvaccination.ui.screens.home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    val vaccines = listOf(
        Vaccine("BCG", Icons.Default.Face, false),
        Vaccine("OPV 0", Icons.Default.Face, false),
        Vaccine("Hepatitis B", Icons.Default.Face, true)
    )

    val dates = listOf(
        VaccineSchedule("April 21, 2024", "At Birth"),
        VaccineSchedule("June 2, 2024", "6 weeks"),
        VaccineSchedule("June 30, 2024", "10 weeks"),
        VaccineSchedule("July 28, 2024", "14 weeks")
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0628))
            .padding(bottom = 16.dp)
    ) {
        ProfileHeader(name = "Naa")
        NextVaccineCard()
        DateChips(dates)
        VaccinesList(vaccines)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}