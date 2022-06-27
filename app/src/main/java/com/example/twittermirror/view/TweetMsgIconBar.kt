package com.example.twittermirror.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.twittermirror.model.Tweet

@Composable
fun BottomIconBar(
    tweet: Tweet,
    modifier: Modifier = Modifier,
    onReply: () -> Unit = {},
    onRetweet: () -> Unit = {},
    onLike: () -> Unit = {},
    onShare: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        TweetIcon(IconType.Reply, onReply, number = tweet.replies)
        TweetIcon(IconType.Retweet, onRetweet, number = tweet.retweets, state = tweet.retweeted)
        TweetIcon(IconType.Like, onLike, number = tweet.likes, state = tweet.liked)
        TweetIcon(IconType.Share, onShare)
    }
}

@Composable
fun TweetIcon(
    iconType: IconType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    number: Int = 0,
    state: Boolean = false
) {
    val color = if (state && iconType.color != null) iconType.color else LocalContentColor.current

    // IconButton width is set to a fix value because otherwise the text do not fit
    IconButton(onClick, modifier.width(70.dp)) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                iconType.icon,
                contentDescription = iconType.contentDescription,
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 6.dp),
                tint = color
            )
            if (number > 0) {
                Text(
                    text = number.toString(),
                    Modifier
                        .align(Alignment.CenterVertically)
                        .width(200.dp)
                )
            }

        }

    }
}