package com.example.sweetrealm.presentation.category.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

@Composable
fun CategoryCard(
    id: Int,
    name: String,
    image: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(150.dp,150.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        onClick = { onClick(id) }
    ) {
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = "Category Image",
            modifier = Modifier
                .weight(0.8f)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))

        )
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun CategoryCardPreview() {
    SweetRealmTheme {
        Surface {
            Column(Modifier.padding(8.dp).fillMaxSize()) {
                CategoryCard(id = 0, name = "Cake", image = R.drawable.cake, onClick = {  })
            }

        }
    }
}