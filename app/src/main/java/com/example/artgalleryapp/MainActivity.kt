package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
    var currentArt: Int by remember { mutableStateOf(0) }
    var currentDescription by remember { mutableStateOf(0) }
    var currentArtistName by remember { mutableStateOf(0) }
    var currentArtDate by remember { mutableStateOf(0) }

    val artResource = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4
    )

    val descriptionResource = listOf(
        R.string.description_content1,
        R.string.description_content2,
        R.string.description_content3,
        R.string.description_content4
    )

    val artistNameResource = listOf(
        R.string.artist_name1,
        R.string.artist_name2,
        R.string.artist_name3,
        R.string.artist_name4
    )

    val artDateResource = listOf(
        R.string.art_year1,
        R.string.art_year2,
        R.string.art_year3,
        R.string.art_year4
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        GalleryWall(
            painter = artResource[currentArt],
            contentDescription = artResource.toString()
        )

        Spacer(modifier = Modifier.height(70.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .size(120.dp),
            color = Color(0xFFFFDAD6)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
            ) {


                GalleryDescription(
                    text = descriptionResource[currentDescription],
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                )

                Row() {
                    GalleryDescription(
                        text = artistNameResource[currentArtistName],
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                    )

                    GalleryDescription(
                        text = artDateResource[currentArtDate],
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            GalleryController(
                onClick = {
                    if (currentArt >= 0 && currentDescription >= 0 && currentArtistName >= 0 && currentArtDate >= 0) {
                        currentArt = if (currentArt == 0) artResource.lastIndex else currentArt - 1
                        currentDescription = if (currentDescription == 0) descriptionResource.lastIndex else currentDescription - 1
                        currentArtistName = if (currentArtistName == 0) artistNameResource.lastIndex else currentArtistName - 1
                        currentArtDate = if (currentArtDate == 0) artDateResource.lastIndex else currentArtDate - 1
                    }
                },
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
                    .height(50.dp),
                text = R.string.prev
            )

            Spacer(modifier = Modifier.width(40.dp))

            GalleryController(
                onClick = {
                    currentArt = (currentArt + 1) % artResource.size
                    currentDescription = (currentDescription + 1) % descriptionResource.size
                    currentArtistName = (currentArtistName + 1) % artistNameResource.size
                    currentArtDate = (currentArt + 1) % artDateResource.size},
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
                    .height(50.dp),
                text = R.string.next
            )
        }


    }


}

@Composable
fun GalleryWall(@DrawableRes painter: Int, contentDescription: String, modifier: Modifier = Modifier){

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .size(400.dp)
            .shadow(6.dp, RectangleShape)
            .padding(28.dp),
    ) {
        Image(
            painter = painterResource(
            id = painter),
            contentDescription = contentDescription
        )
    }
}

@Composable
fun GalleryDescription(text: Int, style: TextStyle = LocalTextStyle.current,
                       fontWeight: FontWeight? = null, modifier: Modifier = Modifier){


            Text(
                text = stringResource(text),
                style = style,
                fontWeight = fontWeight,
                modifier = Modifier
            )

}

@Composable
fun GalleryController(onClick: () -> Unit, text: Int, enabled: Boolean = true, colors: ButtonColors, elevation: ButtonElevation,
                      shape: RoundedCornerShape, border: BorderStroke,
                      contentPadding: PaddingValues, modifier: Modifier) {

    Button(
        onClick = onClick,
        enabled = enabled,
        colors = colors,
        elevation = elevation,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        modifier = modifier
    ){
        Text(
            text = stringResource(id = text))
    }

}

@Preview(showBackground = true)
@Composable
fun ArtGalleryLayoutPreview() {
    ArtGalleryAppTheme {
        ArtGalleryLayout()
    }
}