package com.kodluyoruz.yahnifood.ui.address_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.databinding.AddressListItemBinding
import com.kodluyoruz.yahnifood.data.entity.Address

class AddressListAdapter : RecyclerView.Adapter<AddressListAdapter.AddressViewHolder>() {

    private var addressList = ArrayList<Address>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]
        holder.bind(item)
    }

    fun setDataset(list: ArrayList<Address>) {
        this.addressList = list
        notifyDataSetChanged()
    }



    class AddressViewHolder(private val binding: AddressListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(address: Address) {

            binding.addressDetailTV.text = address.address
            binding.addressDistrictTV.text = address.district
            binding.addressTitleTV.text = address.title
            binding.addressIconIV.setImageResource(R.drawable.outline_home)

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