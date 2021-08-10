package com.kodluyoruz.yahnifood.ui.order_history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.yahnifood.databinding.OrderHistoryItemBinding
import com.kodluyoruz.yahnifood.data.entity.OrderFood
import com.kodluyoruz.yahnifood.data.entity.OrdersItem

class OrderHistoryListAdapter : RecyclerView.Adapter<OrderHistoryListAdapter.OrderViewHolder>() {

    private var orderList = ArrayList<OrdersItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val item = orderList[position]
        holder.bind(item)
    }

    fun setDataset(list: ArrayList<OrdersItem>) {
        this.orderList = list
        notifyDataSetChanged()
    }

    class OrderViewHolder(private val binding: OrderHistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: OrdersItem) {

            binding.restaurantNameTV.text = order.id.toString()
            binding.orderRateTv.text = order.id.toString()

        }

        companion object {
            fun from(parent: ViewGroup): OrderViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = OrderHistoryItemBinding.inflate(layoutInflater, parent, false)
                return OrderViewHolder(binding)
            }
        }

    }

    override fun getItemCount(): Int = orderList.size
}