package ui.components.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.expensetracker.viewmodel.ExpenseViewModel
import model.Expense
import model.ExpenseCategory
import ui.components.CategoryChip

@Composable
fun AddExpenseScreen(viewModel: ExpenseViewModel, onBack: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(ExpenseCategory.FOOD) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Add New Expense", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("What did you buy?") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { if (it.all { char -> char.isDigit() || char == '.' }) amount = it },
            label = { Text("How much?") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        // Simple Category Selection (You can expand this later)
        Text("Select Category", modifier = Modifier.align(Alignment.Start))
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            ExpenseCategory.values().forEach { category ->
                // Using the CategoryChip you built on Day 2!
                Box(modifier = Modifier.clickable { selectedCategory = category }) {
                    CategoryChip(category = category)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (title.isNotEmpty() && amount.isNotEmpty()) {
                    val newExpense = Expense(
                        title = title,
                        amount = amount.toDouble(),
                        date = System.currentTimeMillis(),
                        category = selectedCategory
                    )
                    viewModel.addExpense(newExpense)
                    onBack() // Go back to Home after saving
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Expense")
        }
    }
}