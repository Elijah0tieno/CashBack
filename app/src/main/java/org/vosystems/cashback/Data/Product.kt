package org.vosystems.cashback.Data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.text.NumberFormat
import java.util.Date
//
//@Entity(tableName = "product")
//data class Product (
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//    @ColumnInfo(name = "productName")
//    val productName: String,
//    @ColumnInfo(name = "productSize")
//    val productSize: String,
//    @ColumnInfo(name = "productDate")
//    val productDate: String,
//    @ColumnInfo(name = "productImage")
//    val productImage: String,
//    @ColumnInfo(name = "productCom")
//    val productCom: Double,
//    @ColumnInfo(name = "productCashBack")
//    val productCashBack: Double
//        )

data class Product(
    val id: Int,
    val productName: String,
    val productSize: String,
    val productDate: String,
    val productImage: String,
    val productCom: Double,
    val productCashBack: Double) {

    data class ProductInfo(
        @SerializedName("_id")
        val id: Int
    )


}



