package sc.fruity.data

data class Fruit(
    val name: String,
    val id: Long,
    val family: String,
    val order: String,
    val genus: String,
    val nutritions: Nutritions,
)

data class Nutritions(
    val calories: Long,
    val fat: Double,
    val sugar: Double,
    val carbohydrates: Double,
    val protein: Double,
)