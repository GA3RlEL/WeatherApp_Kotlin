package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBarWithText(
    progress: Float,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier
                .size(100.dp),
            color = Color(177, 151, 252),
            strokeWidth = 12.dp
            

        )
        Text(
            text = text,
            style = TextStyle(color = Color.Black), // adjust text style as needed
            modifier = Modifier.padding(4.dp),
            color = Color(177, 151, 252),// adjust padding as needed
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}