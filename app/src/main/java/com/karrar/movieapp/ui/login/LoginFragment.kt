package com.karrar.movieapp.ui.login

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.karrar.movieapp.BuildConfig
import com.karrar.movieapp.R
import com.karrar.movieapp.databinding.FragmentLoginBinding
import com.karrar.movieapp.ui.base.BaseFragment
import com.karrar.movieapp.utilities.Constants
import com.karrar.movieapp.utilities.observeEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val layoutIdFragment = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        observeEvents()
        setTitle(false)
    }


    private fun observeEvents() {
        viewModel.loginEvent.observeEvent(viewLifecycleOwner) {
            if (it == Constants.PROFILE) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToProfileFragment())
            }
        }

        viewModel.signUpEvent.observeEvent(viewLifecycleOwner) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BuildConfig.TMDB_SIGNUP_URL))
            startActivity(browserIntent)
        }
    }
}