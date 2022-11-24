package org.vosystems.cashback.Adapters

import android.content.ClipData
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.vosystems.cashback.Data.Product
import org.vosystems.cashback.Data.ProductApiClient
import org.vosystems.cashback.databinding.ViewProductBinding


class ProductListAdapter(val context: Context) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    val client by lazy { ProductApiClient.create() }
    var products: ArrayList<Product> = ArrayList()

    fun refreshProducts() {
        client.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                products.clear()
                products.addAll(result.list.movies)
                notifyDataSetChanged()
            },{ error ->
                Toast.makeText(context, "Refresh error: ${error.message}", Toast.LENGTH_LONG).show()
                Log.e("ERRORS", error.message)
            })
    }


    class ProductViewHolder(private var binding: ViewProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                title.text = product.productName
                cashBack.text = product.productCashBack.toString()
                com.text = product.productCom.toString()
                size.text = product.productSize
                date.text = product.productDate


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ViewProductBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener{
            onItemClicked(current)
        }
        holder.bind(current)
    }

    companion object{
        private val DiffCallback = object  : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productName == newItem.productName
            }
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}