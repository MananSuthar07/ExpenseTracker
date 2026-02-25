package model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class ExpenseCategory(
    val title: String,
    val icon: ImageVector,
    val color: Color
) {
    FOOD("Food & Drinks", Icons.Default.Restaurant, Color(0xFFFF9800)),
    TRANSPORT("Transport", Icons.Default.DirectionsCar, Color(0xFF2196F3)),
    SHOPPING("Shopping", Icons.Default.ShoppingBag, Color(0xFFE91E63)),
    ENTERTAINMENT("Fun", Icons.Default.ConfirmationNumber, Color(0xFF9C27B0)),
    BILLS("Utilities", Icons.Default.Receipt, Color(0xFF4CAF50)),
    OTHER("Misc", Icons.Default.Category, Color(0xFF607D8B))
}