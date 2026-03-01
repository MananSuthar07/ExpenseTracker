package data.local

import androidx.room.TypeConverter
import model.ExpenseCategory

class CategoryConverters {
    @TypeConverter
    fun fromString(value: String): ExpenseCategory {
        return ExpenseCategory.valueOf(value)
    }

    @TypeConverter
    fun fromCategory(category: ExpenseCategory): String {
        return category.name
    }
}
