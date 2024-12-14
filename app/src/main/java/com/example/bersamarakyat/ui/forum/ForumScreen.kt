package com.example.bersamarakyat.ui.forum

import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

data class ForumItem(
    val id: Int,
    val username: String,
    val tags: String,
    val content: String,
    val likes: String,
    val dislikes: String,
    val views: String,
    val date: String,
    val image: Int,
    val slug: String
)

@Composable
fun ForumScreen(
    navController: NavController
) {
    var searchText by remember { mutableStateOf("") }
    var forumName by remember { mutableStateOf("") }
    var forumTag by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopNavBar(pageTitle = "Forum Diskusi")
            val forumData = listOf(
                ForumItem(
                    1, "khalled", "#proker #presiden #2024",
                    "Saya setuju , tapi apakah anggarannya cukup ?",
                    "12rb", "300", "120k", "12-10-2024",
                    R.drawable.proker, "proker"
                ),
                ForumItem(
                    1, "khalled", "#proker #presiden #2024",
                    "Saya setuju , tapi apakah anggarannya cukup ?",
                    "12rb", "300", "120k", "12-10-2024",
                    R.drawable.proker, "proker"
                ),
                ForumItem(
                    1, "khalled", "#proker #presiden #2024",
                    "Saya setuju , tapi apakah anggarannya cukup ?",
                    "12rb", "300", "120k", "12-10-2024",
                    R.drawable.proker, "proker"
                ),
                ForumItem(
                    1, "khalled", "#proker #presiden #2024",
                    "Saya setuju , tapi apakah anggarannya cukup ?",
                    "12rb", "300", "120k", "12-10-2024",
                    R.drawable.proker, "proker"
                ),
                // Add other forum items...
            )

            val tags = listOf(
                "#proker", "#presiden", "#wakilpresiden", "#2024",
                "#dewanperwakilanrakyat", "#mpr", "#dewanperwakilandaerah",
                "#kemenkumham", "#kominfo", "#dinaspendidikan", "#dinaskesehatan"
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF9FAFB))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header
                item {
                    Text(
                        text = "Forum Diskusi",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                // Search Bar
                item {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Search") },
                        leadingIcon = { Icon(Icons.Default.Search, null) },
                        shape = RoundedCornerShape(8.dp)
                    )
                }

                // Tags Section
                item {
                    Text(
                        "Cari Berdasarkan Tag",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(tags) { tag ->
                            Button(
                                onClick = { /* Handle tag click */ },
                                shape = CircleShape,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF0000)
                                )
                            ) {
                                Text(tag)
                            }
                        }
                    }
                }

                // Create Forum Card
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                "Buat Forum",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            OutlinedTextField(
                                value = forumName,
                                onValueChange = { forumName = it },
                                label = { Text("Nama Forum") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = forumTag,
                                onValueChange = { forumTag = it },
                                label = { Text("Tag") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            // Upload Area
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.surface,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 2.dp,
                                        color = MaterialTheme.colorScheme.outlineVariant,
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_upload),
                                        contentDescription = null,
                                        modifier = Modifier.size(48.dp),
                                        tint = MaterialTheme.colorScheme.outline
                                    )
                                    Text(
                                        "Drag & drop files or Browse",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.outline
                                    )
                                }
                            }

                            Button(
                                onClick = { /* Handle forum creation */ },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF0000)
                                )
                            ) {
                                Text("Buat Forum")
                            }
                        }
                    }
                }

                // Forum Trending Section
                item {
                    Text(
                        "Forum Trending",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }

                items(forumData) { forum ->
                    ForumCard(
                        forum = forum,
                        onForumClick = { navController.navigate("detail-forum") }
                    )
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
fun ForumCard(
    forum: ForumItem,
    onForumClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{ onForumClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            forum.username,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Text(
                            forum.date,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            forum.tags,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFFF0000)
                        )
                    }
                }

                Text(
                    forum.content,
                    style = MaterialTheme.typography.bodyLarge
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(forum.likes)
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_thumbdown),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(forum.dislikes)
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_eye),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(forum.views)
                    }
                }
            }

            Image(
                painter = painterResource(id = forum.image),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}