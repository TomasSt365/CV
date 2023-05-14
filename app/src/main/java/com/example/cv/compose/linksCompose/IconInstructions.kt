package com.example.cv.compose.linksCompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class IconInstructions(
    var icon: ImageVector = Icons.Default.Share,
    var contentDescription: String? = null,
    var tint: Color = Color.Black,
    var modifier: Modifier = Modifier
)
