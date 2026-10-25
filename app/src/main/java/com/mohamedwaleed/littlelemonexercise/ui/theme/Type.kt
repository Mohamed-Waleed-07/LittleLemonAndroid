package com.mohamedwaleed.littlelemonexercise.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Typography configurations matching screen hierarchy
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = LittleLemonYellow
    ),

    // "Chicago" Subtitle[cite: 1]
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = LittleLemonCloud
    ),

    // Hero Section Description Paragraph[cite: 1]
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = LittleLemonCloud
    ),

    // "Order Take Away" Button Label[cite: 1]
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = LittleLemonCharcoal
    ),

    // "Weekly Special" & Dish Item Titles ("Greek Salad", "Lemon Desert", etc.)[cite: 1]
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = LittleLemonCharcoal
    ),

    // Dish Descriptions[cite: 1]
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = LittleLemonGreen
    ),

    // Price Labels ("$12.99", "$8.99", etc.)[cite: 1]
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = LittleLemonGreen
    )
)