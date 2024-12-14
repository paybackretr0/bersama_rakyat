package com.example.bersamarakyat.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar

data class ProgramItem(
    val number: String,
    val title: String,
    val description: String,
    val image: Int,
    val watchers: String,
    val slug: String
)

@Composable
fun DetailScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Detail Program")
            val programData = listOf(
                ProgramItem(
                    "1",
                    "Makan Siang Bergizi Gratis",
                    "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend. Ut nonummy...",
                    R.drawable.makan_gratis,
                    "500ribu+ orang memantau program ini",
                    "pemerintah-pusat/presiden/makan-siang"
                ),
                ProgramItem(
                    "2",
                    "Makan Siang Bergizi Gratis",
                    "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend. Ut nonummy...",
                    R.drawable.makan_gratis,
                    "500ribu+ orang memantau program ini",
                    "pemerintah-pusat/presiden/makan-siang"
                ),
                ProgramItem(
                    "3",
                    "Makan Siang Bergizi Gratis",
                    "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend. Ut nonummy...",
                    R.drawable.makan_gratis,
                    "500ribu+ orang memantau program ini",
                    "pemerintah-pusat/presiden/makan-siang"
                ),
                ProgramItem(
                    "4",
                    "Makan Siang Bergizi Gratis",
                    "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend. Ut nonummy...",
                    R.drawable.makan_gratis,
                    "500ribu+ orang memantau program ini",
                    "pemerintah-pusat/presiden/makan-siang"
                ),
                ProgramItem(
                    "5",
                    "Makan Siang Bergizi Gratis",
                    "Suspendisse dui purus, scelerisque at, vulputate vitae, pretium mattis, nunc. Mauris eget neque at sem venenatis eleifend. Ut nonummy...",
                    R.drawable.makan_gratis,
                    "500ribu+ orang memantau program ini",
                    "pemerintah-pusat/presiden/makan-siang"
                ),
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                // Header Section
                item {
                    HeaderSection()
                }

                // Stats Section
                item {
                    StatsSection()
                }

                // Trending Section Title
                item {
                    Text(
                        text = "# Trending di Pembahasan",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(16.dp)
                    )
                }

                // Program Items
                items(programData) { program ->
                    ProgramCard(
                        program = program,
                        onProgramClick = {
                        navController.navigate("detail-proker")
                    })
                }

                // View All Button
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = { navController.navigate("program") },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF0000)
                            ),
                            modifier = Modifier.padding(vertical = 16.dp)
                        ) {
                            Text("Lihat Semua Program")
                            Icon(
                                Icons.Default.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.padding(start = 8.dp)
                            )
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
fun HeaderSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                // Banner with Text
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)  // Reduced height
                ) {
                    // Background
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFF0000))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.2f))
                    )

                    // Text at the top of banner
                    Text(
                        text = "Presiden & Wakil Presiden",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 24.dp),
                        textAlign = TextAlign.Center
                    )
                }

                // Spacer for profile image overlap
                Spacer(modifier = Modifier.height(180.dp))  // Space for overlapping profile

                // Profile Info
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Prabowo Subianto & Gibran Rakabuming Raka",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                    Surface(
                        color = Color(0xFFFFEBEE),
                        modifier = Modifier.padding(top = 8.dp),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = "Presiden & Wakil Presiden Republik Indonesia",
                            color = Color(0xFFFF0000),
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.presiden),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 80.dp)  // Position from the top instead of bottom
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White, RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(
            icon = Icons.Default.DateRange,
            label = "Masa Jabatan",
            value = "2024 - 2029"
        )
        StatItem(
            icon = Icons.Default.LocationOn,
            label = "Kedudukan",
            value = "Jakarta"
        )
        StatItem(
            icon = Icons.Default.Star,
            label = "Status",
            value = "Aktif"
        )
    }
}

@Composable
fun StatItem(
    icon: ImageVector,
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFFFF0000),
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ProgramCard(
    program: ProgramItem,
    onProgramClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable{onProgramClick()},
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = program.number,
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color(0xFFFF0000).copy(alpha = 0.2f)
                )
            )

            Image(
                painter = painterResource(id = program.image),
                contentDescription = null,
                modifier = Modifier
                    .size(112.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = program.title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = program.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_acc),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Gray
                        )
                        Text(
                            text = program.watchers,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { onProgramClick() }
                    ) {
                        Text(
                            text = "Lihat Detail",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFFF0000)
                        )
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color(0xFFFF0000),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}