package com.mohamedwaleed.littlelemonexercise.data

import com.mohamedwaleed.littlelemonexercise.R
data class Dish(
    val id : Int ,
    val title : String ,
    val description : String ,
    val price : Double ,
    val imageRes : Int
)
val menuItems = listOf(
    Dish(
        id = 1 ,
        title = "Greek Salad",
        description = "The famous greek salad of crispy lettuce, peppers, olives, and our Chicago style feta cheese.",
        price = 12.99,
        imageRes = R.drawable.greek_salad
    ),
    Dish(
        id = 2 ,
        title = "Bruschetta",
        description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
        price = 4.99,
        imageRes = R.drawable.bruschetta
    ),
    Dish(
        id = 3 ,
        title = "Lemon Dessert",
        description = "Traditional homemade Italian Lemon Ricotta Cake with a rich layer of cream.",
        price = 8.99,
        imageRes = R.drawable.lemon_dessert
    ),
    Dish(
        id = 4 ,
        title = "Grilled Fish",
        description = "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
        price = 19.99,
        imageRes = R.drawable.grilled_fish
    ),
    Dish(
        id = 5 ,
        title = "Pasta",
        description = "Penne pasta with delicious marinara sauce, fresh basil, and shaved Parmesan cheese.",
        price = 14.99,
        imageRes = R.drawable.pasta
    ),
    Dish(
        id = 6 ,
        title = "Lemonade",
        description = "Freshly squeezed lemons with a hint of mint served ice cold.",
        price = 3.99,
        imageRes = R.drawable.lemonade
    ) ,
    Dish(
        id = 7 ,
        title = "Greek Salad",
        description = "The famous greek salad of crispy lettuce, peppers, olives, and our Chicago style feta cheese.",
        price = 12.99,
        imageRes = R.drawable.greek_salad
    ),
    Dish(
        id = 8 ,
        title = "Bruschetta",
        description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
        price = 4.99,
        imageRes = R.drawable.bruschetta
    ),
    Dish(
        id = 9 ,
        title = "Lemon Dessert",
        description = "Traditional homemade Italian Lemon Ricotta Cake with a rich layer of cream.",
        price = 8.99,
        imageRes = R.drawable.lemon_dessert
    ),
    Dish(
        id = 10 ,
        title = "Grilled Fish",
        description = "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
        price = 19.99,
        imageRes = R.drawable.grilled_fish
    ),
    Dish(
        id = 11 ,
        title = "Pasta",
        description = "Penne pasta with delicious marinara sauce, fresh basil, and shaved Parmesan cheese.",
        price = 14.99,
        imageRes = R.drawable.pasta
    ),
    Dish(
        id = 12 ,
        title = "Lemonade",
        description = "Freshly squeezed lemons with a hint of mint served ice cold.",
        price = 3.99,
        imageRes = R.drawable.lemonade
    )
)
