package com.avazpar.designsystem.atoms

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EventBody(
    body: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}