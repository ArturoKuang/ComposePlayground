package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CourseHeader(
                        imageUrl = "https://media.istockphoto.com/id/991883866/photo/stylish-young-man-in-yellow-hoodie-and-white-pants-sitting-on-chair-and-looking-away-on-white.jpg?s=170667a&w=0&k=20&c=nzKdmXK7ce63VoyPIHXpBAaVIBKuqnxph37Z9zJadNY=",
                        imageTitle = "Dimest C.",
                        imageDescription = "Read 240 consecutive pages")

                }
            }
        }
    }
}

@Composable
fun CourseHeader(
    imageUrl: String,
    imageTitle: String,
    imageDescription: String,
    modifier: Modifier = Modifier
) {
    Row() {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .size(80.dp)
                .aspectRatio(1f)
        )
    }

}


//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposePlaygroundTheme {
//
//    }
//}