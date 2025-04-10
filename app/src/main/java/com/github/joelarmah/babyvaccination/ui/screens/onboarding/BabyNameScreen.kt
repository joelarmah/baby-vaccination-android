package com.github.joelarmah.babyvaccination.ui.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.navigation.Screen
import com.github.joelarmah.babyvaccination.ui.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BabyNameScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    var name by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    val updateName: (String) -> Unit = { newName ->
        babyProfileViewModel.setName(newName)
    }

    fun handleSubmitName(
        name: String,
        babyProfileViewModel: BabyProfileViewModel,
        navController: NavHostController,
        keyboardController: SoftwareKeyboardController?
    ) {
        if (name.isNotBlank()) {
            babyProfileViewModel.setName(name)
            keyboardController?.hide()
            navController.navigate(Screen.BabyDoB.route)
        }
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
                    handleSubmitName(name, babyProfileViewModel, navController, keyboardController)
                }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = Spacing.md)
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                enabled = name.isNotBlank(),
                onClick = {
                    handleSubmitName(name, babyProfileViewModel, navController, keyboardController)
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = Spacing.md),
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