package com.saehyun.presentation.util

import androidx.compose.ui.graphics.Color
import com.saehyun.common_android.ColorType

fun ColorType.toSMonkeyColor(): Color =
    when (this) {
        ColorType.SeaGreen -> SeaGreen
        ColorType.AppleGreen -> AppleGreen
        ColorType.YellowGreen -> YellowGreen
        ColorType.LightYellow -> LightYellow
        ColorType.LightOrange -> LightOrange
        ColorType.LightRed -> LightRed
        ColorType.Cerise -> Cerise
        ColorType.Magenta -> Magenta
        ColorType.IndianRed -> IndianRed
        ColorType.LightCoral -> LightCoral
        ColorType.Bisqure -> Bisqure
        ColorType.Blossom -> Blossom
        ColorType.Pink -> Pink
        ColorType.DarkPink -> DarkPink
        ColorType.Plum -> Plum
        ColorType.SkyBlue -> SkyBlue
        ColorType.LightAqua -> LightAqua
        ColorType.LightBlue -> LightBlue
        ColorType.Violet -> Violet
        ColorType.Orchid -> Orchid
        ColorType.Purple -> Purple
        ColorType.Navy -> Navy
    }

val SeaGreen = Color(0xFFBA675)
val AppleGreen = Color(0xFFBC96C)
val YellowGreen = Color(0xFFAFE85E)
val LightYellow = Color(0xFFFCEF8D)
val LightOrange = Color(0xFFFFB879)
val LightRed = Color(0xFFEA6262)
val Cerise = Color(0xFFCC425E)
val Magenta = Color(0xFFA32858)
val IndianRed = Color(0xFFA6555F)
val LightCoral = Color(0xFFC97373)
val Bisqure = Color(0xFFF2AE99)
val Blossom = Color(0xFFFFC3F2)
val Pink = Color(0xFFEE8FCB)
val DarkPink = Color(0xFFD46EB3)
val Plum = Color(0xFF873E84)
val SkyBlue = Color(0xFFAEE2FF)
val LightAqua = Color(0xFFDB7FF)
val LightBlue = Color(0xFFD80FA)
val Violet = Color(0xFFC)
val Orchid = Color(0xFFDC4)
val Purple = Color(0xFFD2DA0)
val Navy = Color(0xFFC)