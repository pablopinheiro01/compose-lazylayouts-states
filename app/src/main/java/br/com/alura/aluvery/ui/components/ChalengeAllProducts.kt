package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.sampledata.sampleCandies
import br.com.alura.aluvery.sampledata.sampleDrinks
import br.com.alura.aluvery.sampledata.sampleProducts
import br.com.alura.aluvery.ui.theme.AluveryTheme

@Composable
fun AllProducts(
    products: List<Product>
) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),

        ) {
        item(span ={ GridItemSpan(maxLineSpan) }, ){
            Text(
                text = "Todos produtos",
                Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight(400)
            )
        }
        items(products) { product ->
            ProductItem(product = product)
        }
    }


}

//sample code usando colum para colocar o header
//@Composable
//fun AllProducts(
//    products: List<Product>
//) {
//    Column {
//        Text(
//            text = "Todos produtos",
//            Modifier.padding(
//                start = 16.dp,
//                end = 16.dp
//            ),
//            fontSize = 20.sp,
//            fontWeight = FontWeight(400)
//        )
//
//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 128.dp),
//            contentPadding = PaddingValues(10.dp),
//            verticalArrangement = Arrangement.spacedBy(10.dp),
//            horizontalArrangement = Arrangement.spacedBy(10.dp)
//        ) {
//            items(products) { product ->
//                ProductItem(product = product)
//            }
//        }
//    }
//
//}

@Preview
@Composable
fun AllProductsPreview() {
    AluveryTheme {
        Surface {
            AllProducts(
                products = listOf<Product>().plus(sampleProducts).plus(sampleDrinks)
                    .plus(sampleCandies)
            )
        }
    }

}