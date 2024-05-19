package com.github.joelarmah.babyvaccination.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.data.model.Vaccine
import com.github.joelarmah.babyvaccination.data.model.VaccineStats

@Composable
fun NextVaccineCard(nextVaccine: Vaccine, vaccineStats: VaccineStats) {
    Card (
        modifier = Modifier
            .background(colorResource(R.color.yellow))
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .background(colorResource(R.color.yellow))
                    .fillMaxWidth()
                    .padding(vertical = 8.dp) // Add padding to the Row
        ) {
            // nextVaccine.image?.let { Image(bitmap = it, contentDescription = "Vaccine image") }
            Column {
                Text(
                    text = "Next Vaccine due",
                    fontSize = 25.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(nextVaccine.dueDate)
            }

            Spacer(modifier = Modifier.width(16.dp))

            val (numberOfVaccinesTaken, totalVaccines) = vaccineStats
            val percentage = numberOfVaccinesTaken.toFloat()/totalVaccines.toFloat()

            CircularProgressBar(percentage = percentage, displayText = "0/20")
        }
    }

}

@Preview
@Composable
fun NextVaccineCardPreview() {
    NextVaccineCard(
        nextVaccine = Vaccine("1", "BCG", dueDate = "June 2, 2024"),
        vaccineStats = VaccineStats(20, 40)
    )
}
