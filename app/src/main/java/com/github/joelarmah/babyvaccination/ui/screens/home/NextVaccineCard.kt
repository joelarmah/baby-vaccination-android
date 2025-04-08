package com.github.joelarmah.babyvaccination.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NextVaccineCard(
    nextVaccineDate: String = "June 2, 2024",
    numberOfVaccinesTaken: Int = 0,
    totalNumberOfVaccines: Int = 0
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F7C2)
        )
    ) {
        Row(
            Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Next\nVaccine Due", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(nextVaccineDate, color = Color(0xFFE57373), fontSize = 16.sp)
            }

            Box(
                modifier = Modifier.padding()
            ) {
                CircularProgressIndicator(
                    progress = { 0f },
                    modifier = Modifier.size(80.dp),
                    color = Color(0xFF9C9CFF),
                    strokeWidth = 8.dp,
                    trackColor = Color(0xFF9C9CFF)
                )
                Column(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "${numberOfVaccinesTaken}/${totalNumberOfVaccines}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        "Vaccines taken",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }


            }

        }
    }
}

@Preview
@Composable
fun NextVaccinePreview() {
    NextVaccineCard()
}