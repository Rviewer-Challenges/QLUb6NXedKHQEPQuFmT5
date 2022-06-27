package com.example.twittermirror.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.twittermirror.model.SampleRepositoryData
import com.example.twittermirror.model.Tweet

class MainViewModel  : ViewModel(){

    val users = SampleRepositoryData.users

    private val _tweets = SampleRepositoryData.tweets.toMutableStateList()
    val tweets : List<Tweet>
        get() = _tweets



    fun onLike(tweet : Tweet) {
        tweet.liked = !tweet.liked
        if (tweet.liked) tweet.likes++ else tweet.likes--
    }

    fun onRetweet(tweet : Tweet) {
        tweet.retweeted = !tweet.retweeted
        if (tweet.retweeted) tweet.retweets++ else tweet.retweets--
    }
}