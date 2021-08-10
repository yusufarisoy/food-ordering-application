package com.kodluyoruz.yahnifood.ui.meal_adding

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.kodluyoruz.yahnifood.data.entity.Address
import com.kodluyoruz.yahnifood.data.entity.Menu
import com.kodluyoruz.yahnifood.data.entity.Owner
import com.kodluyoruz.yahnifood.data.entity.RestaurantsItem
import com.kodluyoruz.yahnifood.databinding.FragmentMealAddingBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.ui.meal_detail.MealDetailFragmentArgs
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException


@AndroidEntryPoint
class MealAddingFragment: BaseFragment() {
    private lateinit var image : ImageView
    private lateinit var binding : FragmentMealAddingBinding
    private val viewModel: MealAddingViewModel by viewModels()
    var selectedImage: Bitmap? = null
    var imageData: Uri? = null
    private val args: MealAddingFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealAddingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        image.setOnClickListener {
            if (checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            } else {
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intentToGallery, 2)
            }
        }


    }
    fun initViews(){
        image = binding.mealPhoto
        binding.addMeal.setOnClickListener {
            val restaurantsItem = args.restaurant
            val ingredients = binding.mealIngredientsEditText.editText?.text.toString()
            val name = binding.mealNameEditText.editText?.text.toString()
            val price = binding.mealPriceEditText.editText?.text.toString()
            val doublePrice = price.toDouble()
            val menu = Menu(2,ingredients,name,"https://www.livashop.com/Uploads/UrunResimleri/buyuk/karisik-pizza-e7f8.jpg",doublePrice)
            var list : ArrayList<Menu> = ArrayList<Menu>(restaurantsItem.menu)
            list.add(menu)
            restaurantsItem.menu = list
            viewModel.addMeal(restaurantsItem.id.toString(),restaurantsItem).observe(viewLifecycleOwner, object:Observer<Resource<RestaurantsItem>>{
                override fun onChanged(t: Resource<RestaurantsItem>?) {
                    when(t?.status){
                        Resource.Status.ERROR -> Log.v("Tag",t.message!!)
                        Resource.Status.SUCCESS ->{
                            Log.v("Tag","${t.data?.menu?.size}")
                        }
                    }
                }

            })
        }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.size > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intentToGallery, 2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

     override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            imageData = data.data
            Log.v("Tag",imageData.toString())

            try {
                selectedImage = if (Build.VERSION.SDK_INT >= 28) {
                    val source: ImageDecoder.Source =
                        ImageDecoder.createSource(requireActivity().contentResolver, imageData!!)
                    ImageDecoder.decodeBitmap(source)
                } else {
                    MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, imageData)
                }
                image.setImageBitmap(selectedImage)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun addMeal(){

    }


}