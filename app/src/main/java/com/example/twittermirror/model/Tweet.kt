package com.example.twittermirror.model

import androidx.annotation.DrawableRes
import java.time.LocalDate

data class Tweet(val user: User, val date: LocalDate, val message: String, @DrawableRes val picture: Int? = null, val replies: Int = 0, val retweets: Int = 0, var likes: Int = 0) {
}