package br.com.alura.aluvery.ui.screens

import android.graphics.drawable.shapes.Shape
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.CardProductItem
import br.com.alura.aluvery.ui.components.ProductsSection
import br.com.alura.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal
import kotlin.random.Random

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {

    Column {

        var text by remember { mutableStateOf("${Random.nextInt()}") }
        OutlinedTextField(
            value = text,
            onValueChange = { newValue ->
                text = newValue
                Log.i("HomeScreen", "HomeScreen: textField $newValue")
                Log.i("HomeScreen", "HomeScreen: state $text")
            },
            Modifier
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

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(sampleProducts){ p->
             CardProductItem(
                 product = p,
                 Modifier.padding(horizontal = 16.dp),
                 expanded = true,

             )
            }
//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ProductsSection(
//                        title = title,
//                        products = products
//                    )
//                }
//            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}