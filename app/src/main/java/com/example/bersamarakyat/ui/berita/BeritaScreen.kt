package com.example.bersamarakyat.ui.berita

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar

data class TrendingNews(
    val id: Int,
    val title: String,
    val description: String,
    val image: Int,
    val link: String
)

data class News(
    val id: Int,
    val source: String,
    val sourceLogo: Int,
    val title: String,
    val date: String,
    val image: Int,
    val link: String
)

@Composable
fun BeritaScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Berita")
            val trendingNews = listOf(
                TrendingNews(
                    1,
                    "Makan Siang Bergizi Gratis",
                    "Program Makan Siang Gratis adalah inisiatif untuk memastikan anak-anak sekolah mendapatkan asupan gizi yang cukup melalui penyediaan makan siang sehat setiap hari. Program ini bertujuan untuk meningkatkan konsentrasi belajar, kesehatan siswa, dan meringankan beban ekonomi....",
                    R.drawable.anti_stunting,
                    "baca selengkapnya"
                )
            )

            val newsData = listOf(
                News(
                    1,
                    "detik.com",
                    R.drawable.detik,
                    "Prabowo berjanji akan melaksanakan makan gratis pada 2025",
                    "12-10-2024",
                    R.drawable.makan_gratis,
                    "baca selengkapnya"
                ),
                News(
                    2,
                    "detik.com",
                    R.drawable.detik,
                    "Prabowo berjanji akan melaksanakan makan gratis pada 2025",
                    "12-10-2024",
                    R.drawable.makan_gratis,
                    "baca selengkapnya"
                ),
                News(
                    3,
                    "detik.com",
                    R.drawable.detik,
                    "Prabowo berjanji akan melaksanakan makan gratis pada 2025",
                    "12-10-2024",
                    R.drawable.makan_gratis,
                    "baca selengkapnya"
                ),
            )

            var currentSlide by remember { mutableStateOf(0) }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Trending Section Title
                item {
                    Text(
                        text = "Trending",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                // Carousel
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        // Image and Overlay
                        Image(
                            painter = painterResource(id = trendingNews[currentSlide].image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 0.2f),
                                            Color.Black.copy(alpha = 0.4f),
                                            Color.Black.copy(alpha = 0.8f)
                                        )
                                    )
                                )
                        )

                        // Content
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Text(
                                text = trendingNews[currentSlide].title,
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = trendingNews[currentSlide].description,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = Color.White
                                )
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable {
                                    navController.navigate("berita/detail")
                                }
                            ) {
                                Text(
                                    text = trendingNews[currentSlide].link,
                                    color = Color.White
                                )
                                Icon(
                                    Icons.Default.ArrowForward,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        // Carousel Controls
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = {
                                    currentSlide =
                                        (currentSlide - 1 + trendingNews.size) % trendingNews.size
                                },
                                modifier = Modifier
                                    .background(Color.White.copy(alpha = 0.8f), CircleShape)
                                    .size(48.dp)
                            ) {
                                Icon(Icons.Default.ArrowBack, null)
                            }
                            IconButton(
                                onClick = {
                                    currentSlide = (currentSlide + 1) % trendingNews.size
                                },
                                modifier = Modifier
                                    .background(Color.White.copy(alpha = 0.8f), CircleShape)
                                    .size(48.dp)
                            ) {
                                Icon(Icons.Default.ArrowForward, null)
                            }
                        }
                    }
                }

                // News List
                items(newsData) { news ->
                    NewsCard(
                        news = news,
                        onNewsClick = { navController.navigate("berita/detail") }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(48.dp))
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
fun NewsCard(news: News, onNewsClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onNewsClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = news.sourceLogo),
                            contentDescription = news.source,
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = news.source,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = news.title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.outline
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = news.date,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }

                Image(
                    painter = painterResource(id = news.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onNewsClick() }
            ) {
                Text(
                    text = news.link,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline
                )
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}