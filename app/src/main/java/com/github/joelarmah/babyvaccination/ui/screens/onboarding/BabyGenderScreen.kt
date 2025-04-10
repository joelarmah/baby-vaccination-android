package com.github.joelarmah.babyvaccination.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
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
            LargeTopAppBar(
                title = {
                    Column {
                        Text(
                            text = "What is ${baby.name}'s gender?",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },

                Modifier.background(Color.Blue)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                enabled = !selectedGender.isNullOrEmpty(),
                onClick = {
                    selectedGender?.let { gender ->
                        if (gender.isNotBlank()) {
                            updateGender(gender)
                        }
                        navController.navigate(Screen.Home.route)
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = Spacing.md),
            ) {
                Text("Create ${baby.name}'s Profile")
            }
        }
    }

}

@Preview
@Composable
fun BabyGenderScreenPreview() {
    BabyGenderScreen(navController = rememberNavController(), BabyProfileViewModel())
}