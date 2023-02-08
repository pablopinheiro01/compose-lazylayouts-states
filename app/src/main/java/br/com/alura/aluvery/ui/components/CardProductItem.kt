package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.extensions.toBrazilianCurrency
import br.com.alura.aluvery.model.Product
import br.com.alura.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded: Boolean = false
) {
    var expandedState by remember {
        mutableStateOf(expanded)
    }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expandedState = !expandedState
            },
        elevation = elevation,
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            var textOverflow =  TextOverflow.Ellipsis
            var maxLines = 2

            if (expandedState) {
                textOverflow = TextOverflow.Visible
                maxLines = Int.MAX_VALUE
            }
            product.description?.let {

                Text(
                    text = product.description,
                    Modifier
                        .padding(16.dp),
                    overflow = textOverflow,
                    maxLines = maxLines,
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Hamburguer",
                    price = BigDecimal("12.99"),
                    image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
                ),
            )
        }
    }
}

@Preview
@Composable
fun CardProductItemDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Hamburguer",
                    price = BigDecimal("12.99"),
                    image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
                    description = LoremIpsum(50).values.first()
                )
            )
        }
    }

}