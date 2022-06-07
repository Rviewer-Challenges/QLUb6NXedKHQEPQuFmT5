package com.example.twittermirror.viewmodel

import androidx.lifecycle.ViewModel
import com.example.twittermirror.model.SampleRepositoryData

class MainViewModel  : ViewModel(){

    val users = SampleRepositoryData.users
    val tweets = SampleRepositoryData.tweets

}