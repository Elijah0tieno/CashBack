package org.vosystems.cashback.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.vosystems.cashback.Data.Product
import org.vosystems.cashback.Data.ProductDao
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.vosystems.cashback.Data.ProductRoomDatabase.Companion.getDatabase

class ProductViewModel(private val productDao: ProductDao): ViewModel() {


    fun insertProduct(product: Product){
        GlobalScope.launch {
            getDatabase(this).productDao().insertProduct(
                product
            )
        }
    }


}

//factory class to instantiate view model instance
class ProductViewModelFactory(private val productDao: ProductDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(productDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
        return super.create(modelClass)

    }
}