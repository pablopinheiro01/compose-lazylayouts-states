package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(
    title: String,
    modifier: Modifier = Modifier,
    products: List<Product>
) {
    Section(
        title = {
            Text(
                text = title,
                modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            )
        },
        content = {
            LazyRow(
                modifier
                    .padding(
                        top = 8.dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(products) { p ->
                    ProductItem(product = p)
                }

            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }
}