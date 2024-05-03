package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.CircularProgressBarWithText
import com.example.weatherapp.WeatherViewModel

@Composable
fun UvSection(viewModel: WeatherViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20))
            .background(viewModel.backgroundSectionColor),

        )
    {

        Row(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = "UV INDEX",
                color = viewModel.sectionTitleColor,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressBarWithText(
                viewModel.data.daily.uv_index_max[0].toFloat() / 10,
                "${viewModel.data.daily.uv_index_max[0]}"
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))


    }
}