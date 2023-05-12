package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgalleryapp.ui.theme.ArtGalleryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGalleryLayout()
                }
            }
        }
    }
}

@Composable
fun ArtGalleryLayout(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        GalleryWall()
        GalleryDescription()
    }


}

@Composable
fun GalleryWall(modifier: Modifier = Modifier){

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .size(400.dp)
            .shadow(6.dp, RectangleShape)
            .padding(28.dp),
    ) {
        Image(painter = painterResource(
            id = R.drawable.img1), contentDescription = "First Image"
        )
    }
}

@Composable
fun GalleryDescription(modifier: Modifier = Modifier){
    Spacer(modifier = Modifier.height(70.dp))

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .size(150.dp),
        color = Color.LightGray
    ){
        Column(modifier = Modifier
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = stringResource(R.string.description_content),
                style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Light,
                modifier = Modifier
            )

            Row() {
                Text(text = stringResource(R.string.artist_name),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                )
                Text(text = stringResource(R.string.art_year),
                    style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Light,
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtGalleryLayoutPreview() {
    ArtGalleryAppTheme {
        ArtGalleryLayout()
    }
}