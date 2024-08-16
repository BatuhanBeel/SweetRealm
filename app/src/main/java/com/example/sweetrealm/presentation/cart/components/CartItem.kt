package com.example.sweetrealm.presentation.cart.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sweetrealm.R
import com.example.sweetrealm.ui.theme.SweetRealmTheme

val CartItemHeight = 80.dp
val NameWidth = 70.dp

@SuppressLint("UnrememberedMutableState")
@Composable
fun CartItem(
    name: String,
    imageUrl: String,
    price: Float,
    count: Int,
    isChecked: Boolean,
    onCheckedClick: () -> Unit,
    onDecreaseClicked: () -> Unit,
    onIncreaseClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val totalPrice by remember(price,count){
        mutableFloatStateOf(price * count)
    }

    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .height(CartItemHeight)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { onCheckedClick() }
            )
            AsyncImage(
                model = imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = "Dessert Image Cart",
                modifier = Modifier
                    .size(75.dp, 75.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Text(
                text = name,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(NameWidth)
                    .weight(2f)

            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(30.dp)
                    .weight(2f)
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant, CircleShape)
            ) {

                Icon(
                    imageVector = Icons.Filled.Remove,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(id = R.string.decrease_quantity),
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .clickable { onDecreaseClicked() }
                )

                Text(
                    text = "$count",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(20.dp)

                )

                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(id = R.string.increase_quantity),
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .clickable { onIncreaseClicked() }
                )

            }
            Text(
                text = "$ ${formatFloat(totalPrice)}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(2f)
            )
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 2.dp))
    }
}

fun formatFloat(value: Float): String {
    return String.format("%.2f", value)
}

@Preview
@Composable
private fun CartItemPreview() {
    SweetRealmTheme {
        Surface {
            CartItem(
                name = "Cake",
                imageUrl = "",
                price = 10.25f,
                count = 1,
                isChecked = false,
                onCheckedClick = { /*TODO*/ },
                onDecreaseClicked = { /*TODO*/ },
                onIncreaseClicked = { /*TODO*/ })
        }
    }
}