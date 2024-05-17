package com.example.accesskai_ets_ppb_lintang_5025201045

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.MaterialTheme
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
fun JadwalKereta(navController: NavController, username: String, stasiunKeberangkatan: String,
                 stasiunTujuan: String, jadwalKereta: String, jumlahPenumpang: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "$stasiunKeberangkatan > $stasiunTujuan".uppercase())
                        Text(
                            text = "$jadwalKereta - $jumlahPenumpang Penumpang",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Routes.tiketKereta + "/$username")
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
        val padding = it

        Box(
            modifier = Modifier
                .fillMaxSize()
//                .background(Color.LightGray)
                .padding(padding)
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF0F0F0))
                    .padding(8.dp)
            ) {
                items(daftarKereta) { tiket ->
                    CardTiket(tiket, username, stasiunKeberangkatan, stasiunTujuan, jumlahPenumpang, jadwalKereta, navController)
                }
            }
        }
    }
}

data class Tiket(
    val namaKereta: String,
    val kelas: String,
    val stasiunKeberangkatan: String,
    val waktuKeberangkatan: String,
    val durasi: String,
    val stasiunTujuan: String,
    val waktuTiba: String,
    val harga: Int
)

val daftarKereta = listOf(
    Tiket("Sancaka", "Ekonomi", "SGU", "11.15", "4j 0m", "YK", "15.15", 100000),
    Tiket("Argo Wilis", "Eksekutif", "SGU", "08.00", "5j 0m", "YK", "13.00", 300000),
    Tiket("Lodaya", "Bisnis", "SGU", "09.00", "5j 30m", "YK", "14.30", 200000),
    Tiket("Argo Bromo", "Bisnis", "SGU", "12.30", "4j 15m", "YK", "16.45", 200000),
    Tiket("Bima", "Eksekutif", "SGU", "10.00", "4j 30m", "YK", "14.30", 300000),
    Tiket("Gajayana", "Eksekutif", "SGU", "08.00", "4j 0m", "YK", "12.00", 300000)
)

@Composable
fun CardTiket(
    tiket: Tiket, username: String, stasiunKeberangkatan: String, stasiunTujuan: String,
    jumlahPenumpang: String, jadwalKereta: String, navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
//                        .background(Color.White)
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = tiket.namaKereta,
                    color = Color(0xFFE16417),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = tiket.kelas,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = tiket.stasiunKeberangkatan
                        )
                        Text(
                            text = tiket.waktuKeberangkatan,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Icon(Icons.Filled.ArrowForward, contentDescription = "")
                        Text(
                            text = tiket.durasi
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = tiket.stasiunTujuan
                        )
                        Text(
                            text = tiket.waktuTiba,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rp ${tiket.harga}",
                    color = Color(0xFFE16417),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        navController.navigate(
                            Routes.pilihKursi +
                                "/$username/$stasiunKeberangkatan/$stasiunTujuan/${tiket.namaKereta}/${tiket.kelas}/${tiket.harga.toString()}/$jumlahPenumpang/$jadwalKereta"
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE16417),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp)
                ) {
                    Text(text = "pilih".uppercase())
                }
            }
        }
    }
}