package com.example.sweetrealm.presentation.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sweetrealm.presentation.category.components.CategoryCard
import com.example.sweetrealm.presentation.category_detail.categoryList
import com.example.sweetrealm.presentation.home.dessertList
import com.example.sweetrealm.ui.theme.SweetRealmTheme

@Composable
fun CategoryScreen(
    viewAllOnClick: (String) -> Unit,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categoryState = viewModel.categoryState
    val state = rememberLazyListState()

    LazyColumn(
        state = state,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(categoryState.categories, key = { it.id }) {
            CategoryCard(
                name = it.name,
                image = it.image,
                itemList = categoryState.sweets
                    .filter { sweet -> sweet.category == it.name }
                    .take(5),
                onClick = { viewAllOnClick(it.name) })
        }
    }
}

@Preview
@Composable
private fun CategoryScreenPreview() {
    SweetRealmTheme {
        Surface {
            CategoryScreen(
                viewAllOnClick = { }
            )
        }
    }
}