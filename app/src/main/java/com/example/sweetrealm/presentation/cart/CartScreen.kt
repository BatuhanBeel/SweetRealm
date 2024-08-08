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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetrealm.presentation.cart.components.CartItem

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    val cartState by viewModel.cartState
    val price by viewModel.price

    val state = rememberLazyListState()
    Scaffold(
        topBar = {
            Column {
                Box(modifier = Modifier
                    .padding(4.dp)
                    .height(48.dp)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = "Shopping Cart",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.align(Alignment.Center)
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DeleteForever,
                            tint = MaterialTheme.colorScheme.primary,
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
                Box(modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .height(52.dp)
                    .fillMaxWidth()) {
                    Text(
                        text = "Total Price",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                    Text(
                        text = "$ $price",
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
                        shape = RoundedCornerShape(8.dp),
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .align(Alignment.CenterEnd)
                    ) {
                        Text(
                            text = "Go To Checkout",
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
        if(!cartState.isLoading){
            LazyColumn(
                state = state,
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .fillMaxSize()
            ) {
                items(cartState.shoppingList){
                    CartItem(
                        name = it.name,
                        imageId = it.image,
                        price = it.price,
                        isChecked = true,
                        onCheckedClick = { viewModel.onEvent(CartEvent.OnCheckboxClick(it)) },
                        onDecreaseClicked = { viewModel.onEvent(CartEvent.OnDecreaseClick(it)) },
                        onIncreaseClicked = { viewModel.onEvent(CartEvent.OnIncreaseClick(it)) })
                }
            }
        }
        else{
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }

        }
    }
}