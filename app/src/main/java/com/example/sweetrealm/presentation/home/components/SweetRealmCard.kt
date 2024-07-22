package com.example.sweetrealm.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

val CardPadding = 8.dp
val CardWidth = 125.dp
val CardHeight = 150.dp
val NewWidth = 40.dp
val NewHeight = 20.dp


@Composable
fun SweetRealmCard(
    name: String,
    image: Int,
    isNew: Boolean,
    isFavorite: Boolean,
    onClick: () -> Unit,
    onClickFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .padding(CardPadding)
    ){
        Card(
            modifier = Modifier
                .size(CardWidth, CardHeight),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 3.dp
            )
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    onClick = { onClickFavorite() }
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Star else Icons.Default.StarBorder,
                        tint = MaterialTheme.colorScheme.tertiary,
                        contentDescription = "Favorite Icon"
                    )
                }
                Column(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Image(
                        painter = painterResource(image),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Dessert Image",
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape)
                    )
                    Text(text = name, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
        if (isNew){
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
            ){
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
                    name = "Cake",
                    image = R.drawable.ice_cream,
                    isNew = true,
                    isFavorite = false,
                    onClick = { },
                    onClickFavorite = { }
                )
            }
        }
    }
}