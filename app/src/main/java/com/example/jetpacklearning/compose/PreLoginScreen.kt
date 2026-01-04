package com.example.jetpacklearning.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onForgotClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    Column {
        Button(onClick = onLoginSuccess) {
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
fun ChangeEmailScreen(
    onDone: () -> Unit,
) {
    Column {
        Button(onClick = onDone) {
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
