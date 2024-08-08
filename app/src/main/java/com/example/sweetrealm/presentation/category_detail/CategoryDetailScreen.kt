package com.example.sweetrealm.presentation.category_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetrealm.R
import com.example.sweetrealm.domain.model.SweetCategory
import com.example.sweetrealm.presentation.category_detail.components.CategoryDetailCard
import com.example.sweetrealm.ui.theme.SweetRealmTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(
    navArgument: String,
    onItemClick: (Int) -> Unit,
    onPopUpClick: () -> Unit,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = navArgument) {
        viewModel.getSweets(navArgument)
    }

    val categoryDetailState = viewModel.categoryDetailState
    val state = rememberLazyGridState()

    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){

            IconButton(onClick = { onPopUpClick() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )
            }
            OutlinedTextField(
                value = viewModel.query,
                onValueChange = { viewModel.onEvent(CategoryDetailEvent.OnSearchQuery(it)) },
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
                },
                placeholder = {
                    Text(text = "Search")
                },
                prefix = {
                    Text(text = "Search")
                },
                maxLines = 1
            )

            SearchBar(
                query = "",
                onQueryChange = {},
                onSearch = {},
                active = false,
                onActiveChange = {},
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
                        Text(text = "Search")
                    }
                },
                content = {}
            )
        }
        LazyVerticalGrid(
            state = state,
            columns = GridCells.FixedSize(158.dp),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            items(categoryDetailState.sweets){
                CategoryDetailCard(id = it.id, name = it.name, image = it.image, onClick = onItemClick, modifier = Modifier.background(MaterialTheme.colorScheme.surface))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryDetailScreenPreview() {
    SweetRealmTheme {
        Surface {
            CategoryDetailScreen(navArgument = "", onItemClick = {  }, onPopUpClick = {  })
        }
    }
}

val categoryList = listOf(
    SweetCategory(id = 0, name = "Ice Cream", image = R.drawable.ice_cream),
    SweetCategory(id = 1, name = "Ice Cream", image = R.drawable.ice_cream),
    SweetCategory(id = 2, name = "Ice Cream", image = R.drawable.ice_cream),
    SweetCategory(id = 3, name = "Ice Cream", image = R.drawable.ice_cream),
    SweetCategory(id = 4, name = "Cake", image = R.drawable.cake),
    SweetCategory(id = 5, name = "Cake", image = R.drawable.cake),
    SweetCategory(id = 6, name = "Cake", image = R.drawable.cake),
    SweetCategory(id = 7, name = "Cake", image = R.drawable.cake)
)
