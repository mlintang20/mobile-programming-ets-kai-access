package com.example.accesskai_ets_ppb_lintang_5025201045

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PilihKursi(
    navController: NavController, username: String, stasiunKeberangkatan: String,
    stasiunTujuan: String, namaKereta: String, kelas: String, harga: Int,
    jumlahPenumpang: String, jadwalKereta: String
) {
    // kereta, gerbong, no kursi --> Sancaka - Ekonomi 1 - Nomor 14C
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Pilih Tempat Duduk") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Routes.jadwalKereta +
                                "/$username/$stasiunKeberangkatan/$stasiunTujuan/$jadwalKereta/$jumlahPenumpang")
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
            val listGerbong = listOf("Gerbong 1", "Gerbong 2", "Gerbong 3", "Gerbong 4")
            val listKursi = listOf(
                "1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D",
                "3A", "3B", "3C", "3D", "4A", "4B", "4C", "4D",
                "5A", "5B", "5C", "5D", "6A", "6B", "6C", "6D",
                "7A", "7B", "7C", "7D", "8A", "8B", "8C", "8D",
                "9A", "9B", "9C", "9D", "10A", "10B", "10C", "10D"
            )
            var gerbongDipilih by remember { mutableStateOf("") }
            var kursiDipilih by remember { mutableStateOf("") }
            var gerbongDipilih2 by remember { mutableStateOf("") }
            var kursiDipilih2 by remember { mutableStateOf("") }

            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Kereta $namaKereta ($stasiunKeberangkatan - $stasiunTujuan)",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))


                // penumpang 1
                Text(text = "Penumpang 1")

                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuField(
                    label = "Pilih Gerbong",
                    options = listGerbong,
                    selectedOption = gerbongDipilih,
                    onOptionSelected = { gerbongDipilih = it }
                )

                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuField(
                    label = "Pilih Kursi",
                    options = listKursi,
                    selectedOption = kursiDipilih,
                    onOptionSelected = { kursiDipilih = it }
                )

                Spacer(modifier = Modifier.height(32.dp))

                // penumpang 2
                Text(text = "Penumpang 2")

                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuField(
                    label = "Pilih Gerbong",
                    options = listGerbong,
                    selectedOption = gerbongDipilih2,
                    onOptionSelected = { gerbongDipilih2 = it }
                )

                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuField(
                    label = "Pilih Kursi",
                    options = listKursi,
                    selectedOption = kursiDipilih2,
                    onOptionSelected = { kursiDipilih2 = it }
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        // stasiun A, stasiun B, namaKereta, kelas, harga, jumlahPenumpang
                        navController.navigate(Routes.pembayaran +
                                "/$username/$stasiunKeberangkatan/$stasiunTujuan/$namaKereta/$kelas/${harga.toString()}/$jumlahPenumpang/$jadwalKereta")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE16417),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "simpan".uppercase())
                }
            }
        }
    }
}