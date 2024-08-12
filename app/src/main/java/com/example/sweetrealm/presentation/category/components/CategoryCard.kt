package com.example.sweetrealm.presentation.category.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sweetrealm.R
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.ui.theme.SweetRealmTheme

val CARD_HEIGHT = 130.dp
val CARD_WIDTH = 360.dp

@Composable
fun CategoryCard(
    name: String,
    image: Int,
    itemList: List<Sweet>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = modifier
            .height(165.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = "Category Image",
            modifier = Modifier
                .zIndex(1f)
                .size(60.dp)
                .clip(CircleShape)
        )
        ElevatedCard(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .size(CARD_WIDTH, CARD_HEIGHT)
                .offset { IntOffset(0, 30.dp.toPx().toInt()) }
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(36.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "View all",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary.copy(
                        alpha = 0.7f
                    ),
                    modifier = Modifier.clickable {
                        onClick()
                    }
                )
            }
            HorizontalDivider()
            LazyRow(
                state = state,
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            ) {
                items(itemList, key = {it.id}){
                    CategoryItem(name = it.name, imageUrl = it.imageUrl)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CategoryCardPreview() {
    SweetRealmTheme {
        Surface {
            CategoryCard(
                name = "Cake",
                image = R.drawable.chocolate_cake_image,
                itemList = listOf(),
                onClick = {  }
            )
        }
    }
}