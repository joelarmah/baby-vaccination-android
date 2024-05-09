package com.github.joelarmah.babyvaccination.data

import androidx.compose.ui.graphics.ImageBitmap

data class Vaccine(
    val id: String = "",
    val name: String = "",
    val dueDate: String = "",
    val image: ImageBitmap? = null
)
