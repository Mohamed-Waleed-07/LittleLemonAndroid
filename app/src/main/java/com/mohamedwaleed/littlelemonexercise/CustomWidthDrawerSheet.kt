package com.mohamedwaleed.littlelemonexercise


import android.annotation.SuppressLint
import android.content.res.Configuration
import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.mohamedwaleed.littlelemonexercise.ui.theme.LittleLemonTheme



@Composable
fun CustomWidthDrawerSheet ( currentScreen : NavDestination? , onHomeScreenClicked : () -> Unit) {

    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.75f) , drawerContainerColor = MaterialTheme.colorScheme.surface ,

    ) {
        DrawerProfileHeader()
        NavigationDrawerItem(
            label = { Text("Home Screen") },
            onClick = {onHomeScreenClicked()} ,
            selected = currentScreen?.hasRoute<Routes.MainRoute>() == true ,
            colors = NavigationDrawerItemDefaults.colors(
                MaterialTheme.colorScheme.secondaryContainer ,
                unselectedContainerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun DrawerProfileHeader(
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_avatar),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Mohamed Waleed",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "mohamedwalidy762@gmail.com",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerProfileHeaderPreview() {
    LittleLemonTheme {
        DrawerProfileHeader()
    }
}

