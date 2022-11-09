package com.avazpar.eventdog.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avazpar.designsystem.foundations.EventdogTheme

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                EventdogTheme {
                    HomeScreen(
                        handleNavigation = ::handleNavigation
                    )
                }
            }
        }
    }

    private fun handleNavigation(navigation: HomeNavigation) {
        when (navigation) {
            HomeNavigation.ToDetails -> Unit//findNavController().navigate(HomeFragmentDirections.actionToDetails())
        }
    }
}