package com.mohamedwaleed.littlelemonexercise

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mohamedwaleed.littlelemonexercise.ui.theme.LittleLemonTheme
import com.mohamedwaleed.littlelemonexercise.ui.theme.Typography

@Composable
fun UpperPanel(){
    Surface(modifier = Modifier.fillMaxWidth().height(320.dp) , color = MaterialTheme.colorScheme.primaryContainer) {
        Column(Modifier.fillMaxWidth() , verticalArrangement = Arrangement.spacedBy(9.dp)) {

            Text(text = stringResource(R.string.hero_title),
                style = Typography.displayLarge ,
                modifier = Modifier.padding(top = 8.dp , start = 8.dp)
            )

            Text(text = stringResource(R.string.hero_subtitle) ,
                style = Typography.headlineMedium ,
                modifier = Modifier.padding(start = 8.dp)
            )

            Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween ,
                verticalAlignment = Alignment.Top){

                Text(text = stringResource(R.string.hero_description) , style = Typography.bodyMedium ,
                    modifier = Modifier.weight(1f))

                AsyncImage(model = R.drawable.hero_image ,
                    contentDescription = "Hero Image" ,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Button(onClick = {} ,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = stringResource(R.string.hero_cta) , style = Typography.labelLarge)
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    LittleLemonTheme {
        UpperPanel()
    }
}
