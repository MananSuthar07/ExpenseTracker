/**
 * LAYER: REPOSITORY
 * ROLE: The "Middleman" / "Buffer".
 * PURPOSE: Abstracts the data source.
 * The ViewModel asks the Repo for data, and the Repo decides where to get it.
 */

import data.local.ExpenseDao
import kotlinx.coroutines.flow.Flow
import model.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val allExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()
    val totalAmount: Flow<Double?> = expenseDao.getTotalAmount()

    suspend fun insert(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    suspend fun delete(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }
}