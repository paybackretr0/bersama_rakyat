package com.example.bersamarakyat.ui.program

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar
import java.util.Locale

data class GovernmentItem(
    val title: String,
    val description: String,
    val image: Int,
    val link: String
)

data class TrendingItem(
    val number: String,
    val title: String,
    val owner: String,
    val target: String,
    val image: Int,
    val description: String
)

@Composable
fun ProgramPemerintahScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Bersama Rakyat")
            var searchTerm by remember { mutableStateOf("") }
            var activeSection by remember { mutableStateOf("all") }

            val pusatData = listOf(
                GovernmentItem(
                    "Presiden dan Wakil Presiden",
                    "Pimpinan Tertinggi Negara",
                    R.drawable.presiden,
                    "/program/pemerintah-pusat/presiden"
                ),
                GovernmentItem(
                    "DPR-RI",
                    "Lembaga Legislatif",
                    R.drawable.dpr,
                    "/pemerintahan/dpr"
                ),
                GovernmentItem(
                    "Kementerian",
                    "Pembantu Presiden",
                    R.drawable.kementrian,
                    "/pemerintahan/kementrian"
                ),
                GovernmentItem(
                    "DPD-RI",
                    "Lembaga Legislatif",
                    R.drawable.dpd_ri,
                    "/pemerintahan/dpd"
                ),
            )

            val daerahData = listOf(
                GovernmentItem(
                    "DPRD - Provinsi",
                    "Legislatif Tingkat Provinsi",
                    R.drawable.dprd,
                    "/pemerintahan/dprd"
                ),
                GovernmentItem(
                    "Gubernur & Wakil Gubernur",
                    "Pemimpin Provinsi",
                    R.drawable.gub,
                    "/pemerintahan/gubernur"
                ),
                GovernmentItem(
                    "Dinas Kesehatan",
                    "Dinas Tingkat Provinsi",
                    R.drawable.kesehatan,
                    "/pemerintahan/kesehatan"
                ),
                GovernmentItem(
                    "Dinas Pendidikan",
                    "Dinas Tingkat Provinsi",
                    R.drawable.pendidikan,
                    "/pemerintahan/pendidikan"
                ),
                GovernmentItem(
                    "Dinas Kominfo",
                    "Dinas Tingkat Provinsi",
                    R.drawable.kominfo,
                    "/pemerintahan/kominfo"
                ),
            )

            val trendingData = listOf(
                TrendingItem(
                    "1",
                    "Makan Siang Gratis",
                    "Presiden Republik Indonesia",
                    "2025",
                    R.drawable.makan_gratis,
                    "Program bantuan makan siang gratis untuk masyarakat prasejahtera dan pelajar"
                ),
                TrendingItem(
                    "2",
                    "Rumah Rakyat Kecil",
                    "Presiden Republik Indonesia",
                    "2025",
                    R.drawable.rumah_gratis,
                    "Program pembangunan rumah subsidi untuk masyarakat berpenghasilan rendah"
                ),
                TrendingItem(
                    "3",
                    "Proyek Non Quick Win",
                    "Presiden Republik Indonesia",
                    "2025",
                    R.drawable.non_quick,
                    "Program pembangunan infrastruktur jangka panjang untuk kesejahteraan masyarakat"
                ),
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF9FAFB))
                    .padding(16.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Program Pemerintahan",
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "Pantau dan evaluasi program-program pemerintah untuk memastikan transparansi dan akuntabilitas dalam pelaksanaannya",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.Gray
                            ),
                            modifier = Modifier.padding(vertical = 16.dp)
                        )

                        OutlinedTextField(
                            value = searchTerm,
                            onValueChange = { searchTerm = it },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Cari program pemerintah...") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null,
                                    tint = Color.Gray
                                )
                            },
                            shape = RoundedCornerShape(24.dp)
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        listOf("all", "pusat", "daerah").forEach { section ->
                            Button(
                                onClick = { activeSection = section },
                                modifier = Modifier.padding(horizontal = 4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (activeSection == section) {
                                        Color(0xFFFF0000)
                                    } else {
                                        Color.White
                                    }
                                ),
                                shape = RoundedCornerShape(24.dp)
                            ) {
                                Text(
                                    text = section.capitalize(Locale.ROOT),
                                    color = if (activeSection == section) {
                                        Color.White
                                    } else {
                                        Color.Gray
                                    }
                                )
                            }
                        }
                    }
                }

                item {
                    SectionHeader("Pemerintah Pusat", "/program/pemerintah-pusat")
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.height(400.dp),
                        contentPadding = PaddingValues(vertical = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(pusatData) { item ->
                            GovernmentCard(
                                item = item,
                                onItemClick = {
                                    navController.navigate("detail")
                                }
                            )
                        }
                    }
                }

                item {
                    SectionHeader("Pemerintah Daerah", "/pemerintahan-daerah")
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.height(400.dp),
                        contentPadding = PaddingValues(vertical = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(daerahData) { item ->
                            GovernmentCard(
                                item = item,
                                onItemClick = {
                                    navController.navigate("detail")
                                }
                            )
                        }
                    }
                }

                item {
                    SectionHeader("Proker Trending", null)
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        trendingData.forEach { item ->
                            TrendingCard(item)
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(72.dp))
                }
            }
        }
        BottomNavBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            navController = navController
        )
    }
}

@Composable
fun SectionHeader(title: String, link: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(4.dp)
                    .background(Color(0xFFFF0000))
            )
        }

        if (link != null) {
            TextButton(
                onClick = { /* Navigate to link */ }
            ) {
                Text(
                    "Selengkapnya >",
                    color = Color(0xFFFF0000)
                )
            }
        }
    }
}

@Composable
fun GovernmentCard(
    item: GovernmentItem,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White.copy(alpha = 0.8f)
                    )
                )
            }
        }
    }
}

@Composable
fun TrendingCard(item: TrendingItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { /* Navigate to detail */ }
            .padding(bottom = 8.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${item.number}#",
                            style = MaterialTheme.typography.headlineSmall.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }

                    Text(
                        text = "Target: ${item.target}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color(0xFFFF0000)
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Milik: ${item.owner}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    )

                    TextButton(
                        onClick = { /* Navigate to detail */ }
                    ) {
                        Text(
                            "Lihat Detail >",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}