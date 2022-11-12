package com.avazpar.designsystem.atoms

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.avazpar.designsystem.foundations.Brown

@Composable
fun EventBody(
    body: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            color = Brown,
            text = body,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}