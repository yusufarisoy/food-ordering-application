package com.kodluyoruz.yahnifood.ui.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.databinding.FragmentEditProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModels()
    private lateinit var user: UsersItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }
    private fun initViews() {
        //edittext
        var name = binding.textInputEditName
        var surname = binding.textInputEditSurname
        var email = binding.textInputEditEmail
        var phoneNumber = binding.textInputEditPhone
        var ppUrl = binding.textInputEditPPURL

        val token = viewModel.getToken()
        viewModel.getUserWithId(token).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    name.setText(it.data?.get(0)?.name)
                    surname.setText(it.data?.get(0)?.surname)
                    email.setText(it.data?.get(0)?.email)
                    phoneNumber.setText(it.data?.get(0)?.phone_number)
                    ppUrl.setText(it.data?.get(0)?.photo_url)
                }
                Resource.Status.ERROR -> {

                }
            }
        })

        binding.buttonChangePasswordNavigation.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToChangePasswordFragment())
        }
        //UPDATE PROFILE
        binding.buttonUpdateProfile.setOnClickListener {

            //updateProfile()

            Toast.makeText(context,"Profile updated!",Toast.LENGTH_LONG).show()
            //findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToProfileFragment2())
            findNavController().popBackStack()
        }
    }
    /*private fun updateProfile(){
        var name = binding.textInputEditName
        var surname = binding.textInputEditSurname
        var email = binding.textInputEditEmail
        var phoneNumber = binding.textInputEditPhone
        var ppUrl = binding.textInputEditPPURL

        val token = viewModel.getToken()
        viewModel.updateUser(token.toString(),user).observe(viewLifecycleOwner,object:Observer<Resource<UsersItem>>{
            override fun onChanged(t: Resource<UsersItem>?) {
                when(t?.status){

                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        *//*it.data?.get(0)?.name = name.text.toString()
                        it.data?.get(0)?.surname = surname.text.toString()
                        it.data?.get(0)?.email = email.text.toString()
                        it.data?.get(0)?.phone_number = phoneNumber.text.toString()
                        it.data?.get(0)?.photo_url = ppUrl.text.toString()*//*

                        t?.data?.name = name.text.toString()
                    }
                    Resource.Status.ERROR -> {

                    }
                }
            }
        })
    }*/
}