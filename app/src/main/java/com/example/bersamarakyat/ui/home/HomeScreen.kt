package com.example.bersamarakyat.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Beranda")
            val stats = listOf(
                StatItem("50+", "Program Pemerintah", "Program aktif yang sedang berjalan"),
                StatItem("1000+", "Diskusi Aktif", "Forum diskusi yang berkembang"),
                StatItem("25K+", "Pengguna Aktif", "Pengguna yang berpartisipasi aktif"),
                StatItem("100+", "Daerah Terjangkau", "Wilayah yang telah terjangkau")
            )

            val governmentPrograms = listOf(
                ProgramItem("Pemerintahan Pusat", "Lorem ipsum dolor sit amet...", R.drawable.ikn),
                ProgramItem(
                    "Pemerintahan Daerah",
                    "Lorem ipsum dolor sit amet...",
                    R.drawable.istana
                )
            )

            val discussions = listOf(
                DiscussionItem(
                    tag = "IKN #Infrastruktur2024",
                    title = "Evaluasi Program Pembangunan Infrastruktur 2024",
                    description = "Analisis mendalam mengenai pencapaian dan tantangan...",
                    views = "1,231",
                    comments = "85",
                    image = R.drawable.pp1,
                    author = "Prof. Khalied",
                    timeAgo = "2 jam yang lalu",
                    category = "Infrastruktur"
                ),
                DiscussionItem(
                    tag = "Pendidikan2024 #KurikulumMerdeka",
                    title = "Implementasi Kurikulum Baru di Sekolah Negeri",
                    description = "Pembahasan mengenai efektivitas dan tantangan...",
                    views = "958",
                    comments = "67",
                    image = R.drawable.pp2,
                    author = "Talitha",
                    timeAgo = "4 jam yang lalu",
                    category = "Pendidikan"
                ),
                DiscussionItem(
                    tag = "KesehatanPublik #BPJS",
                    title = "Peningkatan Layanan BPJS di Daerah Terpencil",
                    description = "Evaluasi dan solusi untuk meningkatkan akses...",
                    views = "847",
                    comments = "45",
                    image = R.drawable.pp3,
                    author = "Dr. Nouval",
                    timeAgo = "5 jam yang lalu",
                    category = "Kesehatan"
                )
            )

            val features = listOf(
                FeatureItem(
                    icon = R.drawable.ic_lembaga,
                    title = "Program Pemerintah",
                    description = "Pantau dan evaluasi program-program pemerintah secara real-time"
                ),
                FeatureItem(
                    icon = R.drawable.ic_book,
                    title = "Perundang-undangan",
                    description = "Akses dokumen hukum dan perundangan dengan mudah"
                ),
                FeatureItem(
                    icon = R.drawable.ic_acc,
                    title = "Kolaborasi",
                    description = "Berpartisipasi dalam diskusi dan sampaikan aspirasi"
                ),
                FeatureItem(
                    icon = R.drawable.ic_forum,
                    title = "Forum Diskusi",
                    description = "Ruang diskusi interaktif untuk membahas isu-isu terkini"
                )
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                item {
                    HeroSection()
                }

                // Stats Section
                item {
                    StatsSection(stats)
                }

                // Features Section
                item {
                    FeaturesSection(features)
                }

                // Government Programs Section
                item {
                    GovernmentProgramsSection(governmentPrograms)
                }

                // Discussions Section
                item {
                    DiscussionsSection(discussions)
                }

                // CTA Section
                item {
                    CTASection()
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
fun HeroSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                    colors = listOf(
                        Color(0x0DFF0000),
                        Color(0x1AFF0000)
                    )
                )
            )
            .padding(vertical = 32.dp, horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Chip(text = "Bersama Rakyat, Untuk Indonesia")

            Text(
                text = "Kawal Setiap Program Pemerintah",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )

            Text(
                text = "Bersama rakyat kita wujudkan pemerintahan yang bersih dan transparan.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray
                )
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /* TODO: Implement action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF0000)
                    )
                ) {
                    Text("Mulai Sekarang")
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                OutlinedButton(
                    onClick = { /* TODO: Implement action */ },
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF0000), Color(0xFFFF0000))
                        )
                    )
                ) {
                    Text(
                        "Pelajari Lebih Lanjut",
                        color = Color(0xFFFF0000)
                    )
                }
            }
        }
    }
}

@Composable
fun StatsSection(stats: List<StatItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(280.dp) // Sesuaikan dengan kebutuhan
    ) {
        items(stats) { stat ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stat.value,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            color = Color(0xFFFF0000),
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = stat.label,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stat.description,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Gray
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun FeaturesSection(features: List<FeatureItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF9FAFB))
            .padding(vertical = 32.dp)
    ) {
        Text(
            "Fitur Unggulan Platform",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.height(400.dp) // Sesuaikan dengan kebutuhan
        ) {
            items(features) { feature ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = feature.icon),
                            contentDescription = null,
                            tint = Color(0xFFFF0000),
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    Color(0x1AFF0000),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(8.dp)
                        )

                        Text(
                            text = feature.title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = feature.description,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.Gray
                            )
                        )

                        Row(
                            modifier = Modifier.clickable { /* TODO: Implement action */ },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Pelajari Lebih Lanjut",
                                color = Color(0xFFFF0000),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color(0xFFFF0000)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GovernmentProgramsSection(programs: List<ProgramItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    ) {
        Text(
            "Program Pemerintah",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(programs) { program ->
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .aspectRatio(1f),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = program.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = program.title,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = program.description,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = Color.Gray
                                )
                            )
                            Row(
                                modifier = Modifier.clickable { /* TODO: Implement action */ },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Pelajari Lebih Lanjut",
                                    color = Color(0xFFFF0000),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(0xFFFF0000)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiscussionsSection(discussions: List<DiscussionItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Diskusi Terkini",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            TextButton(
                onClick = { /* TODO: Implement action */ },
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFFFF0000))
            ) {
                Text("Lihat Semua >")
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(discussions) { discussion ->
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .aspectRatio(0.75f),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                color = Color(0xFFFF0000),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Text(
                                    text = discussion.category,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                            Text(
                                text = "#${discussion.tag}",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = Color.Gray
                                )
                            )
                        }

                        Text(
                            text = discussion.title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            maxLines = 2
                        )

                        Text(
                            text = discussion.description,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.Gray
                            ),
                            maxLines = 2
                        )

                        Divider(modifier = Modifier.padding(vertical = 8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_eye),
                                    contentDescription = "Views",
                                    modifier = Modifier.size(16.dp),
                                    tint = Color.Gray
                                )
                                Text(
                                    text = discussion.views,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = Color.Gray
                                    )
                                )

                                Icon(
                                    painter = painterResource(id = R.drawable.ic_message),
                                    contentDescription = "Comments",
                                    modifier = Modifier.size(16.dp),
                                    tint = Color.Gray
                                )
                                Text(
                                    text = discussion.comments,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = Color.Gray
                                    )
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = discussion.image),
                                    contentDescription = "Author",
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                                Column {
                                    Text(
                                        text = discussion.author,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            fontWeight = FontWeight.Medium
                                        )
                                    )
                                    Text(
                                        text = discussion.timeAgo,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            color = Color.Gray
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CTASection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Bergabung Sekarang",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Jadilah bagian dari perubahan. Bersama kita wujudkan Indonesia yang lebih baik melalui pengawasan dan partisipasi aktif dalam program pemerintah.",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray
                ),
                textAlign = TextAlign.Center
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { /* TODO: Implement action */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF0000)
                    )
                ) {
                    Text("Daftar Gratis")
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                OutlinedButton(
                    onClick = { /* TODO: Implement action */ },
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF0000), Color(0xFFFF0000))
                        )
                    )
                ) {
                    Text(
                        "Hubungi Kami",
                        color = Color(0xFFFF0000)
                    )
                }
            }
        }
    }
}

data class StatItem(
    val value: String,
    val label: String,
    val description: String
)

data class ProgramItem(
    val title: String,
    val description: String,
    val image: Int
)

data class DiscussionItem(
    val tag: String,
    val title: String,
    val description: String,
    val views: String,
    val comments: String,
    val image: Int,
    val author: String,
    val timeAgo: String,
    val category: String
)

data class FeatureItem(
    val icon: Int,
    val title: String,
    val description: String
)

@Composable
fun Chip(text: String) {
    Surface(
        color = Color(0x1AFF0000),
        shape = RoundedCornerShape(32.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall.copy(
                color = Color(0xFFFF0000)
            ),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(context = LocalContext.current))
}