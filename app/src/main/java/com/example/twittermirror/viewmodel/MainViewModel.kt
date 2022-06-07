package com.example.twittermirror.viewmodel

import androidx.lifecycle.ViewModel
import com.example.twittermirror.model.SampleRepositoryData

class MainViewModel (private val dataRepository: SampleRepositoryData) : ViewModel(){

    val users = dataRepository.users
    val tweets = dataRepository.tweets

}