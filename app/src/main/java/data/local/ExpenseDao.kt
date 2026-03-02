/**
 * LAYER: DATA (LOCAL)
 * ROLE: The "Librarian".
 * PURPOSE: Handles the raw SQL/SQLite commands.
 * This file is the only one allowed to talk directly to the Database.
 */

package data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense_table ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT SUM(amount) FROM expense_table")
    fun getTotalAmount(): Flow<Double?>
}