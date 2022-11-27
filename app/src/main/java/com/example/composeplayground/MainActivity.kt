package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
                        imageDescription = "Read 240 consecutive pages"
                    )
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
    Row(modifier = modifier) {
        CourseHeaderAvatar(imageUrl = imageUrl, modifier = modifier)
    }
}

@Composable
fun CourseHeaderAvatar(
    imageUrl: String,
    modifier: Modifier
) {
    Box(modifier) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .clip(RoundedCornerShape(12.dp))
                .size(80.dp)
                .aspectRatio(1f)
        )
        Icon(
            painter = Circle(Color.Blue),
            contentDescription = "icon status",
            modifier = Modifier.align(Alignment.BottomEnd).size(24.dp).padding(4.dp),
            tint = Color.Unspecified
        )
    }
}

class Circle(private val color: Color) : Painter() {
    override val intrinsicSize: Size
        get() = Size(10f, 10f)

    override fun DrawScope.onDraw() {
        val stroke = Stroke(2.5f)
        drawCircle(color = color)
        val arcRadius = (size.minDimension / 2f) - (stroke.width * 2f)
        val arcBounds = Rect(
            size.center.x - arcRadius,
            size.center.y - arcRadius,
            size.center.x + arcRadius,
            size.center.y + arcRadius
        )
        drawArc(
            color = Color.White,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            alpha = .6f,
            topLeft = arcBounds.topLeft,
            size = arcBounds.size,
            style = stroke
        )
    }
}

// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview() {
//    ComposePlaygroundTheme {
//
//    }
// }
