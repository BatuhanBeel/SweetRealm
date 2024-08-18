package com.example.sweetrealm.presentation.detail

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.sweetrealm.R
import com.example.sweetrealm.presentation.detail.components.DetailBody
import com.example.sweetrealm.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    navArgument: Int,
    onPopUpClick: () -> Unit,
    context: Context = LocalContext.current,
    viewModel: DetailViewModel = hiltViewModel()
) {

    val sweet by viewModel.sweet.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = navArgument) {
        viewModel.loadSweet(navArgument)
    }
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is UiEvent.ShowSnackbar -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
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
                    text = stringResource(R.string.qty),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(0.20f)
                )
                IconButton(onClick = { viewModel.onEvent(DetailEvent.OnDecreaseClick) }) {
                    Icon(
                        imageVector = Icons.Filled.Remove,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = stringResource(R.string.decrease_quantity),
                        modifier = Modifier
                            .weight(0.1f)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
                Text(
                    text = viewModel.quantity.toString(), style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
                IconButton(onClick = { viewModel.onEvent(DetailEvent.OnIncreaseClick) }) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = stringResource(R.string.increase_quantity),
                        modifier = Modifier
                            .weight(0.1f)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    )
                }
                Button(
                    enabled = viewModel.quantity > 0,
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors()
                        .copy(containerColor = MaterialTheme.colorScheme.primary),
                    onClick = { viewModel.onEvent(DetailEvent.AddToCardClick) },
                    modifier = Modifier
                        .weight(0.6f)
                ) {
                    Text(
                        text = stringResource(R.string.add_to_card),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    ) { innerPadding ->
        sweet?.let {
            DetailBody(
                name = it.name,
                imageUrl = it.imageUrl,
                price = it.price,
                isFavorite = it.isFavorite,
                country = it.country,
                ingredients = it.ingredients,
                onPopUpClicked = onPopUpClick,
                onFavoriteClicked = { viewModel.onEvent(DetailEvent.OnFavoriteClick) },
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}