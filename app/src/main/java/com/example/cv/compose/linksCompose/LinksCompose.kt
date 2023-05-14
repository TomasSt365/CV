package com.example.cv.compose.linksCompose

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

@Composable
fun Email(
    email: String,
    shortName: String = email,
    textInstruction: TextInstructions,
    iconInstruction: IconInstructions? = null
) {
    LinkConstructor(
        link = email,
        linkText = shortName,
        textInstruction = textInstruction,
        linkType = LinkType.EMAIL,
        iconInstruction = iconInstruction
    )
}

@Composable
fun Link(
    uri: String,
    shortName: String = uri,
    textInstruction: TextInstructions,
    iconInstruction: IconInstructions?
) {
    LinkConstructor(
        link = uri,
        linkText = shortName,
        textInstruction = textInstruction,
        linkType = LinkType.URI,
        iconInstruction = iconInstruction
    )
}

@Composable
fun PhoneLink(
    phoneNumber: String,
    shortName: String = phoneNumber,
    textInstruction: TextInstructions,
    iconInstruction: IconInstructions?
) {
    LinkConstructor(
        link = phoneNumber,
        linkText = shortName,
        textInstruction = textInstruction,
        linkType = LinkType.PHONE,
        iconInstruction = iconInstruction
    )
}

@Composable
private fun LinkConstructor(
    link: String,
    linkText: String = link,
    textInstruction: TextInstructions,
    linkType: LinkType,
    iconInstruction: IconInstructions?,
) {

    val onClick = openLink(
        link = link,
        linkType = linkType,
        context = LocalContext.current
    )

    Row {
        if (iconInstruction != null) {
            Icon(
                imageVector = iconInstruction.icon,
                contentDescription = iconInstruction.contentDescription,
                tint = iconInstruction.tint,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 5.dp)
            )
        }

        Text(
            text = linkText,
            color = textInstruction.color,
            fontSize = textInstruction.fontSize,
            fontStyle = textInstruction.fontStyle,
            fontWeight = textInstruction.fontWeight,
            fontFamily = textInstruction.fontFamily,
            letterSpacing = textInstruction.letterSpacing,
            textDecoration = textInstruction.textDecoration,
            textAlign = textInstruction.textAlign,
            lineHeight = textInstruction.lineHeight,
            overflow = textInstruction.overflow,
            softWrap = textInstruction.softWrap,
            maxLines = textInstruction.maxLines,
            onTextLayout = textInstruction.onTextLayout,
            style = textInstruction.style,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

private fun openLink(link: String, linkType: LinkType, context: Context): () -> Unit {
    val onClick = {
        when (linkType) {
            LinkType.EMAIL -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$link")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(link))
                }
                startIntentWithPermission(
                    intent = intent,
                    context = context,
                    permission = Manifest.permission.INTERNET
                )
            }

            LinkType.PHONE -> {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data =  Uri.parse("tel:$link")
                }

                startIntentWithPermission(
                    intent = intent,
                    context = context,
                    permission = Manifest.permission.READ_CONTACTS
                )

            }

            LinkType.URI -> {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(link)
                }
                startIntentWithPermission(
                    intent = intent,
                    context = context,
                    permission = Manifest.permission.INTERNET
                )
            }
        }
    }

    return onClick
}

private fun startIntentWithPermission(
    intent: Intent,
    context: Context,
    permission: String,
) {
    if (!isPermissionGrated(permission, context)) {
        ActivityCompat.requestPermissions(
            context as Activity,
            arrayOf(permission),
            1
        )
    } else {
        context.startActivity(intent)
    }
}

private fun isPermissionGrated(permission: String, context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}


@Preview
@Composable
fun Preview() {
    MaterialTheme {
        Email(
            "example.com",
            textInstruction = TextInstructions(),
            iconInstruction = IconInstructions(icon = Icons.Default.Email),
        )
    }
}