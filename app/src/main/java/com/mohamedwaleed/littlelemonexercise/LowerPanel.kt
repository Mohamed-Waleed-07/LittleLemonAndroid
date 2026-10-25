package com.mohamedwaleed.littlelemonexercise

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mohamedwaleed.littlelemonexercise.data.Dish
import com.mohamedwaleed.littlelemonexercise.ui.theme.Typography



@Composable
fun CategoryFilterChip(
    categoryName : String ,
    isSelected : Boolean ,
    onChipClicked : () -> Unit ,
    modifier: Modifier = Modifier
){
    FilterChip(selected = isSelected , onClick = {onChipClicked()} , label = { Text(categoryName) }
    , colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant
    ) , shape = CircleShape , border = null
        )

}
@Preview
@Composable
fun CategoryFilterChipPreview(){
    CategoryFilterChip(
        "Main Dish" ,
        false ,
        onChipClicked = {}
    )
}

@Composable
fun CategoryChipRow(
    categories : List<String>
){

    var selectedCategory by remember { mutableStateOf<String?>(null) }
    val currentContext = LocalContext.current

    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {

        items(categories){

            category ->
                val isSelected : Boolean =  selectedCategory == category
                CategoryFilterChip(
                    categoryName = category ,
                    isSelected = isSelected,
                    onChipClicked = {
                        if (isSelected){
                            selectedCategory = null
                        }
                        else{
                            selectedCategory = category
                            Toast.makeText(currentContext , "$category is selected !" , Toast.LENGTH_SHORT).show()

                        }

                    }
                    )
        }
    }
}

@Composable
fun DishCard(dish : Dish , onClicked : (Int) -> Unit , modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClicked(dish.id)
        }) {
        Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier.fillMaxWidth()){
            Column(modifier = Modifier
                .weight(1f)
                .padding(8.dp)) {
                Text(text = dish.title , style = Typography.titleLarge )
                Text(text = dish.description ,  style = Typography.bodySmall)
                Text(text = "$${dish.price}" ,  style = Typography.titleMedium)
            }
            AsyncImage(dish.imageRes
                , contentDescription = dish.title ,
                placeholder = ColorPainter(Color(0xFFEEEEEE)),
                contentScale = ContentScale.Crop
                , modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(100.dp))
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.primary , modifier = Modifier.padding(vertical = 4.dp))

    }
}



