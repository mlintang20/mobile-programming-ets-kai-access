package com.example.accesskai_ets_ppb_lintang_5025201045

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.login, builder = {
                composable(Routes.login) {
                    Login(navController = navController)
                }
                composable(Routes.tiketKereta + "/{username}") {
                    val username = it.arguments?.getString("username")
                    TiketKereta(navController, username?: "User tidak ditemukan")
                }
                composable(
                    Routes.jadwalKereta + "/{username}" + "/{stasiunKeberangkatan}" +
                            "/{stasiunTujuan}" + "/{jadwalKereta}" +"/{jumlahPenumpang}"
                ) {
                    val username = it.arguments?.getString("username")
                    val stasiunKeberangkatan = it.arguments?.getString("stasiunKeberangkatan")
                    val stasiunTujuan = it.arguments?.getString("stasiunTujuan")
                    val jadwalKereta = it.arguments?.getString("jadwalKereta")
                    val jumlahPenumpang = it.arguments?.getString("jumlahPenumpang")
                    JadwalKereta(
                        navController = navController,
                        username?: "User tidak ditemukan",
                        stasiunKeberangkatan?: "Stasiun tidak ditemukan",
                        stasiunTujuan?: "Stasiun tidak ditemukan",
                        jadwalKereta?: "Jadwal tidak ditemukan",
                        jumlahPenumpang?: "Penumpang tidak ditemukan"
                    )
                }
                composable(
                    Routes.pilihKursi + "/{username}" + "/{stasiunKeberangkatan}" +
                            "/{stasiunTujuan}" +"/{namaKereta}" +"/{kelas}" +"/{harga}" +
                            "/{jumlahPenumpang}" + "/{jadwalKereta}"
                ) {
                    val username = it.arguments?.getString("username")
                    val stasiunKeberangkatan = it.arguments?.getString("stasiunKeberangkatan")
                    val stasiunTujuan = it.arguments?.getString("stasiunTujuan")
                    val namaKereta = it.arguments?.getString("namaKereta")
                    val kelas = it.arguments?.getString("kelas")
                    val harga = it.arguments?.getString("harga")?.toIntOrNull() ?: 0
                    val jumlahPenumpang = it.arguments?.getString("jumlahPenumpang")
                    val jadwalKereta = it.arguments?.getString("jadwalKereta")
                    PilihKursi(
                        navController = navController,
                        username?: "User tidak ditemukan",
                        stasiunKeberangkatan?: "Stasiun tidak ditemukan",
                        stasiunTujuan?: "Stasiun tidak ditemukan",
                        namaKereta?: "Kereta tidak ditemukan",
                        kelas?: "Kelas tidak ditemukan",
                        harga,
                        jumlahPenumpang?: "Penumpang tidak ditemukan",
                        jadwalKereta?: "Jadwal tidak ditemukan",
                    )
                }
                composable(
                    Routes.pembayaran + "/{username}" + "/{stasiunKeberangkatan}" +
                            "/{stasiunTujuan}" +"/{namaKereta}" +"/{kelas}" +"/{harga}" +
                            "/{jumlahPenumpang}" + "/{jadwalKereta}"
                ) {
                    val username = it.arguments?.getString("username")
                    val stasiunKeberangkatan = it.arguments?.getString("stasiunKeberangkatan")
                    val stasiunTujuan = it.arguments?.getString("stasiunTujuan")
                    val namaKereta = it.arguments?.getString("namaKereta")
                    val kelas = it.arguments?.getString("kelas")
                    val harga = it.arguments?.getString("harga")?.toIntOrNull() ?: 0
                    val jumlahPenumpang = it.arguments?.getString("jumlahPenumpang")
                    val jadwalKereta = it.arguments?.getString("jadwalKereta")
                    Pembayaran(
                        navController = navController,
                        username?: "User tidak ditemukan",
                        stasiunKeberangkatan?: "Stasiun tidak ditemukan",
                        stasiunTujuan?: "Stasiun tidak ditemukan",
                        namaKereta?: "Kereta tidak ditemukan",
                        kelas?: "Kelas tidak ditemukan",
                        harga,
                        jumlahPenumpang?: "Penumpang tidak ditemukan",
                        jadwalKereta?: "Jadwal tidak ditemukan",
                    )
                }
                composable(
                    Routes.notifikasi + "/{username}" + "/{stasiunKeberangkatan}" +
                            "/{stasiunTujuan}" +"/{namaKereta}" +"/{kelas}" +"/{harga}" +
                            "/{jumlahPenumpang}" + "/{jadwalKereta}"
                ) {
                    val username = it.arguments?.getString("username")
                    val stasiunKeberangkatan = it.arguments?.getString("stasiunKeberangkatan")
                    val stasiunTujuan = it.arguments?.getString("stasiunTujuan")
                    val namaKereta = it.arguments?.getString("namaKereta")
                    val kelas = it.arguments?.getString("kelas")
                    val harga = it.arguments?.getString("harga")?.toIntOrNull() ?: 0
                    val jumlahPenumpang = it.arguments?.getString("jumlahPenumpang")
                    val jadwalKereta = it.arguments?.getString("jadwalKereta")
                    Notifikasi(
                        navController = navController,
                        username?: "User tidak ditemukan",
                        stasiunKeberangkatan?: "Stasiun tidak ditemukan",
                        stasiunTujuan?: "Stasiun tidak ditemukan",
                        namaKereta?: "Kereta tidak ditemukan",
                        kelas?: "Kelas tidak ditemukan",
                        harga,
                        jumlahPenumpang?: "Penumpang tidak ditemukan",
                        jadwalKereta?: "Jadwal tidak ditemukan",
                    )
                }
            })
        }
    }
}
