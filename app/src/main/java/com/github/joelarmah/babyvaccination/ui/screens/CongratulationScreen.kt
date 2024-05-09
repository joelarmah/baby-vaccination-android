package com.github.joelarmah.babyvaccination.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.navigation.Screen

@Composable
fun CongratulationScreen(navController: NavHostController, babyProfileViewModel: BabyProfileViewModel) {

    val baby by babyProfileViewModel.baby.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "\uD83C\uDF8A",
                fontSize = 40.sp
            )

            Text(
                text = "Welcome ${baby.name} into the family",
                color = Color.Gray,
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(R.string.congratulations),
                color = Color.Red,
                fontSize = 26.sp
            )
            Text(
                text = "We are excited to help you bring this bundle of joy into your family.",
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    navController.navigate(Screen.Home.route)
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.continue_text))
            }
        }
    }
}

@Preview
@Composable
fun CongratulationScreenPreview() {
    CongratulationScreen(rememberNavController(), BabyProfileViewModel())
}