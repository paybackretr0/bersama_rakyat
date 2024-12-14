package com.example.bersamarakyat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bersamarakyat.ui.berita.BeritaScreen
import com.example.bersamarakyat.ui.detail.DetailScreen
import com.example.bersamarakyat.ui.forum.DetailForumScreen
import com.example.bersamarakyat.ui.forum.ForumScreen
import com.example.bersamarakyat.ui.home.HomeScreen
import com.example.bersamarakyat.ui.program.ProgramPemerintahScreen
import com.example.bersamarakyat.ui.proker.DetailProkerScreen
import com.example.bersamarakyat.ui.theme.BersamaRakyatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BersamaRakyatTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("berita") {
                            BeritaScreen(navController = navController)
                        }
                        composable("forum") {
                            ForumScreen(navController = navController)
                        }
                        composable("program") {
                            ProgramPemerintahScreen(navController = navController)
                        }
                        composable("detail"){
                            DetailScreen(navController = navController)
                        }
                        composable("detail-proker"){
                            DetailProkerScreen(navController = navController)
                        }
                        composable("detail-forum") {
                            DetailForumScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

