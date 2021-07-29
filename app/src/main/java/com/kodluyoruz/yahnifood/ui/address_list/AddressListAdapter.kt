package com.kodluyoruz.yahnifood.ui.address_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.yahnifood.IMealOnClick
import com.kodluyoruz.yahnifood.databinding.AddressListItemBinding
import com.kodluyoruz.yahnifood.models.Address

class AddressListAdapter : RecyclerView.Adapter<AddressListAdapter.AddressViewHolder>() {

    private var addressList = ArrayList<Address>()
    private var listener : IMealOnClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]
        holder.bind(item,listener)
    }

    fun setDataset(list: ArrayList<Address>) {
        this.addressList = list
        notifyDataSetChanged()
    }
    fun addListener(listener: IMealOnClick) {
        this.listener = listener
    }

    class AddressViewHolder(private val binding: AddressListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(address: Address, listener: IMealOnClick?) {

            /// view binding işlemleri

        }

        companion object {
            fun from(parent: ViewGroup): AddressViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AddressListItemBinding.inflate(layoutInflater, parent, false)
                return AddressViewHolder(binding)
            }
        }

    }

    override fun getItemCount(): Int = addressList.size
}