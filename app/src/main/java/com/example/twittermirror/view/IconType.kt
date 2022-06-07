package com.example.twittermirror.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class IconType(val icon: ImageVector, val contentDescription: String? = null, val color: Color? = null) {

    Reply(Icons.Filled.ChatBubble, "Reply"),
    Retweet(Icons.Filled.Autorenew, "Retweet", Color.Green),
    Like(Icons.Filled.FavoriteBorder, "Like", Color.Red),
    Share(Icons.Filled.Share, "Share")

}