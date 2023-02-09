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
import br.com.alura.aluvery.model.PartnerStores
import br.com.alura.aluvery.sampledata.samplePartners
import br.com.alura.aluvery.ui.theme.AluveryTheme

//@Composable
//fun PartnerSection(
//    title: @Composable () -> Unit,
//    content: @Composable () -> Unit,
//    modifier:Modifier = Modifier
//){
//    Column(modifier) {
//        title()
//        content()
//    }
//
//}

@Composable
fun PartnerSection(
    title:String,
    modifier: Modifier = Modifier,
    partners: List<PartnerStores>
) {

    Section(
        title = {
            Text(
                text = title,
                modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 16.sp,
            )
        },
        content = {
            LazyRow(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ){
                items(partners){ p ->
                    PartnerStoresItem(item = p)
                }
            }

        },
        modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun PartnerSectionsPreview() {
    AluveryTheme {
        Surface {
            PartnerSection(title = "Lojas Parceiras", partners = samplePartners )
        }
    }
}