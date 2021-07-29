package com.kodluyoruz.yahnifood.ui.restaurant_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kodluyoruz.yahnifood.IMealOnClick
import com.kodluyoruz.yahnifood.databinding.FoodListRecyclerItemBinding
import com.kodluyoruz.yahnifood.models.Menu

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var foodList = ArrayList<Menu>()
    private var listener : IMealOnClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = foodList[position]
        holder.bind(item,listener)
    }

    fun setDataset(list: ArrayList<Menu>) {
        this.foodList = list
        notifyDataSetChanged()
    }
    fun addListener(listener: IMealOnClick) {
        this.listener = listener
    }

    class FoodViewHolder(private val binding: FoodListRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Menu,listener: IMealOnClick?) {
            Glide.with(binding.root).load(food.photo_url).into(binding.imageViewFood)
            binding.textViewFoodName.text = food.name
            binding.textViewFoodIngredients.text = food.ingredients
            binding.textViewFoodPrice.text = food.price.toString()
            binding.foodCardView.setOnClickListener {
                listener?.onClick(food)
            }

        }

        companion object {
            fun from(parent: ViewGroup): FoodViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FoodListRecyclerItemBinding.inflate(layoutInflater, parent, false)
                return FoodViewHolder(binding)
            }
        }

    }

    override fun getItemCount(): Int = foodList.size
}