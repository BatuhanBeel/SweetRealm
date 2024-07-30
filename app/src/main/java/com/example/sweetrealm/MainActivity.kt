package com.example.sweetrealm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sweetrealm.presentation.cart.CartScreen
import com.example.sweetrealm.presentation.category.CategoryScreen
import com.example.sweetrealm.ui.theme.SweetRealmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SweetRealmTheme {
                CartScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SweetRealmAppPreview() {
    SweetRealmTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {

            }
        }
    }
}
