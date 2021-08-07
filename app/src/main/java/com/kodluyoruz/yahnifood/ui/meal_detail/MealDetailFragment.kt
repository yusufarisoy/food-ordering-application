package com.kodluyoruz.yahnifood.ui.meal_detail

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckedTextView
import android.widget.ListView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.kodluyoruz.yahnifood.R
import com.kodluyoruz.yahnifood.data.entity.Menu
import com.kodluyoruz.yahnifood.databinding.FragmentMealDetailBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.skydoves.expandablelayout.ExpandableLayout
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class MealDetailFragment : BaseFragment() {
    private lateinit var binding: FragmentMealDetailBinding
    private lateinit var expandableLayout: ExpandableLayout
    private lateinit var listView :ListView
    private lateinit var menu : Menu
    private lateinit var bitmap :Bitmap
    private val args: MealDetailFragmentArgs by navArgs()
    private val viewModel : MealDetailViewModel by viewModels()
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
        amountListener()
        viewModel.amount.observe(viewLifecycleOwner, Observer {
            Log.v("Tag",it.toString())
            binding.foodPrice.text = "${it * menu.price}"
            binding.textView3.text = "${it} Adet"
        })
        binding.shareMeal.setOnClickListener {
            share()
            Log.v("Tag","clicked")
        }
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
        binding.name.text = menu.name
        binding.ingredients.text = menu.ingredients
        binding.foodPrice.text = menu.price.toString()
        Glide.with(binding.root).load(menu.photo_url).into(binding.imageView)
        binding.submit.setOnClickListener {
            findNavController().navigate(R.id.action_mealDetailFragment_to_mealAddingFragment)
        }

    }
    fun amountListener(){
        binding.increase.setOnClickListener {
            viewModel.addAmount()
        }
        binding.decrease.setOnClickListener {
            viewModel.decreaseAmount()
        }
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
                        //putExtra(Intent.EXTRA_TEXT, "${menu.name} \n ${menu.price} \n ${menu.photo_url}")
                    }
                    startActivity(Intent.createChooser(shareIntent, "Send to"))
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
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

