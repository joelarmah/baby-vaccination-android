package com.github.joelarmah.babyvaccination.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.components.BabyVaccineTopBar

@Composable
fun BabyNameScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    val baby by babyProfileViewModel.baby.collectAsState()
    var name by remember { mutableStateOf(baby.name) }

    Scaffold(
        topBar = {
            BabyVaccineTopBar(
                title = "What's the name of your baby?",
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
            OutlinedTextField(
                value = baby.name,
                onValueChange = { newName ->
                    name = newName // Update the local name variable
                    babyProfileViewModel.setName(newName)
                },
                label = { Text("") },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    navController.navigate(Screen.BabyDoB.route)
                }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    navController.navigate(Screen.BabyDoB.route)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotBlank()
            ) {
                Text(
                    stringResource(R.string.next),
                )
            }
        }
    }
}

@Preview
@Composable
fun BabyNameScreenPreview() {
    BabyNameScreen(navController = rememberNavController(), BabyProfileViewModel())
}