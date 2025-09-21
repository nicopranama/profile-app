package com.example.profile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile.navigation.NavigationManager

@Composable
fun PaginationButtons(navigationManager: NavigationManager) {
    val pageInfo = navigationManager.getCurrentPageInfo()

    if (pageInfo != null && pageInfo.availablePages.isNotEmpty()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            pageInfo.availablePages.forEach { pageNumber ->
                PaginationButton(
                    text = "$pageNumber",
                    modifier = Modifier.weight(1f),
                    onClick = { navigationManager.navigateToPage(pageNumber) }
                )
            }
        }
    }
}

@Composable
private fun PaginationButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .background(
                color = Color(0xFF4A90E2),
                shape = RoundedCornerShape(24.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}