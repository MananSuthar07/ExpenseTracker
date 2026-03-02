package com.example.expensetracker.viewmodel // Ensure this matches your folder!

import ExpenseRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import model.Expense

// FIXED: Removed the extra 'i' in ExpenseRepository
class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    // 1. Observe all expenses from the database
    val allExpenses: StateFlow<List<Expense>> = repository.allExpenses
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    // 2. Function to save an expense
    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            repository.insert(expense)
        }
    }

    // 3. Function to delete an expense
    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            // FIXED: repository.delete now works because 'repository' type is correct
            repository.delete(expense)
        }
    }
}