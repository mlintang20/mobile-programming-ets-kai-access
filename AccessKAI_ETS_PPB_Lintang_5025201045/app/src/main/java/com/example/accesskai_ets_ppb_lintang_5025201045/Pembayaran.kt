package com.example.accesskai_ets_ppb_lintang_5025201045

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun Pembayaran(
    navController: NavController, username: String, stasiunKeberangkatan: String,
    stasiunTujuan: String, namaKereta: String, kelas: String, harga: Int,
    jumlahPenumpang: String, jadwalKereta: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Konfirmasi Pembayaran") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(
                        Routes.pilihKursi +
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
                .fillMaxWidth()
                .padding(paddingValues = it)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Detail Kereta",
                    fontSize = 32.sp,
                    color = Color(0xFFE16417),
                    fontWeight = FontWeight.Bold
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = jadwalKereta,
                                color = Color(0xFFE16417),
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stasiunKeberangkatan,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Icon(Icons.Filled.ArrowForward, contentDescription = "")
                            Text(
                                text = stasiunTujuan,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$namaKereta - $kelas",
                                color = Color(0xFFE16417),
                                fontSize = 20.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Rincian Harga",
                    fontSize = 32.sp,
                    color = Color(0xFFE16417),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Harga: Rp $harga",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Jumlah Penumpang: $jumlahPenumpang orang",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                val total = harga * jumlahPenumpang.toInt()
                Text(
                    text = "Total Harga: Rp $total",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        navController.navigate(Routes.notifikasi +
                                "/$username/$stasiunKeberangkatan/$stasiunTujuan/$namaKereta/$kelas/${harga.toString()}/$jumlahPenumpang/$jadwalKereta")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE16417),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "bayar".uppercase())
                }
            }
        }
    }
}