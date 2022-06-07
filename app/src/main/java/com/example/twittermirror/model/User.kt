package com.example.twittermirror.model

import androidx.annotation.DrawableRes

data class User (val name: String, val twitterId: String, @DrawableRes val profilePicture: Int, val bio: String = "")  {
}