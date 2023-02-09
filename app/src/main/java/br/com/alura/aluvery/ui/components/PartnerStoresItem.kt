package br.com.alura.aluvery.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alura.aluvery.R
import br.com.alura.aluvery.model.PartnerStores
import br.com.alura.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage

@Composable
fun PartnerStoresItem(
    modifier: Modifier = Modifier,
    item: PartnerStores
    ) {
         Card(
                modifier
                    .widthIn(
                        min = 150.dp,
                        max = 200.dp,
                    ),
                backgroundColor = Color.White,
            ) {
             Column(modifier) {
                 AsyncImage(
                     model = item.img,
                     contentDescription = null,
                     Modifier
                         .size(100.dp)
                         .align(CenterHorizontally)
                         .clip(shape = CircleShape),
                     placeholder = painterResource(id = R.drawable.placeholder),
                     contentScale = ContentScale.Crop
                 )
                 Text(
                     text = item.name,
                     modifier = modifier
                         .padding(top = 8.dp)
                         .align(CenterHorizontally),
                     fontSize = 16.sp,
                     maxLines = 2,
                     overflow = TextOverflow.Ellipsis,
                 )
             }
         }

}

@Preview
@Composable
fun PartnerStoresItemPreview() {
    AluveryTheme {
        Surface {
            PartnerStoresItem(item = PartnerStores(name = "Loja de Doces", img="",))
        }
    }
}