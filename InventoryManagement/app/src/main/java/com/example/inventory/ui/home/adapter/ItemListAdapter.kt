package com.example.inventory.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.R
import com.example.inventory.data.Item
import com.example.inventory.databinding.ItemListItemBinding
import java.text.NumberFormat
import java.util.*

class ItemListAdapter(
    val items: ArrayList<Item>,
    private val onClickedCallBack: () -> Unit
) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_item, parent, false)
    ) {
        private val binding = ItemListItemBinding.bind(itemView)
        var format: NumberFormat = NumberFormat.getCurrencyInstance().apply {
            maximumFractionDigits = 0
            currency = Currency.getInstance("EUR")
        }

        fun onBind(item: Item, onclick: () -> Unit) {
            with(binding) {
                itemName.text = item.name
                itemPrice.text = format.format(item.price)
                itemQuantity.text = item.quantityInStock.toString()
                itemView.setOnClickListener {
                    onclick
                    // TODO: go to details
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(parent)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.onBind(
        items[position],
        onClickedCallBack
    )

    override fun getItemCount() = items.size
}