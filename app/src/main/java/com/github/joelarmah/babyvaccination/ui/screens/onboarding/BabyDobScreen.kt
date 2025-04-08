package com.github.joelarmah.babyvaccination.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.components.BabyVaccineTopBar
import com.github.joelarmah.babyvaccination.ui.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BabyDobScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    val date by remember { mutableStateOf("") }

    val updateDoB: (String) -> Unit = { newDoB ->
        babyProfileViewModel.setDoB(newDoB)
    }

    val baby by babyProfileViewModel.baby.collectAsState()

    Scaffold(
        topBar = {
            BabyVaccineTopBar(
                title = "When was ${baby.name} born?",
                subTitle = "We’ll use this to calculate your baby’s vaccination schedule"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(1f))

            val datePickerState = rememberDatePickerState()
            DatePicker(state = datePickerState)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (date.isNotBlank()) {
                        updateDoB(date)
                    }
                    navController.navigate(Screen.BabyGender.route)
                },
                Modifier.fillMaxWidth().padding(
                    horizontal = Spacing.md
                ),
            ) {
                Text("Continue")
            }
        }
    }

}

@Preview
@Composable
fun BabyDobScreenPreview() {
    BabyDobScreen(navController = rememberNavController(), BabyProfileViewModel())
}