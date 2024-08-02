package com.example.sweetrealm.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

@Composable
fun DetailScreen(
    argumentId: Int,
    onPopUpClick: () -> Unit
) {

    var quantityState by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            HorizontalDivider(color = MaterialTheme.colorScheme.outline)
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Qty",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(0.20f)
                )
                IconButton(onClick = { if(quantityState > 0){
                    quantityState--
                }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Decrease Quantity",
                        modifier = Modifier
                            .weight(0.1f)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
                Text(
                    text = quantityState.toString(), style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
                IconButton(onClick = { quantityState++ }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Increase Quantity",
                        modifier = Modifier
                            .weight(0.1f)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
                Button(
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors()
                        .copy(containerColor = MaterialTheme.colorScheme.primary),
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .weight(0.6f)
                ) {
                    Text(
                        text = "Add To Card",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    ) { innerPadding ->
        DetailBody(
            name = "Cake",
            image = R.drawable.cake,
            price = 10.25f,
            isFavorite = false,
            details = "Our really easy chocolate cake recipe is perfect for birthdays. Each serving provides 477 kcal, 6.5g protein, 56g carbohydrates (of which 40g sugars), 25g fat (of which 10.5g saturates), 2.5g fibre and 0.6g salt.",
            ingredients = "Chocolate, Vanilla, Eggs, Butter, Cream",
            onPopUpClicked = onPopUpClick,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun DetailBody(
    name: String,
    image: Int,
    price: Float,
    isFavorite: Boolean,
    details: String,
    ingredients: String,
    onPopUpClicked: () -> Unit,
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
                    contentDescription = "Back Icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Star else Icons.Outlined.StarBorder,
                    tint = MaterialTheme.colorScheme.tertiary,
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        Image(
            painter = painterResource(id = image),
            contentScale = ContentScale.Crop,
            contentDescription = "Dessert Detail Image",
            modifier = Modifier
                .size(250.dp)
                .shadow(
                    elevation = 1.dp,
                    shape = CircleShape
                )
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold
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
                text = "Details",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            Text(
                text = details,
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
                text = "Ingredients",
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
private fun DetailScreenPreview() {
    SweetRealmTheme {
        Surface {
            DetailScreen(argumentId = 0, onPopUpClick = {  })
        }
    }
}