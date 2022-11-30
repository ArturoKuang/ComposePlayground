package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
                        imageDescription = "Read 240 consecutive pages",
                        modifier = Modifier.padding(start = 16.dp, top = 32.dp)
                    )

                    SheetStack()
                }
            }
        }
    }
}

@Composable
fun SheetStack(modifier: Modifier = Modifier) {
    TopSheet(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp)
    )

    BottomSheet(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 268.dp)
    )
}

@Composable
fun BottomSheet(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
            .background(MaterialTheme.colors.onPrimary)
            .padding(16.dp)
    ) {
    }
}

@Composable
fun TopSheet(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ) {
        TopSheetInfo()
    }
}

@Composable
fun TopSheetInfo(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
        TopSheetInfoText("2703", "Vocabulary")
        Divider(
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(start = 48.dp, end = 48.dp, top = 16.dp)
                .height(48.dp)
                .width(1.dp)
        )
        TopSheetInfoText("4.5", "IELTS")
    }
}

@Composable
fun TopSheetInfoText(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onPrimary
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Composable
fun CourseHeader(
    imageUrl: String,
    imageTitle: String,
    imageDescription: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        CourseHeaderAvatar(imageUrl = imageUrl)
        CourseHeaderTitle(imageTitle = imageTitle, imageDescription = imageDescription)
    }
}

@Composable
fun CourseHeaderTitle(
    imageTitle: String,
    imageDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp)
    ) {
        Text(
            text = imageTitle,
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h3
        )

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.onBackground)
                .padding(start = 8.dp, top = 2.dp, end = 8.dp, bottom = 2.dp)
        ) {
            Text(
                text = imageDescription,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body1
            )
        }
    }
}


@Composable
fun CourseHeaderAvatar(
    imageUrl: String,
    modifier: Modifier = Modifier
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
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(24.dp)
                .padding(4.dp),
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
