package com.example.cv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cv.ui.theme.CVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
}

@Composable
fun FirstInfo(
    painterImage: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterImage,
            contentDescription = null
        )

        Text(
            text = name,
            fontSize = 32.sp,
            modifier = modifier,
        )

        Text(
            text = title,
            fontFamily = FontFamily.Cursive,
            fontSize = 22.sp
        )
    }
}

@Composable
fun ContactInfo(
    mobilePhone: String,
    email: String,
    linkedIn: String,
    gitHub: String
) {
    Column() {
        Text(text = mobilePhone)

        Text(text = email)

        Text(text = "Click to open a link")

        Text(text = linkedIn)

        Text(text = gitHub)

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CVTheme {
        MainScreen()
        ContactInfo(
            mobilePhone = "+48-733-696-872",
            email = "lapink365@gmail.com",
            linkedIn = "https://www.linkedin.com/in/nikolas-lapin-35a877275",
            gitHub = "https://github.com/TomasSt365"
        )
    }

}