package com.example.moviedb.presentation.ui.onboarding

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviedb.R
import com.example.moviedb.navigation.Screen

@Composable
fun OnBoardingScreen(onNavigateToHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(modifier = Modifier
            .size(500.dp)
            .fillMaxSize(),
            painter = painterResource(id = R.drawable.main_banner),
            contentDescription = "MainBanner"
        )

        Text(
            text = stringResource(id = R.string.OnBoarding),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 14.dp),
            text = stringResource(id = R.string.title1),
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Center
        )

        Button(
            modifier = Modifier
                .size(height = 70.dp, width = 198.dp)
                .padding(top = 30.dp),
            colors = ButtonDefaults
                .buttonColors(containerColor = colorResource(id = R.color.buttonColor)),
            onClick = {
                Log.d("OnBoardingScreen", "Navigating to HomeScreen")
                onNavigateToHome()
                      },

        ) {
            Text(text = stringResource(id = R.string.Enter))
        }


    }
}

