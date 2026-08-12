package com.example.facebook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebook.R
import com.example.facebook.core.theme.Black
import com.example.facebook.core.theme.Blue
import com.example.facebook.core.theme.White

@Composable
fun StorySection() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 16.dp)
    ) {
        items(10) { index ->
            if (index == 0) CreateStoryItem() else StoryItem()
        }
    }
}

@Composable
fun StoryItem() {
    Box(
        modifier = Modifier
            .width(132.dp)
            .height(212.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.yamal),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(R.drawable.messi),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(56.dp)
                .padding(8.dp)
                .clip(CircleShape)
                .border(1.5.dp, Blue, CircleShape),
        )
    }
}

@Composable
fun CreateStoryItem() {
    Box(
        modifier = Modifier
            .width(132.dp)
            .height(212.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column {
            Image(
                painter = painterResource(R.drawable.profile_pic),
                contentDescription = "profile pic",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "Create a\nStory",
                color = Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(7.5f))
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = White,
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Blue)
            )
            Spacer(modifier = Modifier.weight(2.5f))

        }
    }
}