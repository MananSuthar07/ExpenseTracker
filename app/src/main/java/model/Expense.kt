/**
 * LAYER: MODEL
 * ROLE: The "Blueprint".
 * PURPOSE: Defines what an object looks like.
 * If you want to add a new field (like 'Location'), start here.
 */

package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "expense_table")
data class Expense(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(), // Generates a unique ID automatically
    val title: String,
    val amount: Double,
    val date: Long, // We store dates as Long (Timestamps) for easy database sorting
    val category: ExpenseCategory // Room can store this with a "Converter" (Day 3)
)