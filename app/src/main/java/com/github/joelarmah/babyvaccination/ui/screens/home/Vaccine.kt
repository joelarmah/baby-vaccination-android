package com.github.joelarmah.babyvaccination.ui.screens.home

import androidx.compose.ui.graphics.vector.ImageVector

data class Vaccine(
    val name: String,
    val icon: ImageVector,
    val taken: Boolean
)

data class VaccineSchedule(
    val date: String,
    val label: String
)