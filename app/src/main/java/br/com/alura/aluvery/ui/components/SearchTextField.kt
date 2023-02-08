package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,//conceito de elevação de estado,
    modifier: Modifier = Modifier
) {


    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue ->
            onSearchChange(newValue)
        },
        modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(percent = 100),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Filter your option")
        },
        label = {
            Text("Produto")
        },
        placeholder = {
            Text(text = "What do you find ?")
        }
    )


}