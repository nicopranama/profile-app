package com.example.profile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.navigation.NavigationManager
import com.example.profile.ui.components.PaginationButtons

@Composable
fun Page2Screen(navigationManager: NavigationManager) {
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
            text = "Page 2",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Education Card
        Card(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Title
                Text(
                    text = "Education",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // University
                InfoCard(
                    title = "University",
                    content = "Binus University"
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Major
                InfoCard(
                    title = "Major",
                    content = "Computer Science"
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Year
                InfoCard(
                    title = "Year",
                    content = "2023 - 2027"
                )
            }
        }

        // Pagination Buttons
        PaginationButtons(navigationManager = navigationManager)
    }
}

@Composable
private fun InfoCard(
    title: String,
    content: String
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A90E2),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = content,
            fontSize = 15.sp,
            color = Color(0xFFE0E0E0),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
    }
}