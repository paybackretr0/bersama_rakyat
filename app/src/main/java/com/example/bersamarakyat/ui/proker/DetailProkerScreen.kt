package com.example.bersamarakyat.ui.proker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar

@Composable
fun DetailProkerScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Detail Program")
            val publicRatings = listOf(
                RatingItem("Kepuasan Publik", 86),
                RatingItem("Rating Program", 78),
                RatingItem("Persentase teraliasi", 94),
                RatingItem("Indeks Kepercayaan", 73)
            )

            val programDetails = listOf(
                DetailItem("Target", "Anak anak Sekolah dan Ibu Hamil"),
                DetailItem("Durasi", "Selama Periode Pemerintahan 2024-2029"),
                DetailItem("Status", "Pelaksanaan"),
                DetailItem("Penanggung Jawab", "Presiden Republik Indonesia"),
                DetailItem("Wilayah", "Seluruh Wilayah di Indonesia")
            )

            val comments = listOf(
                CommentItem(
                    id = 1,
                    username = "khalied",
                    tag = "#proker #presiden #2024",
                    content = "Saya setuju , tapi apakah anggarannya cukup ?",
                    likes = "12/b",
                    dislikes = "300",
                    views = "120k"
                ),
                CommentItem(
                    id = 2,
                    username = "khalied",
                    tag = "#proker #presiden #2024",
                    content = "Saya setuju , tapi apakah anggarannya cukup ?",
                    likes = "12/b",
                    dislikes = "300",
                    views = "120k"
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(Color(0xFFF5F5F5))
            ) {
                // Header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Makan Siang Bergizi Gratis",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Program Presiden Republik Indonesia",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }

                // Main Image
                Image(
                    painter = painterResource(id = R.drawable.anti_stunting),
                    contentDescription = "Program Makan Siang",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                // Description
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Deskripsi",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Program Makan Siang Gratis adalah inisiatif untuk memastikan anak-anak sekolah mendapatkan asupan gizi yang cukup melalui penyediaan makan siang sehat setiap hari. Program ini bertujuan untuk meningkatkan konsentrasi belajar, kesehatan siswa, dan meringankan beban ekonomi keluarga. Dengan melibatkan petani lokal sebagai pemasok bahan makanan, program ini juga mendukung pemberdayaan ekonomi masyarakat setempat.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }

                // Program Details
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    programDetails.forEach { detail ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = detail.label,
                                modifier = Modifier.width(140.dp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = detail.value,
                                color = Color.Gray
                            )
                        }
                        Divider()
                    }
                }

                // Document Button
                Button(
                    onClick = { },
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB71C1C)
                    )
                ) {
                    Text("Dokumen Terkait")
                }

                // Public Ratings
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Penilaian Masyarakat",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        publicRatings.forEach { rating ->
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 4.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = rating.label,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Text(
                                        text = "${rating.value}% Puas",
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                                LinearProgressIndicator(
                                    progress = rating.value / 100f,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(8.dp)
                                        .clip(RoundedCornerShape(4.dp)),
                                    color = Color(0xFFB71C1C),
                                    trackColor = Color(0xFFE0E0E0)
                                )
                            }
                        }
                    }
                }

                // Comments Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Komentar Publik",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Action Buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFB71C1C)
                            )
                        ) {
                            Text("Forum Diskusi")
                        }
                        OutlinedButton(
                            onClick = { },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color(0xFFB71C1C)
                            ),
                            border = BorderStroke(1.dp, Color(0xFFB71C1C))
                        ) {
                            Text("Tanggapan")
                        }
                        OutlinedButton(
                            onClick = { },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color(0xFFB71C1C)
                            ),
                            border = BorderStroke(1.dp, Color(0xFFB71C1C))
                        ) {
                            Text("Survey")
                        }
                    }

                    // Comments
                    Text(
                        text = "Tanggapan Teratas",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    comments.forEach { comment ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = comment.username,
                                        fontWeight = FontWeight.Medium,
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                    Text(
                                        text = comment.tag,
                                        color = Color(0xFFB71C1C),
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                                Text(
                                    text = comment.content,
                                    color = Color.Gray,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.ThumbUp,
                                            contentDescription = "Likes",
                                            modifier = Modifier.size(16.dp),
                                            tint = Color.Gray
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(text = comment.likes, color = Color.Gray)
                                    }
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            painterResource(id = R.drawable.ic_thumbdown),
                                            contentDescription = "Dislikes",
                                            modifier = Modifier.size(16.dp),
                                            tint = Color.Gray
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(text = comment.dislikes, color = Color.Gray)
                                    }
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            painterResource(id = R.drawable.ic_eye),
                                            contentDescription = "Views",
                                            modifier = Modifier.size(16.dp),
                                            tint = Color.Gray
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(text = comment.views, color = Color.Gray)
                                    }
                                }
                            }
                        }
                    }
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

data class RatingItem(
    val label: String,
    val value: Int
)

data class DetailItem(
    val label: String,
    val value: String
)

data class CommentItem(
    val id: Int,
    val username: String,
    val tag: String,
    val content: String,
    val likes: String,
    val dislikes: String,
    val views: String
)