package com.example.cv

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cv.compose.linksCompose.Email
import com.example.cv.compose.linksCompose.Link
import com.example.cv.compose.linksCompose.PhoneLink
import com.example.cv.ui.theme.CVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x5900BCD4)),
        verticalArrangement = Arrangement.Center,
    ) {

        FirstInfo(
            painterImage = painterResource(R.drawable.author_foto),
            name = stringResource(R.string.author_name),
            title = stringResource(R.string.author_title),
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(bottom = 70.dp, top = 150.dp)
        )

        ContactInfo(
            mobilePhone = stringResource(R.string.phone_number),
            email = stringResource(R.string.email),
            linkedIn = stringResource(R.string.linkedIn),
            gitHub = stringResource(R.string.git_hub),
            modifier = Modifier
                .padding(bottom = 0.dp)
                .align(CenterHorizontally).align(Alignment.End)
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
            horizontalAlignment = CenterHorizontally
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
    email: String,
    linkedIn: String? = null,
    gitHub: String? = null,
    modifier: Modifier = Modifier
) {
    val instructionsForLinks = InstructionsForLinks(LocalContext.current)

    Box(modifier = modifier) {
        Column {

            PhoneLink(
                phoneNumber = mobilePhone,
                textInstruction = instructionsForLinks.textForLinks,
                iconInstruction = instructionsForLinks.iconForPhone
            )

            Email(
                email = email,
                textInstruction = instructionsForLinks.textForLinks,
                iconInstruction = instructionsForLinks.iconForEmail
            )

            if (linkedIn != null) {
                Link(
                    uri = linkedIn,
                    shortName = stringResource(R.string.linkedin),
                    textInstruction = instructionsForLinks.textForLinks,
                    iconInstruction = instructionsForLinks.iconForLinkedIn
                )
            }

            if (gitHub != null) {
                Link(
                    uri = gitHub,
                    shortName = stringResource(R.string.github),
                    textInstruction = instructionsForLinks.textForLinks,
                    iconInstruction = instructionsForLinks.iconForGitHub
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