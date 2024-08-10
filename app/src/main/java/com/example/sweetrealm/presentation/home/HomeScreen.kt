package com.example.sweetrealm.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetrealm.R
import com.example.sweetrealm.domain.model.Sweet
import com.example.sweetrealm.presentation.home.components.SweetCollection
import com.example.sweetrealm.presentation.home.components.SweetRealmCard

@Composable
fun HomeScreen(
    itemOnClick: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(vertical = 32.dp)
            .fillMaxSize()
    ) {
        YourFavoritesBody(itemList = state.favoritesList, itemOnClick = itemOnClick, itemOnClickFavorite = { viewModel.itemClickedFavorite(it) })
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.outlineVariant
        )
        MostPreferredBody(itemList = dessertList, itemOnClick = itemOnClick)
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.outlineVariant
        )
        NewlyAddedBody(itemList = state.newlyAddedList, itemOnClick = { itemOnClick(it) }, itemOnClickFavorite = { viewModel.itemClickedFavorite(it) })
    }
}

@Composable
fun YourFavoritesBody(
    itemList: List<Sweet>,
    itemOnClick:(Int) -> Unit,
    itemOnClickFavorite: (Int) -> Unit
) {
    val yourFavoritesState = rememberLazyListState()
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            text = "Your Favorites",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyRow(
            state = yourFavoritesState,
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            items(itemList, key = { it.id }){
                SweetRealmCard(
                    id = it.id,
                    name = it.name,
                    image = it.image,
                    price = it.price,
                    isNew = it.isNew,
                    isFavorite = it.isFavorite,
                    onClick = itemOnClick,
                    onClickFavorite = itemOnClickFavorite
                )
            }
        }
    }
}

@Composable
fun MostPreferredBody(
    itemList: List<Sweet>,
    itemOnClick:(Int) -> Unit
) {
    val mostPreferredState = rememberLazyListState()
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            text = "Most Preferred",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyRow(
            state = mostPreferredState,
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            items(itemList, key = { it.id }){
                SweetCollection(id = it.id, name = it.name, image = it.image, onClick = itemOnClick)
            }
        }
    }
}

@Composable
fun NewlyAddedBody(
    itemList: List<Sweet>,
    itemOnClick:(Int) -> Unit,
    itemOnClickFavorite: (Int) -> Unit
) {
    val newlyAddedState = rememberLazyListState()
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            text = "Newly Added",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineMedium
        )
        LazyRow(
            state = newlyAddedState,
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()

        ) {
            items(itemList, key = { it.id }){
                SweetRealmCard(
                    id = it.id,
                    name = it.name,
                    image = it.image,
                    price = it.price,
                    isNew = it.isNew,
                    isFavorite = it.isFavorite,
                    onClick = itemOnClick,
                    onClickFavorite = itemOnClickFavorite
                )
            }
        }
    }
}

val dessertList = listOf(
    Sweet(0,"Ice Cream", R.drawable.ice_cream, 10f, "IceCream" ,"", ""),
    Sweet(1,"Ice Cream", R.drawable.ice_cream, 10f, "IceCream","", "")
)