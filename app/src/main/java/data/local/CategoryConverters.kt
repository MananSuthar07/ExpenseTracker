import androidx.room.TypeConverter
import model.ExpenseCategory

class CategoryConverters {
    @TypeConverter
    fun fromCategory(category: ExpenseCategory): String {
        return category.name
    }

    @TypeConverter
    fun toCategory(category: String): ExpenseCategory {
        return ExpenseCategory.valueOf(category)
    }
}