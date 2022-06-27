package com.example.twittermirror.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.time.LocalDate

data class Tweet(
    val user: User,
    val date: LocalDate,
    val message: String,
    @DrawableRes val picture: List<Int> = emptyList(),
    val replies: Int = 0,
    var retweets: Int = 0,
    val initialRetweeted: Boolean = false,
    var likes: Int = 0,
    val initialLiked: Boolean = false,
) {

    var liked by mutableStateOf(initialLiked)
    var retweeted by mutableStateOf(initialRetweeted)
}