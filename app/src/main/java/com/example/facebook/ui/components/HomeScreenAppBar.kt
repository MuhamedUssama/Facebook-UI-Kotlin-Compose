package com.example.facebook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebook.R
import com.example.facebook.core.theme.Black
import com.example.facebook.core.theme.Blue
import com.example.facebook.core.theme.Grey
import com.example.facebook.core.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenAppBar() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabIcons = listOf(
        R.drawable.home,
        R.drawable.reels,
        R.drawable.store,
        R.drawable.profile,
        R.drawable.notification,
        R.drawable.profile_pic
    )

    Column() {
        TopAppBar(
            title = {
                Text(
                    "Facebook",
                    color = Blue,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            actions = {
                IconButton({}) {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "add",
                        tint = Black
                    )
                }
                IconButton({}) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "add",
                        tint = Black
                    )
                }
                IconButton({}) {
                    Icon(
                        painter = painterResource(id = R.drawable.messenger),
                        contentDescription = "add",
                        tint = Black
                    )
                }

            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = White)
        )
        PrimaryTabRow(
            selectedTabIndex = selectedTabIndex,
            contentColor = Blue,
            containerColor = White,
            divider = { HorizontalDivider(color = Grey) },
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(selectedTabIndex),
                    color = Blue
                )
            },
        ) {
            tabIcons.forEachIndexed { index, iconRes ->
                val isSelected = selectedTabIndex == index
                val isProfileTab = iconRes == R.drawable.profile_pic

                Tab(
                    selected = isSelected,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier.padding(8.dp),

                    ) {
                    if (isProfileTab) {
                        Image(
                            painter = painterResource(R.drawable.profile_pic),
                            contentDescription = "profile pic",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = null,
                            tint = if (isSelected) Blue else Grey
                        )
                    }
                }
            }
        }
    }
}