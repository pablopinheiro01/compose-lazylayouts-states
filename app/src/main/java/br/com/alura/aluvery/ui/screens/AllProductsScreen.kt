package br.com.alura.aluvery.ui.screens

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleCandies
import br.com.alura.aluvery.sampledata.sampleDrinks
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.sampledata.sampleSections
import br.com.alura.aluvery.ui.components.AllProducts
import br.com.alura.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal


@Composable
fun AllProductsScreen() {
    val largeItems = List(10000) {
        Product("name", price = BigDecimal("9.99"))
    }

    AllProducts(products = sampleProducts.plus(largeItems))
}

@Preview(showSystemUi = true)
@Composable
fun AllProductsScreenPreview() {
    AluveryTheme {
        Surface {
            AllProductsScreen()
        }
    }

}