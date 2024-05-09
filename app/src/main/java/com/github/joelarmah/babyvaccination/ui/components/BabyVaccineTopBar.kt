package com.github.joelarmah.babyvaccination.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BabyVaccineTopBar(title: String, subTitle: String? = null) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                subTitle?.let {
                    Text(
                        text = subTitle,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
    )
}

@Preview
@Composable
fun BabyVaccineTopBarPreview() {
    BabyVaccineTopBar("Title", "Subtitle")
}