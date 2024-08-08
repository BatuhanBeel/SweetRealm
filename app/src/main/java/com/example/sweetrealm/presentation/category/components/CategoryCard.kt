package com.example.sweetrealm.presentation.category.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.example.sweetrealm.presentation.home.dessertList
import com.example.sweetrealm.ui.theme.SweetRealmTheme

val CARD_HEIGHT = 150.dp
val CARD_WIDTH = 360.dp

@Composable
fun CategoryCard(
    name: String,
    image: Int,
    itemList: List<Sweet>,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()

    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            contentDescription = "Category Image",
            modifier = Modifier
                .zIndex(1f)
                .size(60.dp)
                .clip(CircleShape)
        )
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .size(CARD_WIDTH, CARD_HEIGHT)
                .offset { IntOffset(0, 30) }
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "View all",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary.copy(
                        alpha = 0.7f
                    )
                )
            }
            HorizontalDivider()
            LazyRow(
                state = state,
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemList, key = {it.id}){
                    CategoryItem(name = it.name, image = it.image)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CategoryCardPreview() {
    SweetRealmTheme {
        Surface(Modifier.fillMaxSize()) {
            CategoryCard(
                name = "Cake",
                image = R.drawable.cake,
                itemList = dessertList
            )
        }
    }
}