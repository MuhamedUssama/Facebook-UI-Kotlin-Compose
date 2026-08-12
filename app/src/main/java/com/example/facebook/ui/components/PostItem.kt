package com.example.facebook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebook.R
import com.example.facebook.core.theme.Black
import com.example.facebook.core.theme.Grey


@Composable
fun PostItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.route_logo),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                Text("Route", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Black)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("8h", color = Grey, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Public, contentDescription = "", tint = Grey,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "",
                tint = Black,
                modifier = Modifier.size(24.dp),
            )
        }
        Image(
            painter = painterResource(
                R.drawable.route_post,
            ),
            contentDescription = "",
        )
        Row(modifier = Modifier.padding(horizontal = 12.dp)) {
            Icon(
                painter = painterResource(R.drawable.love),
                contentDescription = "",
                tint = Black
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                painter = painterResource(R.drawable.comment),
                contentDescription = "",
                tint = Black
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                painter = painterResource(R.drawable.share),
                contentDescription = "",
                tint = Black
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.bookmark),
                contentDescription = "",
                tint = Black
            )
        }
    }
}