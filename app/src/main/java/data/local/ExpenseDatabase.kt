package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import model.Expense

@Database(entities = [Expense::class], version = 1, exportSchema = false)
@TypeConverters(CategoryConverters::class)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}