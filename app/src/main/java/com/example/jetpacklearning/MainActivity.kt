package com.example.jetpacklearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.jetpacklearning.navigation.AppNavGraph
import com.example.jetpacklearning.ui.theme.JetPackLearningTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackLearningTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                ) {  padding ->
                    AppNavGraph(
                        navController = navController,
                        isLoggedIn = false,
                        modifier = Modifier.padding(padding)
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun GreetingPreview() {
    JetPackLearningTheme {
        //AppNavGraph()
        // Greeting("Shams")
        // Portfolio()
    }
}

@Composable
fun Portfolio() {

    val isVisible = remember {  mutableStateOf(false) }

    Surface(shadowElevation = 10.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(Modifier.size(70.dp))
            Spacer(modifier = Modifier.size(10.dp))
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            Spacer(modifier = Modifier.size(10.dp))
            TextCompose("Shams")
            Button(onClick = {
                isVisible.value = !isVisible.value
            })
            {
                Text("Buttom")
            }
            if (isVisible.value) {
                Spacer(modifier = Modifier.size(10.dp))
                LazyColumn {
                    items(5) {
                        ItemRow()
                        Spacer(modifier = Modifier.size(5.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemRow(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(Modifier.size(20.dp))
        Spacer(modifier = Modifier.size(5.dp))
        TextCompose("Shams")
    }
}


@Composable
fun Greeting(name: String) {
    Column(verticalArrangement = Arrangement.Center) {
        TextCompose(name)
        Button()
        Image(Modifier.fillMaxWidth())
        TextFiled()
        BoxView()
    }

}
@Composable
private fun TextCompose(name: String){
    Text(
        text = "Hello $name!",
    )
}
@Composable
private fun Button(){
    Button(enabled = true, onClick = {

    }) {
        Text("Buttom")
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            modifier = Modifier.size(height = 20.dp, width = 25.dp),
            contentScale = ContentScale.Fit
        )
    }
}
@Composable
private fun TextFiled(){
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        }
    )
}
@Composable
private fun Image(modifier: Modifier){
    Image(
        painter = painterResource(R.drawable.baseline_insert_emoticon_24),
        contentDescription = "Image",
        colorFilter = ColorFilter.tint(Color.Red),
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Composable
private fun BoxView(){
    Box(modifier = Modifier.clip(CircleShape)){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Image",
            colorFilter = ColorFilter.tint(Color.Green),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Image",
            colorFilter = ColorFilter.tint(Color.Red),
            contentScale = ContentScale.Crop
        )

    }
}

