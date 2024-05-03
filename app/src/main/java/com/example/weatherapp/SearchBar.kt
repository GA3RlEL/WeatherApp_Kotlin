package com.example.weatherapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.WeatherViewModel

@Composable
fun SearchBar(viewModel: WeatherViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = viewModel.text, onValueChange = {
            viewModel.updateText(it)
            if (it.length > 2) {
                viewModel.isSearching = true
                viewModel.fetchTowns(it)
            } else {
                viewModel.isSearching = false
            }
        }, label = {
            Text(text = "Search for a city")
        })
    }
}