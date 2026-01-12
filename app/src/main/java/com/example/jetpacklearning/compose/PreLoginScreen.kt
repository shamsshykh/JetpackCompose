package com.example.jetpacklearning.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onForgotClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = onLoginSuccess) {
                Text("Login")
            }
            TextButton(onClick = onForgotClick) {
                Text("Forgot Password")
            }
            TextButton(onClick = onRegisterClick) {
                Text("Register")
            }
        }
    }

}



@Composable
fun ForgotPasswordScreen(
    onBack: () -> Unit,
) {
    Column {
        Button(onClick = onBack) {
            Text("onBack")
        }
    }
}
@Composable
fun RegisterScreen(
    onRegisterSuccess: () -> Unit
) {
    Column {
        Button(onClick = onRegisterSuccess) {
            Text("onRegisterSuccess")
        }
    }
}
