package com.github.joelarmah.babyvaccination.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.components.BabyVaccineTopBar

@Composable
fun BabyGenderScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    val genderList: List<String> by remember { mutableStateOf(listOf("Male", "Female")) }
    val (selectedGender, onGenderSelected) = remember { mutableStateOf<String?>(null) }

    val updateGender: (String) -> Unit = { newGender ->
        babyProfileViewModel.setGender(newGender)
    }

    val baby by babyProfileViewModel.baby.collectAsState()

    Scaffold(
        topBar = {
            BabyVaccineTopBar(
                title = "What is ${baby.getFirstName()}'s gender?",
                subTitle = null
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            genderList.forEach { gender ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (gender == selectedGender),
                            onClick = { onGenderSelected(gender) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (gender == selectedGender),
                        onClick = null // null recommended for accessibility with screen readers
                    )
                    Text(
                        text = gender,
                        style = MaterialTheme.typography.bodyMedium.merge(),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    selectedGender?.let { gender ->
                        if (gender.isNotBlank()) {
                            updateGender(gender)
                        }
                        navController.navigate(Screen.Congratulation.route)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !selectedGender.isNullOrBlank()
            ) {
                Text("Create ${baby.getFirstName()}'s Profile")
            }
        }
    }

}

@Preview
@Composable
fun BabyGenderScreenPreview() {
    BabyGenderScreen(navController = rememberNavController(), BabyProfileViewModel())
}