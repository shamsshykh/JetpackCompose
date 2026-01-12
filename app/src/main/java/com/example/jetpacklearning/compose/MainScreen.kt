package com.example.jetpacklearning.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen(
    onProfileClick: () -> Unit,
    onDetailsClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onProfileClick) {
            Text("Go to Profile")
        }

        TextButton(onClick = { onDetailsClick("123") }) {
            Text("Go to Details")
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun HomeContentPreview() {

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


@Composable
fun CardScreen(onDetailsClick: (String) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text("Card")
        TextButton(onClick = { onDetailsClick.invoke("3545345345") }) {
            Text("onDetailsClick")
        }
    }
}

@Composable
fun NotificationsScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text("Notification")
    }
}