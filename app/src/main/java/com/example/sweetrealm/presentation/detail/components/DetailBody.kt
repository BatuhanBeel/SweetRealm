package com.example.sweetrealm.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

@Composable
fun DetailBody(
    name: String,
    imageUrl: String,
    price: Float,
    isFavorite: Boolean,
    country: String,
    ingredients: String,
    onPopUpClicked: () -> Unit,
    onFavoriteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    val state = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(state),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = { onPopUpClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = MaterialTheme.colorScheme.secondary,
                    contentDescription = stringResource(R.string.back_icon),
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )
            }
            IconButton(onClick = { onFavoriteClicked() }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Star else Icons.Outlined.StarBorder,
                    tint = MaterialTheme.colorScheme.tertiary,
                    contentDescription = stringResource(R.string.favorite_icon),
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        AsyncImage(
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.dessert_detail_image),
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "$$price",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.country),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = country,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.ingredients),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = ingredients,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailBodyPreview() {
    SweetRealmTheme {
        Surface {
            DetailBody(
                name = "Ice Cream",
                imageUrl = "",
                price = 10.25f,
                isFavorite = true,
                country = "",
                ingredients = "",
                onPopUpClicked = { /*TODO*/ },
                onFavoriteClicked = { /*TODO*/ })
        }
    }
}