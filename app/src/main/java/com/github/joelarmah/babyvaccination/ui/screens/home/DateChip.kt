package com.github.joelarmah.babyvaccination.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DateChips(dates: List<VaccineSchedule>) {
    LazyRow(
        modifier = Modifier
            .padding(top = 12.dp, start = 8.dp)
            .fillMaxWidth()
    ) {
        items(dates) { item ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(
                        if (item.label == "At Birth") Color(0xFFFF6D6D) else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            ) {
                Text(text = item.date, color = Color.White, fontWeight = FontWeight.Medium)
                Text(text = item.label, color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}