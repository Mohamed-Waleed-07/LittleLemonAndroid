package com.mohamedwaleed.littlelemonexercise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mohamedwaleed.littlelemonexercise.data.categories
import com.mohamedwaleed.littlelemonexercise.data.menuItems
import com.mohamedwaleed.littlelemonexercise.ui.theme.LittleLemonTheme
import com.mohamedwaleed.littlelemonexercise.ui.theme.Typography
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentScreen = backStackEntry?.destination


            LittleLemonTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState , drawerContent = {
                        CustomWidthDrawerSheet( currentScreen){
                            navController.navigate(Routes.MainRoute){
                                launchSingleTop = true
                            }
                        }
                    }
                ) {
                    Scaffold(topBar = {
                        ToolAppBar{
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                    }) {
                            paddingValues ->
                        AppNavigation(paddingValues , navController)
                    }
                }



            }


        }
    }
}

@Composable
fun MainScreen( onDishItemClicked : (Int) -> Unit) {

        Surface(color = MaterialTheme.colorScheme.surface) {
            LazyColumn {
                item{
                    UpperPanel()
                }
                stickyHeader {

                    Surface(modifier = Modifier
                        .fillMaxWidth(),
                        color = MaterialTheme.colorScheme.surface
                    ) {
                        Column(Modifier.padding(6.dp)) {
                            Text("Weekly Special" , style = Typography.titleLarge , fontSize = 24.sp)
                            CategoryChipRow(categories = categories)
                        }

                    }

                }

                items(menuItems ,
                    key = {dish -> dish.id},
                    contentType = { "DishCard" }){
                        dish -> DishCard(dish , onClicked = {
                        itemId -> onDishItemClicked(itemId)
                })
                }

            }
        }

}

@Composable
fun AppNavigation(paddingValues: PaddingValues , navController: NavHostController){


    NavHost(navController = navController ,
        startDestination = Routes.MainRoute ,
        modifier = Modifier.padding(paddingValues)
    ){

        composable<Routes.MainRoute>(
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ){
            BackHandler {
                navController.popBackStack()
            }
            MainScreen {
                itemId ->
                navController.navigate(Routes.DetailsRoute(itemId))
            }
        }
        composable<Routes.DetailsRoute> (
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)

                )
            } ,
            popExitTransition = {
                slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right ,
                    animationSpec = tween(durationMillis = 300 , easing = FastOutLinearInEasing))
            }
        ){ backStackEntry ->
            BackHandler{
                navController.popBackStack()
            }
            Log.d("NavAnimation", "Details destination composed")
            val route = backStackEntry.toRoute<Routes.DetailsRoute>()
            val navigatedDish = menuItems.firstOrNull { it.id == route.dishId }

                DetailsScreen(navigatedDish)

        }
    }
}


