package com.example.banking_app.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency (
    val open:Double,
    val close:Double,
    val icon:ImageVector,
    val name:String
)