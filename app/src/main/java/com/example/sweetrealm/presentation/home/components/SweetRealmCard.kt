package com.example.sweetrealm.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

val CardPadding = 8.dp
val CardWidth = 125.dp
val CardHeight = 165.dp
val NewWidth = 40.dp
val NewHeight = 20.dp


@Composable
fun SweetRealmCard(
    id: Int,
    name: String,
    imageUrl: String,
    price: Float,
    isNew: Boolean,
    isFavorite: Boolean,
    onClick: (Int) -> Unit,
    onClickFavorite: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(CardPadding)
    ) {
        Card(
            modifier = Modifier
                .size(CardWidth, CardHeight),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick(id) },

                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {

                Icon(
                    imageVector = if (isFavorite) Icons.Default.Star else Icons.Default.StarBorder,
                    tint = MaterialTheme.colorScheme.tertiary,
                    contentDescription = "Favorite Icon",
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.End)
                        .clickable { onClickFavorite(id) }
                )
                AsyncImage(
                    model = imageUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Dessert Image",
                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .height(30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Text(
                    text = "$ $price",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.tertiary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
        if (isNew) {
            Box(modifier = Modifier
                .size(NewWidth, NewHeight)
                .offset {
                    IntOffset(
                        x = 0,
                        y = -(NewHeight / 2)
                            .toPx()
                            .toInt()
                    )
                }
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.large
                )
                .align(Alignment.TopCenter),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.new_item),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,

                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SweetRealmCardPreview() {
    SweetRealmTheme {
        Surface {
            Column {
                SweetRealmCard(
                    id = 0,
                    name = "Ice Cream",
                    imageUrl = "",
                    price = 10.25f,
                    isNew = true,
                    isFavorite = false,
                    onClick = { },
                    onClickFavorite = { }
                )
            }
        }
    }
}