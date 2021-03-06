package com.example.twittermirror.model

import com.example.twittermirror.R
import java.time.LocalDate

object SampleRepositoryData {

    val users = listOf(
        User(
            name = "Melon Mask",
            twitterId = "@ElonTheMelon",
            profilePicture = R.drawable.elon_prof,
            bio = "Put the Melon back in Elon"
        ),
        User(
            name = "Google Girl",
            twitterId = "@googlegirl",
            profilePicture = R.drawable.prof_pic1,
            bio = "I work in google"
        ),
        User(
            name = "Billy Puertas",
            twitterId = "@IAmBillGeits",
            profilePicture = R.drawable.prof_pic2,
            bio = "Conspiring against the world since 1960"
        ),
    )

    val tweets = listOf(
        Tweet(users[0], LocalDate.of(2022, 4, 30), "Going out for shopping"),
        Tweet(
            users[0],
            LocalDate.of(2022, 5, 3),
            "I am out of cash to buy Microsoft, I might sell some companies"
        ),
        Tweet(users[1], LocalDate.of(2022, 5, 2), "Making a new codelab"),
        Tweet(
            users[1],
            LocalDate.of(2022, 5, 5),
            "Who is this Moure guy? I love his youtube channel."
        ),
        Tweet(
            users[2],
            LocalDate.of(2022, 5, 14),
            "I cant find the gas tank on my Tesla.",
            listOf(R.drawable.tesla_gas),
            3,
            18,
            likes= 588,
            initialLiked = true

        ),
        Tweet(
            users[0],
            LocalDate.of(2022, 5, 16),
            "My kids, C3PO and R2D2 are having fun",
            listOf(R.drawable.tesla_kids),
            3, 3, true,57

        ),
        Tweet(
            users[0],
            LocalDate.of(2022, 5, 17),
            "What car do you like the most",
            listOf(R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4)
        ),
        Tweet(
            users[0],
            LocalDate.of(2022, 5, 17),
            "Only three in this round",
            listOf(R.drawable.car1,R.drawable.car2,R.drawable.car3)
        ),
        Tweet(
            users[0],
            LocalDate.of(2022, 5, 17),
            "These are the two finalists",
            listOf(R.drawable.car1,R.drawable.car2)
        ),
    )

}