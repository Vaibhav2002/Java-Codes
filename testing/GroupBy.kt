package testing

data class Data(
    val ProductID: Int,
    val ProductName: String,
    val ProductQuantity: Int,
    val ProductUnitPoints: Int
)

val sampleList = (0..5).map { Data(ProductID = it % 2, ProductQuantity = it, ProductUnitPoints = 0, ProductName = "") }

fun main() {
    val finalList = sampleList.groupBy { it.ProductID }.map { data ->
        Data(
            ProductID = data.key,
            ProductName = data.value[0].ProductName,
            ProductQuantity = data.value.sumBy { it.ProductQuantity },
            ProductUnitPoints = data.value[0].ProductUnitPoints
        )
    }
    print(finalList)
}
