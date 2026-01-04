package com.example.jetpacklearning.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onProfileClick: () -> Unit,
    onDetailsClick: (userid : String) -> Unit,
) {
    Column {
        Button(onClick = onProfileClick) {
            Text("onProfileClick")
        }
        TextButton(onClick = { onDetailsClick.invoke("1111") }) {
            Text("onDetailsClick")
        }
    }
}

@Composable
fun ProfileScreen(
    onLogout: () -> Unit
) {
    Column {
        Button(onClick = onLogout) {
            Text("onLogout")
        }
    }
}

@Composable
fun DetailsScreen(userId: Any) {
    Column {
            Text("$userId")
    }
}