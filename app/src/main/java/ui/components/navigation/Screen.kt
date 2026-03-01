package ui.components.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object AddExpense : Screen("add_screen")
}