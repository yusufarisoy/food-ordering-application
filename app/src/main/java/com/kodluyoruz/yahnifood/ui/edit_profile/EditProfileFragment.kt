package com.kodluyoruz.yahnifood.ui.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kodluyoruz.yahnifood.data.entity.UsersItem
import com.kodluyoruz.yahnifood.databinding.FragmentEditProfileBinding
import com.kodluyoruz.yahnifood.ui.base.BaseFragment
import com.kodluyoruz.yahnifood.ui.home.HomeFragmentArgs
import com.kodluyoruz.yahnifood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileFragment : BaseFragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModels()
    private lateinit var user: UsersItem
    //private var token = HomeFragmentArgs.fromBundle(requireArguments()).token

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
        val name = binding.textInputEditName.text.toString()
        val surname = binding.textInputEditSurname.text.toString()
        val email = binding.textInputEditEmail.text.toString()
        val phone = binding.textInputEditPhone.text.toString()
        val ppURL = binding.textInputEditPPURL.text.toString()


        viewModel.getUser(user_id = 1).observe(viewLifecycleOwner,{
            when(it.status){

                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    /*user.name = name
                    user.surname = surname
                    user.email = email
                    user.phone_number = phone
                    user.photo_url = ppURL*/

                    //nameTextView.text = name
                    //Toast.makeText(context, user.name, Toast.LENGTH_LONG).show()
                }
                Resource.Status.ERROR -> {

                }

            }
        })

        binding.buttonChangePasswordNavigation.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToChangePasswordFragment())
        }
        binding.buttonUpdateProfile.setOnClickListener {
            findNavController().navigate(EditProfileFragmentDirections.actionEditProfileFragment2ToProfileFragment2())
        }
    }
}