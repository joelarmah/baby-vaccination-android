package com.github.joelarmah.babyvaccination.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BabyNameScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    var name by remember { mutableStateOf("") }

    val updateName: (String) -> Unit = { newName ->
        babyProfileViewModel.setName(newName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("What's the name of your baby?")
                },
                // Modifier.background(Color.Blue)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("") },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    if (name.isNotBlank()) {
                        updateName(name)
                    }
                }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (babyProfileViewModel.baby.value.name.isNotBlank()) {
                        updateName(name)
                    }
                    navController.navigate(Screen.BabyDoB.route)
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview
@Composable
fun BabyNameScreenPreview() {
    BabyNameScreen(navController = rememberNavController(), BabyProfileViewModel())
}