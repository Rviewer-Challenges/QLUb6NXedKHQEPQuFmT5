package com.example.twittermirror.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.twittermirror.ui.theme.TwitterMirrorTheme
import com.example.twittermirror.viewmodel.MainViewModel


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
    val viewModel: MainViewModel = viewModel()
    LazyColumn(modifier = modifier) {
        items(viewModel.tweets) { tweet ->
            TweetMsg(
                tweet,
                onLike = { viewModel.onLike(tweet) },
                onRetweet = { viewModel.onRetweet(tweet) })
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

