package com.example.cv.compose.linksCompose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

data class TextInstructions(
    var color: Color = Color.Unspecified,
    var fontSize: TextUnit = TextUnit.Unspecified,
    var fontStyle: FontStyle? = null,
    var fontWeight: FontWeight? = null,
    var fontFamily: FontFamily? = null,
    var letterSpacing: TextUnit = TextUnit.Unspecified,
    var textDecoration: TextDecoration? = null,
    var textAlign: TextAlign? = null,
    var lineHeight: TextUnit = TextUnit.Unspecified,
    var overflow: TextOverflow = TextOverflow.Clip,
    var softWrap: Boolean = true,
    var maxLines: Int = Int.MAX_VALUE,
    var onTextLayout: (TextLayoutResult) -> Unit = {},
    var style: TextStyle = TextStyle.Default
)
