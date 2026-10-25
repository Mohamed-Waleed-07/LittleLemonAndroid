package com.mohamedwaleed.littlelemonexercise

import kotlinx.serialization.Serializable

interface Routes {
    @Serializable
    data object MainRoute : Routes
    @Serializable
    data class DetailsRoute(
        val dishId : Int
    ) : Routes
}