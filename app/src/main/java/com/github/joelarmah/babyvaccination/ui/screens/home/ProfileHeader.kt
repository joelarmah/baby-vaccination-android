package com.github.joelarmah.babyvaccination.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.joelarmah.babyvaccination.ui.screens.onboarding.BabyProfile

@Composable
fun ProfileHeader(baby: BabyProfile) {

//    val baby by babyProfileViewModel.baby.collectAsState()
    val babyEmoji = when (baby.gender.lowercase()) {
        "female" -> "👧🏾"
        "male" -> "🧒🏾"
        else -> ""
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("$babyEmoji ${baby.name}", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}