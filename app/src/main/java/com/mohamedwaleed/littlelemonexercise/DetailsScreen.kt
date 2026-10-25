package com.mohamedwaleed.littlelemonexercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamedwaleed.littlelemonexercise.data.Dish
import com.mohamedwaleed.littlelemonexercise.ui.theme.LittleLemonTheme
import com.mohamedwaleed.littlelemonexercise.ui.theme.Typography
import java.util.Locale

@Composable
fun DetailsScreen(dishItem: Dish?){
    var unitCounter by remember {
        mutableIntStateOf(1)
    }
    val unitPrice = dishItem?.price ?: 0.0
    val totalPrice = unitPrice * unitCounter
    val formattedTotal = "%.2f".format(totalPrice)
    Surface(color = MaterialTheme.colorScheme.surface) {
        Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.SpaceBetween) {

            Column() {
                Image(painter = painterResource(dishItem?.imageRes ?: R.drawable.ic_launcher_background) , contentDescription = "" , contentScale = ContentScale.Crop ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()){
                    Text(dishItem?.title ?: "Not Found", style = Typography.titleLarge , fontSize = 32.sp)
                    Text("$${dishItem?.price}" , style = Typography.titleLarge , fontSize = 28.sp , modifier = Modifier.padding(horizontal = 16.dp))
                }
                Text(dishItem?.description ?: "Error", style = Typography.bodySmall , fontSize = 18.sp , modifier = Modifier.padding(16.dp))
            }



            Column( modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth() , verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceEvenly) {
                    IconButton(
                        enabled = unitCounter < 25,
                        onClick = {
                            unitCounter++
                        },
                        modifier = Modifier.size(48.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant ,
                            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    Text(text = unitCounter.toString() , fontSize = 42.sp)

                    IconButton( enabled = unitCounter > 1,
                        onClick = {
                            unitCounter--

                        },
                        modifier = Modifier.size(48.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant ,
                            disabledContentColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
                Button(onClick = {

                } , modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {
                    Text("Add for $$formattedTotal" , style = Typography.titleLarge)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    val dishItem =  Dish(
        id = 2 ,
        title = "Bruschetta",
        description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
        price = 4.99,
        imageRes = R.drawable.bruschetta
    )
    LittleLemonTheme() {
        DetailsScreen(dishItem)
    }

}