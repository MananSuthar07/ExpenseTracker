package ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.expensetracker.viewmodel.ExpenseViewModel
import ui.components.screens.AddExpenseScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ExpenseViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(onNavigateToAdd = {
                navController.navigate(Screen.AddExpense.route)
            })
        }
        composable(route = Screen.AddExpense.route) {
            AddExpenseScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}