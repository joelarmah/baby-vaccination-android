package com.github.joelarmah.babyvaccination.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.components.BabyVaccineTopBar
import com.github.joelarmah.babyvaccination.utils.DateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BabyDobScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    val currentDateMillis = System.currentTimeMillis()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = currentDateMillis,
    )

    val selectedDateMillis = datePickerState.selectedDateMillis

    val selectedDate = if (selectedDateMillis != null) {
        DateUtils.formatDateFromMillis(selectedDateMillis)
    } else {
        ""
    }

    val baby by babyProfileViewModel.baby.collectAsState()

    Scaffold(topBar = {
        BabyVaccineTopBar(
            title = stringResource(R.string.baby_dob_title, baby.getFirstName()),
            subTitle = stringResource(id = R.string.baby_dob_sub_title)
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DatePicker(
                title = {},
                state = datePickerState
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    if (selectedDate.isNotBlank()) {
                        babyProfileViewModel.setDoB(selectedDate)
                        navController.navigate(Screen.BabyGender.route)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedDate.isNotBlank()
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }

}

@Preview
@Composable
fun BabyDobScreenPreview() {
    BabyDobScreen(navController = rememberNavController(), BabyProfileViewModel())
}