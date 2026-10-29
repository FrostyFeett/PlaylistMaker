package com.example.split3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.split3.ui.theme.Split3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT))
        setContent {
            Split3Theme {
                MainScreen(
                    onSearchClick = {
                        startActivity(Intent(this, SearchActivity::class.java))
                    },
                    onSettingsClick = {
                        startActivity(Intent(this, SettingsActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(onSearchClick: () -> Unit, onSettingsClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF3772E6))
            .statusBarsPadding()
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .navigationBarsPadding()
                .padding(top = 8.dp)
        ) {
            MenuButton(stringResource(R.string.search), R.drawable.ic_search, onSearchClick)
            MenuButton(stringResource(R.string.playlists), R.drawable.ic_playlists) {
                // Экран плейлистов появится в следующих заданиях.
            }
            MenuButton(stringResource(R.string.favorites), R.drawable.ic_favorite) {
                // Экран избранного появится в следующих заданиях.
            }
            MenuButton(stringResource(R.string.settings), R.drawable.ic_settings, onSettingsClick)
        }
    }
}

@Composable
fun MenuButton(title: String, icon: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(68.dp)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = Color(0xFF1A1B22),
            modifier = Modifier.size(24.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text(text = title, fontSize = 22.sp, color = Color(0xFF1A1B22))
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.ic_chevron),
            contentDescription = null,
            tint = Color(0xFFAEAFB4),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Split3Theme {
        MainScreen(onSearchClick = {}, onSettingsClick = {})
    }
}
