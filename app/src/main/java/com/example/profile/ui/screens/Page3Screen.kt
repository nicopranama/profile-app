package com.example.profile.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.navigation.NavigationManager
import com.example.profile.ui.components.PaginationButtons
import androidx.core.net.toUri

data class Project(
    val title: String,
    val description: String,
    val url: String
)

@Composable
fun Page3Screen(navigationManager: NavigationManager) {
    val context = LocalContext.current

    val projects = listOf(
        Project(
            title = "Lumina",
            description = "AI-Powered Skincare Recommendation Application",
            url = "https://github.com/nicopranama/lumina"
        ),
        Project(
            title = "Pioneer Desa Wisata Bumiaji Website",
            description = "Web development project for Bumiaji Tourism Village, part of the Project Pioneer initiative.",
            url = "https://amazingbumiaji.online/"
        ),
        Project(
            title = "HukumAI",
            description = "AI-powered legal assistant for Indonesian MSMEs using RAG",
            url = "https://github.com/nicopranama/hukumai"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Page Title
        Text(
            text = "Page 3",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Projects Card
        Card(
            modifier = Modifier
                .width(320.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title
                Text(
                    text = "Projects",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Projects list
                projects.forEach { project ->
                    ProjectCard(
                        project = project,
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, project.url.toUri())
                            context.startActivity(intent)
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        // Pagination Buttons
        PaginationButtons(navigationManager = navigationManager)
    }
}

@Composable
private fun ProjectCard(
    project: Project,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF404040)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = project.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = project.description,
                fontSize = 13.sp,
                color = Color(0xFF9E9E9E),
                lineHeight = 16.sp
            )
        }
    }
}
