package com.github.joelarmah.babyvaccination.ui.screens.home

import com.github.joelarmah.babyvaccination.ui.components.NextVaccineCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.joelarmah.babyvaccination.data.model.Vaccine
import com.github.joelarmah.babyvaccination.data.model.VaccineStats
import com.github.joelarmah.babyvaccination.ui.screens.BabyProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(babyProfileViewModel: BabyProfileViewModel) {

    val baby by babyProfileViewModel.baby.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { baby.name },
                modifier = Modifier
                    .background(Color.Black)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .background(Color.White),
        ) {
            Column {
                NextVaccineCard(
                    nextVaccine = Vaccine("1", "BCG", "June 2, 2014" ),
                    vaccineStats = VaccineStats(20, 40)
                )

                Spacer(modifier = Modifier.padding(10.dp))

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(BabyProfileViewModel())
}