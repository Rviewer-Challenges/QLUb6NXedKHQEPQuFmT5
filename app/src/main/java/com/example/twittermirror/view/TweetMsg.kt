package com.example.twittermirror.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.twittermirror.model.Tweet

@Composable
fun TweetMsg(tweet: Tweet, modifier: Modifier = Modifier) {
    Surface() {
        Row(
            modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(tweet.user.profilePicture),
                contentDescription = "Contact profile picture",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape),
                alignment = Alignment.TopStart
            )


            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = modifier.fillMaxWidth()) {
                Row {
                    Text(
                        text = tweet.user.name,
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = tweet.user.twitterId,
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = tweet.message, style = MaterialTheme.typography.bodyMedium)
                if (tweet.picture.isNotEmpty()) {
                    ImageGroup(tweet.picture, Modifier.padding(top = 8.dp))
                }
                BottomIconBar(tweet)
            }


        }

        Divider(color = Color.Gray, thickness = 0.5.dp)
    }

}