package com.example.bersamarakyat.ui.forum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bersamarakyat.R
import com.example.bersamarakyat.ui.bar.BottomNavBar
import com.example.bersamarakyat.ui.bar.TopNavBar

@Composable
fun DetailForumScreen(
    navController: NavController
) {
    // Sample data
    val forumThread = ForumThread(
        id = 1,
        trending = "#Trending 1",
        title = "Saya setuju , tapi apakah anggarannya cukup ?",
        username = "khalied",
        likes = "12rb",
        dislikes = "300",
        views = "120k",
        tags = "#proker #presiden #2024",
        image = R.drawable.proker,
        comments = listOf(
            ForumComment( // Menggunakan ForumComment
                id = 1,
                username = "khalied",
                tags = "#proker #presiden #2024",
                content = "Sabar dong, kan presiden kita baru saja dilantik bulan november lalu",
                likes = "12rb",
                dislikes = "300",
                views = "120k",
                date = "12-10-2024"
            ),
            ForumComment( // Menggunakan ForumComment
                id = 2,
                username = "khalied",
                tags = "#proker #presiden #2024",
                content = "Tapi agak kurang yakin sih sama prokernya, mengingat ini berimbas ke PPN yang naik 12%",
                likes = "12rb",
                dislikes = "300",
                views = "120k",
                date = "12-10-2024"
            ),
            ForumComment( // Menggunakan ForumComment
                id = 3,
                username = "khalied",
                tags = "#proker #presiden #2024",
                content = "Kita tunggu saja kedepannya bagaimana",
                likes = "12rb",
                dislikes = "300",
                views = "120k",
                date = "12-10-2024"
            )
        )
    )

    Scaffold(
        topBar = {
            TopNavBar(pageTitle = "Detail Forum Diskusi")
        },
        bottomBar = {
            BottomNavBar(
                modifier = Modifier.fillMaxWidth(),
                navController = navController
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Trending
            Text(
                text = forumThread.trending,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Title
            Text(
                text = forumThread.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // User info and stats
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = forumThread.username,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(end = 16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EngagementStat(
                        painterResource(id = R.drawable.ic_thumbup),
                        value = forumThread.likes
                    )
                    EngagementStat(
                        painterResource(id = R.drawable.ic_thumbdown),
                        value = forumThread.dislikes
                    )
                    EngagementStat(
                        painterResource(id = R.drawable.ic_eye),
                        value = forumThread.views
                    )
                }
            }

            // Tags
            Row(
                modifier = Modifier.padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tag:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = forumThread.tags,
                    color = Color(0xFFB71C1C),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Main Image
            Image(
                painter = painterResource(id = forumThread.image),
                contentDescription = forumThread.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Comments
            forumThread.comments.forEach { comment ->
                CommentItem(comment = comment)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // More Comments Button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB71C1C)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Lihat Komentar Lainnya",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun EngagementStat(
    painter: Painter,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = Color.Gray
        )
        Text(
            text = value,
            color = Color.Gray
        )
    }
}

@Composable
private fun CommentItem(comment: ForumComment) { // Mengubah tipe parameter menjadi ForumComment
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = comment.tags,
                        color = Color(0xFFB71C1C),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(
                    text = comment.date,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Text(
                text = comment.content,
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                EngagementStat(
                    painterResource(id = R.drawable.ic_thumbup),
                    value = comment.likes
                )
                EngagementStat(
                    painterResource(id = R.drawable.ic_thumbdown),
                    value = comment.dislikes
                )
                EngagementStat(
                    painterResource(id = R.drawable.ic_eye),
                    value = comment.views
                )
            }
        }
    }
}

data class ForumThread(
    val id: Int,
    val trending: String,
    val title: String,
    val username: String,
    val likes: String,
    val dislikes: String,
    val views: String,
    val tags: String,
    val image: Int,
    val comments: List<ForumComment> // Menggunakan nama class baru
)

data class ForumComment( // Mengubah nama class dari Comment menjadi ForumComment
    val id: Int,
    val username: String,
    val tags: String,
    val content: String,
    val likes: String,
    val dislikes: String,
    val views: String,
    val date: String
)