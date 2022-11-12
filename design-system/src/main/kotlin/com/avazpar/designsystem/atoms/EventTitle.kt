package com.avazpar.designsystem.atoms

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.avazpar.designsystem.foundations.Brown


@Composable
fun EventTitle(title: String) {
    Text(
        text = title,
        color = Brown,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
    )
}