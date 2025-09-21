package com.example.profile.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.R
import com.example.profile.navigation.NavigationManager
import com.example.profile.ui.components.PaginationButtons
import androidx.core.net.toUri

@Composable
fun Page1Screen(navigationManager: NavigationManager) {
    val context = LocalContext.current
    val instagramUrl = "https://www.instagram.com/nico.pranama?igsh=MTNpbGk1cTlmdDF6MQ=="
    val linkedinUrl = "https://www.linkedin.com/in/nico-pranama-5ba689318/"

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
            text = "Page 1",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Profile Card
        Card(
            modifier = Modifier
                .width(280.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2D2D2D)),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Profile Image
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp),
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    ),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                // Content section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Name
                    Text(
                        text = "Nico Pranama Hadi",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Description
                    Text(
                        text = "Computer Science student who focuses on backend development",
                        fontSize = 14.sp,
                        color = Color(0xFF9E9E9E),
                        textAlign = TextAlign.Start,
                        lineHeight = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Social media links
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        SocialMediaButton(
                            text = "Instagram",
                            modifier = Modifier.weight(1f)
                        ) {
                            val intent = Intent(Intent.ACTION_VIEW, instagramUrl.toUri())
                            context.startActivity(intent)
                        }

                        SocialMediaButton(
                            text = "LinkedIn",
                            modifier = Modifier.weight(1f)
                        ) {
                            val intent = Intent(Intent.ACTION_VIEW, linkedinUrl.toUri())
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }

        // Pagination Buttons
        PaginationButtons(navigationManager = navigationManager)
    }
}

@Composable
private fun SocialMediaButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(36.dp)
            .background(
                color = Color(0xFF404040),
                shape = RoundedCornerShape(18.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}
