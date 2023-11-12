package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@Composable
fun BhgAtas() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val image = painterResource(R.drawable.umt_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(width = 150.dp, height = 150.dp))
        Text(
            text = "Muhammad Nazrin Bin Hazrul Nizam",
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Mobile Computing Student",
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun BhgBawah() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Row (modifier = Modifier.padding(10.dp)){
                val image1 = painterResource(R.drawable.call)
                Icon(painter = image1, contentDescription = null,
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp))
                Text(text = "+60123771591")
            }
            Row (modifier = Modifier.padding(10.dp)){
                val image2 = painterResource(R.drawable.share)
                Icon(painter = image2, contentDescription = null,
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp))
                Text(text = "@Ghozt")
            }
            Row (modifier = Modifier.padding(10.dp)){
                val image3 = painterResource(R.drawable.mail)
                Icon(painter = image3, contentDescription = null,
                    modifier = Modifier
                        .size(width = 20.dp, height = 20.dp))
                Text(text = "nazrinc7@gmail.com")
            }
        }
    }

}

@Composable
fun Test() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFD373D3))){
        BhgAtas()
        BhgBawah()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
       Test()
    }
}