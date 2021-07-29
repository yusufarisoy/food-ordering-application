package com.kodluyoruz.yahnifood.ui.meal_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import android.widget.ListView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.databinding.FragmentMealDetailBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.skydoves.expandablelayout.ExpandableLayout

class MealDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentMealDetailBinding
    private lateinit var expandableLayout: ExpandableLayout
    private lateinit var listView :ListView
    val args: MealDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListView()
    }
    fun initViews(){
        val menu = args.clickedFood
        expandableLayout = binding.expandable
        expandableLayout.parentLayout.setOnClickListener{
            if(expandableLayout.isExpanded){
                expandableLayout.collapse()
            }
            else{
                expandableLayout.expand()
            }

        }
        binding.name.text = menu.name
        binding.ingredients.text = menu.ingredients
        binding.foodPrice.text = menu.price.toString()
        Glide.with(binding.root).load(menu.photo_url).into(binding.imageView)

    }
    fun initListView(){
        listView = expandableLayout.secondLayout.findViewById(R.id.ingredientsListView)
        val list = ArrayList<String>()
        list.add("Köfte")
        list.add("Turşu")
        list.add("Marul")
        list.add("Ketçap")
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_multiple_choice,
            list
        )
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id -> // change the checkbox state
                val checkedTextView = view as CheckedTextView
                checkedTextView.isChecked = !checkedTextView.isChecked
            }
    }
}