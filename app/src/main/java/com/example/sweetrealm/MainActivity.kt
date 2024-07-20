package com.example.sweetrealm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sweetrealm.ui.theme.SweetRealmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SweetRealmTheme {
                Column {
                    AsyncImage(
                        modifier = Modifier.size(200.dp,200.dp),
                        model = "https://images.unsplash.com/photo-1550710901-459a4a16d4a8?ixlib=rb-4.0.3\\u0026q=80\\u0026fm=jpg\\u0026crop=entropy\\u0026cs=tinysrgb\\u0026w=1080\\u0026fit=max",
                        contentDescription = null)
                    Text(text = "deneme")
                }

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
