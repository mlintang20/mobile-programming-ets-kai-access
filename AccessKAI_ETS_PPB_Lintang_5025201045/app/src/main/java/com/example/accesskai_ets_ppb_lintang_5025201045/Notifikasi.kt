package com.example.accesskai_ets_ppb_lintang_5025201045

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notifikasi(
    navController: NavController, username: String, stasiunKeberangkatan: String,
    stasiunTujuan: String, namaKereta: String, kelas: String, harga: Int,
    jumlahPenumpang: String, jadwalKereta: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Notifikasi Pembayaran") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(
                            Routes.pembayaran +
                                    "/$username/$stasiunKeberangkatan/$stasiunTujuan/$namaKereta/$kelas/$harga/$jumlahPenumpang/$jadwalKereta"
                        )
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFA73C9C),
                    titleContentColor = Color(0xFFFFFFFF),
                    navigationIconContentColor = Color(0xFFFFFFFF)
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pemesanan Tiket $namaKereta Berhasil!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        navController.navigate(Routes.tiketKereta +
                                "/$username")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE16417),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "kembali".uppercase())
                }
            }
        }
    }
}