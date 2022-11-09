package com.avazpar.designsystem.foundations

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val spaceNoneFoundation = 0.dp
internal val spaceBaseFoundation = 4.dp
internal val spaceExtraSmallFoundation = 8.dp
internal val spaceSmallFoundation = 16.dp
internal val spaceMediumFoundation = 20.dp
internal val spaceLargeFoundation = 24.dp
internal val spaceXLargeFoundation = 32.dp
internal val spaceXXLargeFoundation = 48.dp

@Immutable
data class Spacing(
    val spaceNone: Dp = spaceNoneFoundation,
    val spaceBase: Dp = spaceBaseFoundation,
    val spaceXSmall: Dp = spaceExtraSmallFoundation,
    val spaceSmall: Dp = spaceSmallFoundation,
    val spaceMedium: Dp = spaceMediumFoundation,
    val spaceLarge: Dp = spaceLargeFoundation,
    val spaceXLarge: Dp = spaceXLargeFoundation,
    val spaceXXLarge: Dp = spaceXXLargeFoundation
)

val LocalFarosSpacing = staticCompositionLocalOf { Spacing() }