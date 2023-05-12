package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
        GalleryController()
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
            .size(120.dp),
        color = Color(0xFFFFDAD6)
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
                Text(stringResource(R.string.artist_name),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                )
                Text(stringResource(R.string.art_year),
                    style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Light,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun GalleryController(){
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*TODO*/ },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3E001D),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            ),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color(0xFF410002)),
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        ) {
            Text(stringResource(R.string.prev) )
        }
        Spacer(modifier = Modifier.width(40.dp))

        Button(onClick = { /*TODO*/ },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF3E001D),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 4.dp
            ),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color(0xFF410002)),
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier
                .width(120.dp)
                .height(50.dp)
        ) {
            Text(stringResource(R.string.next) )
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