package com.example.twittermirror.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.twittermirror.model.SampleRepositoryData
import com.example.twittermirror.model.Tweet
import com.example.twittermirror.ui.theme.TwitterMirrorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterMirrorTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        items(SampleRepositoryData.tweets) { tweet -> TweetMsg(tweet) }
    }

}

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
                if (tweet.picture != null) {
                    Image(
                        painter = painterResource(tweet.picture),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                BottomIconBar(tweet)
            }


        }

        Divider(color = Color.Gray, thickness = 0.5.dp)
    }

}

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
        TweetIcon(IconType.Retweet, onRetweet, number = tweet.retweets)
        TweetIcon(IconType.Like, onLike, number = tweet.likes)
        TweetIcon(IconType.Share, onShare)
    }
}

@Composable
fun TweetIcon(
    iconType: IconType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    number: Int = 0
) {

    IconButton(onClick, modifier.width(70.dp)) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                iconType.icon,
                contentDescription = iconType.contentDescription,
                Modifier
                    .align(CenterVertically)
                    .padding(end = 6.dp)
            )
            if (number > 0) {
                Text(
                    text = number.toString(),
                    Modifier
                        .align(CenterVertically)
                        .width(200.dp)
                )
            }

        }

    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    TwitterMirrorTheme {
        HomeScreen()
    }
}

