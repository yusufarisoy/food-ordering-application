package com.kodluyoruz.yahnifood.ui.home

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.databinding.RestaurantListItemBinding
import com.kodluyoruz.yahnifood.ui.home.onDetail

class RestaurantRecyclerViewAdapter(/*val restViewModel:ViewModel?,*/ private val restaurantList:ArrayList<RestaurantsItem>, val context: Context,val onClick: onDetail):RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RestaurantViewHolder>() {


    fun updateRestaurantList(itemList:ArrayList<RestaurantsItem>){
        this.restaurantList.clear()
        this.restaurantList.addAll(itemList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val root: RestaurantListItemBinding =
            RestaurantListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return RestaurantViewHolder(root).listen{
            position, type ->
            onClick.click(position)
        }
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurantList[position])
    }

    override fun getItemCount(): Int {
        if(restaurantList.isEmpty()){
        }
        return restaurantList.size
    }

    inner class RestaurantViewHolder(private val binding: RestaurantListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: RestaurantsItem){
            binding.restaurantRemainTimeTextview.text = "${item.average_delivery_time} dk"
            binding.restaurantMinPriceTextview.text = "${item.min_order} TL"
            binding.restaurantPointTextview.text = item.point!!.toDouble().toString()

            var alphaVal:Double = 1.0
            var colorCode:String = "#81BF4A"

            if (item.point!!>3){
                alphaVal = item.point?.toDouble()?.div(5.0) ?: 1.0
            }
            else{
                colorCode = "#FF6347"
            }
            binding.restaurantPointCard.setCardBackgroundColor(Color.parseColor(colorCode))
            binding.restaurantPointCard.alpha = alphaVal.toFloat()
            binding.restaurantNameEdittext.text = item.name

        }

    }
    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

}