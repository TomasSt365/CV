package com.example.cv

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cv.compose.Email
import com.example.cv.compose.Link
import com.example.cv.compose.PhoneLink
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
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x5900BCD4))
    ) {

        FirstInfo(
            painterImage = painterResource(R.drawable.author_foto),
            name = stringResource(R.string.author_name),
            title = stringResource(R.string.author_title),
            modifier = Modifier
                .align(Center)
                .padding(bottom = 70.dp)
        )

        ContactInfo(
            fontSize = 24.sp,
            mobilePhone = stringResource(R.string.phone_number),
            email = stringResource(R.string.email),
            linkedIn = stringResource(R.string.linkedIn),
            gitHub = stringResource(R.string.git_hub),
            modifier = Modifier
                .padding(bottom = 70.dp)
                .align(Alignment.BottomCenter)
        )


    }

}

@Composable
fun FirstInfo(
    painterImage: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterImage,
                contentDescription = null
            )

            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
            )

            Text(
                text = title,
                color = Color(0xFF0A490D),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp
            )
        }
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun ContactInfo(
    mobilePhone: String,
    fontSize: TextUnit,
    email: String,
    linkedIn: String? = null,
    gitHub: String? = null,
    modifier: Modifier = Modifier
) {
    val iconColor = Color.Blue

    Box(modifier = modifier) {
        Column {

            PhoneLink(
                phoneNumber = mobilePhone,
                icon = Icons.Default.Phone,
                iconColor = iconColor,
                fontSize = fontSize
            )

            Email(
                email = email,
                fontSize = fontSize,
                icon = Icons.Default.Email,
                iconColor = iconColor
            )

            if (linkedIn != null) {
                Link(
                    uri = linkedIn,
                    shortName = "LinkedIn",
                    fontSize = fontSize,
                    icon = Icons.Default.AccountCircle,
                    iconColor = iconColor
                )
            }

            if (gitHub != null) {
                Link(
                    uri = gitHub,
                    shortName = "GitHub",
                    fontSize = fontSize,
                    icon = Icons.Default.AccountCircle,
                    iconColor = iconColor
                )
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun CVPreview() {
    CVTheme {
        MainScreen()
    }

}