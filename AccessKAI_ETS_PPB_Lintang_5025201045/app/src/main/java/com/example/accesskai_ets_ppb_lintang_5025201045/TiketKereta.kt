package com.example.accesskai_ets_ppb_lintang_5025201045

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiketKereta(navController: NavController, username: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Tiket Kereta Antar Kota") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Routes.login)
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
            val listStasiun = listOf("Surabaya", "Madiun", "Yogyakarta")
            var stasiunKeberangkatan by remember { mutableStateOf("") }
            var stasiunTujuan by remember { mutableStateOf("") }
            var jadwalKereta by remember { mutableStateOf("") }
            var jumlahPenumpang by remember { mutableStateOf("1") }

            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                LocalContext.current,
//                { _, year, month, dayOfMonth ->
//                    travelDate = "$dayOfMonth-${month + 1}-$year"
//                },
                { _, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance().apply {
                        set(year, month, dayOfMonth)
                    }.time
                    val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id", "ID"))
                    jadwalKereta = dateFormat.format(selectedDate)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Halo $username! Mau pergi ke mana?",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                DropdownMenuField(
                    label = "Stasiun Keberangkatan",
                    options = listStasiun,
                    selectedOption = stasiunKeberangkatan,
                    onOptionSelected = { stasiunKeberangkatan = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                DropdownMenuField(
                    label = "Stasiun Tujuan",
                    options = listStasiun,
                    selectedOption = stasiunTujuan,
                    onOptionSelected = { stasiunTujuan = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = jadwalKereta,
                    onValueChange = { },
                    label = { Text("Tanggal Keberangkatan") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { datePickerDialog.show() }) {
                            Icon(Icons.Default.DateRange, contentDescription = "Pilih Tanggal")
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = jumlahPenumpang,
                    onValueChange = { jumlahPenumpang = it },
                    label = { Text("Jumlah Penumpang") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        navController.navigate(Routes.jadwalKereta +
                                "/$username/$stasiunKeberangkatan/$stasiunTujuan/$jadwalKereta/$jumlahPenumpang")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE16417),
                        contentColor = Color(0xFFFFFFFF)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Cari Tiket".uppercase())
                }
            }
        }
    }
}

@Composable
fun DropdownMenuField(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = { },
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            readOnly = true,
            trailingIcon = {
                Icon(Icons.Default.ArrowDropDown, contentDescription = "Pilih Stasiun")
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                })
            }
        }
    }
}
