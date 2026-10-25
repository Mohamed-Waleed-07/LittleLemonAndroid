package com.mohamedwaleed.littlelemonexercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ToolAppBar(onNavigationMenuClicked : () -> Unit){
    Surface( modifier = Modifier.statusBarsPadding().fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween , verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                onNavigationMenuClicked()
            }) {
                Image(painter = painterResource(R.drawable.naviagation_menu) ,
                    contentDescription = "profile icon" ,
                    modifier = Modifier.size(24.dp)

                )
            }

            Image(painterResource(R.drawable.little_lemon_logo) ,
                contentDescription = "little lemon logo" ,
                modifier = Modifier.padding(vertical = 8.dp).height(40.dp),
                contentScale = ContentScale.Fit
            )

            IconButton(onClick = {}) {
                Image( painter = painterResource(R.drawable.icon_shopping  ) ,
                    contentDescription = "cart add icon" ,
                    modifier = Modifier.size(24.dp)
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){

}