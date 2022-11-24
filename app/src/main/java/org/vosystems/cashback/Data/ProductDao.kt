package org.vosystems.cashback.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Query("SELECT * from product ORDER BY productDate ASC")
//    fun getProducts(): Flow<List<Product>>
    fun getProducts():
            LiveData<List<Product>>

    @Query("SELECT * from product WHERE id = :id")
    fun getProduct(id: Int): Flow<Product>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(product: Product)
}