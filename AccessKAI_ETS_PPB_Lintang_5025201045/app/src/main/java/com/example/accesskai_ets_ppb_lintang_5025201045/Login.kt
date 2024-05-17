package com.example.accesskai_ets_ppb_lintang_5025201045

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.access_kai_logo),
            contentDescription = "Login Image",
            modifier = Modifier.size(150.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.traveler_image),
            contentDescription = "Login Image",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.size(12.dp))

        Column(
            modifier = Modifier.width(280.dp)
        ) {
            Text(
                text = "Welcome to Access",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE16417)
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = "Login sekarang untuk menikmati fitur-fitur menarik yang tersedia di Acess by KAI",
                color = Color(0xFFE16417)
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Email")
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.size(20.dp))

        val username = email.substringBefore("@").replaceFirstChar { it.uppercase() }
        Button(
            onClick = {
                navController.navigate(Routes.tiketKereta + "/$username")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE16417),
                contentColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
        ) {
            Text(text = "Login")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.bumn_logo),
                contentDescription = "Microsoft",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { }
            )

            Image(
                painter = painterResource(id = R.drawable.kai_logo),
                contentDescription = "Github",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { }
            )
        }
    }
}
