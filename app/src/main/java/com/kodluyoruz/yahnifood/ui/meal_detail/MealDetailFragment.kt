package com.kodluyoruz.yahnifood.ui.meal_detail

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.data.entity.Menu
import com.kodluyoruz.yahnifood.data.entity.OrderFood
import com.kodluyoruz.yahnifood.data.entity.dtos.OrderDto
import com.kodluyoruz.yahnifood.databinding.FragmentFoodDetailBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.skydoves.expandablelayout.ExpandableLayout
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MealDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var expandableLayout: ExpandableLayout
    private lateinit var listView :ListView
    private lateinit var menu : Menu
    private val args: MealDetailFragmentArgs by navArgs()
    private val viewModel : MealDetailViewModel by viewModels()
    private lateinit var orderFood : OrderFood
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListView()
        quantityListener()
        viewModel.amount.observe(viewLifecycleOwner, Observer {
            binding.foodPrice.text = "${it * menu.price} TL"
            binding.foodQuantity.text = "${it} Adet"
            orderFood = OrderFood(menu.food_id,2,it)
        })
        val builder = VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
    }
    fun initViews(){
        menu = args.clickedFood
        expandableLayout = binding.expandable
        expandableLayout.parentLayout.setOnClickListener{
            if(expandableLayout.isExpanded){
                expandableLayout.collapse()
            }
            else{
                expandableLayout.expand()
            }
        }
        binding.shareMeal.setOnClickListener {
            share()
        }
        binding.name.text = menu.name
        binding.ingredients.text = menu.ingredients
        binding.foodPrice.text = menu.price.toString()
        Glide.with(binding.root).load(menu.photo_url).into(binding.foodImageView)
        val sdf = SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
        val currentDateandTime: String = sdf.format(Date())
        binding.submit.setOnClickListener {
                val orderList = ArrayList<OrderFood>()
                orderList.add(orderFood)
                val order = OrderDto(currentDateandTime,binding.mealOrderNote.editText?.text.toString(),orderList,args.restaurantId,3,viewModel.getToken())
                viewModel.postOrder(order).observe(viewLifecycleOwner,{
                    Toast.makeText(requireContext(),"You ordered succesfully",Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                })
        }
    }
    //updates the quantity in viewModel by listening the - and + button
    fun quantityListener(){
        binding.increase.setOnClickListener {
            viewModel.addAmount()
        }
        binding.decrease.setOnClickListener {
            viewModel.decreaseAmount()
        }
    }
    // creates the expandable list view
    fun initListView(){
        listView = expandableLayout.secondLayout.findViewById(R.id.ingredientsListView)
        val list = args.clickedFood.ingredients.split(",")
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
    // shares the image,name and price of the meal
    fun share(){
        Glide.with(this)
            .asBitmap()
            .load(menu.photo_url)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    val shareIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        type = "image/*"
                        putExtra(Intent.EXTRA_STREAM,getLocalBitmapUri(resource))
                        putExtra(Intent.EXTRA_TEXT,"${menu.name} \nPrice:${menu.price}TL")
                    }
                    startActivity(Intent.createChooser(shareIntent, "Send to"))
                }
                override fun onLoadCleared(placeholder: Drawable?) {

                }
            })
    }
    fun getLocalBitmapUri(bmp: Bitmap): Uri? {
        var bmpUri: Uri? = null
        try {
            val file: File = File(
                requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "share_image_" + System.currentTimeMillis() + ".png"
            )
            val out = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out)
            out.close()
            bmpUri = Uri.fromFile(file)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bmpUri
    }
}

