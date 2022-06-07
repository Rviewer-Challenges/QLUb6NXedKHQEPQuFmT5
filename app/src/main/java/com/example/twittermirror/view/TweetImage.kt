package com.example.twittermirror.view


import android.os.Build.VERSION.SDK_INT
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size


@Composable
fun ImageGroup(@DrawableRes imgList: List<Int>, modifier: Modifier = Modifier) {
    if (imgList.size == 1) {
        GifImage(
            imgList[0],
            modifier
                .clip(RoundedCornerShape(10.dp))
        )
    } else if (imgList.size > 1) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.clip(
                RoundedCornerShape(10.dp)
            )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 4.dp)
            ) {
                GifImage(imgList[0])
                if (imgList.size > 3) {
                    GifImage(imgList[2], Modifier.padding(top = 8.dp))
                }
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                GifImage(imgList[1])
                if (imgList.size == 3) {
                    GifImage(imgList[2],Modifier.padding(top = 8.dp))
                } else if (imgList.size > 3) {
                    GifImage(imgList[3],Modifier.padding(top = 8.dp))
                }

            }
        }

    }
}


@Composable
fun GifImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = imageRes).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = modifier
    )
}