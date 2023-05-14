package com.example.cv

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.cv.compose.linksCompose.IconInstructions
import com.example.cv.compose.linksCompose.TextInstructions

data class InstructionsForLinks(
    val context: Context
) {

    //Icons instructions
    private val iconColor: Color = Color.Blue

    val iconForPhone: IconInstructions = IconInstructions(
        icon = Icons.Default.Phone,
        tint = iconColor,
        contentDescription = context.getString(R.string.content_description_for_phone)
    )

    val iconForEmail: IconInstructions = IconInstructions(
        icon = Icons.Default.Email,
        tint = iconColor,
        contentDescription = context.getString(R.string.email_content_description)
    )

    val iconForLinkedIn: IconInstructions = IconInstructions(
        icon = Icons.Default.Share,
        tint = iconColor,
        contentDescription = context.getString(R.string.linkedid_content_description)
    )

    val iconForGitHub: IconInstructions = IconInstructions(
        icon = Icons.Default.Share,
        tint = iconColor,
        contentDescription = context.getString(R.string.github_content_description)
    )

    //TextInstructions
    val textForLinks: TextInstructions = TextInstructions(
        fontSize = 24.sp,
    )

}
