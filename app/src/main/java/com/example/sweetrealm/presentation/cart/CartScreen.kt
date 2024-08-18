package com.example.sweetrealm.presentation.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetrealm.R
import com.example.sweetrealm.presentation.cart.components.CartItem
import com.example.sweetrealm.presentation.cart.components.formatFloat
import com.example.sweetrealm.presentation.components.SweetRealmDialog

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    val cartState = viewModel.cartState
    val totalPrice by remember(cartState.shoppingList) {
        mutableFloatStateOf(
            cartState.shoppingList
                .filter { it.isSelected }
                .map { it.price * it.count }
                .sum()
        )
    }
    val isAlertDialogActive = viewModel.isAlertDialogOpen

    val state = rememberLazyListState()
    Scaffold(
        topBar = {
            Column {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(48.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.shopping_cart),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.align(Alignment.Center)
                    )
                    IconButton(
                        onClick = { viewModel.isAlertDialogOpen = true },
                        modifier = Modifier.align(Alignment.CenterEnd),
                        enabled = cartState.shoppingList.isNotEmpty()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DeleteForever,
                            tint = if (cartState.shoppingList.isNotEmpty())
                                MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface.copy(
                                alpha = 0.12f
                            ),
                            contentDescription = "Delete All Item"
                        )
                    }
                }
                HorizontalDivider(color = MaterialTheme.colorScheme.outline)
            }
        },
        bottomBar = {
            Column {
                HorizontalDivider(thickness = 2.dp)
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                        .height(52.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.total_price),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                    Text(
                        text = "$ ${formatFloat(totalPrice)}",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.align(Alignment.BottomStart)
                    )
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        enabled = cartState.shoppingList.isNotEmpty(),
                        shape = RoundedCornerShape(8.dp),
                        onClick = { viewModel.onEvent(CartEvent.OnGoToCheckoutClick) },
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .align(Alignment.CenterEnd)
                    ) {
                        Text(
                            text = stringResource(R.string.go_to_checkout),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            state = state,
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
            items(cartState.shoppingList, key = { it.id }) {
                CartItem(
                    name = it.name,
                    imageUrl = it.imageUrl,
                    price = it.price,
                    count = it.count,
                    isChecked = it.isSelected,
                    onCheckedClick = { viewModel.onEvent(CartEvent.OnCheckboxClick(it)) },
                    onDecreaseClicked = {
                        viewModel.onEvent(CartEvent.OnDecreaseClick(it)) },
                    onIncreaseClicked = { viewModel.onEvent(CartEvent.OnIncreaseClick(it)) })
            }
        }
        if (isAlertDialogActive) {
            SweetRealmDialog(
                title = "Delete All",
                text = "Do you want to delete all items?",
                icon = Icons.Filled.Clear,
                contentDescription = "Delete All",
                onDismissRequest = { viewModel.isAlertDialogOpen = false },
                onConfirmation = {
                    viewModel.onEvent(CartEvent.OnDeleteAllClick)
                }
            )
        }

        if (cartState.isLoading) {
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        } else if (cartState.shoppingList.isEmpty()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.your_shopping_cart_is_empty),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}