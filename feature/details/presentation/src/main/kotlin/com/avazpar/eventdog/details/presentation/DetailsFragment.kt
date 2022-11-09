package com.avazpar.eventdog.details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avazpar.designsystem.foundations.EventdogTheme

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                EventdogTheme {
                    DetailsScreen(
                        handleNavigation = ::handleNavigation
                    )
                }
            }
        }
    }

    private fun handleNavigation(navigation: DetailsNavigation) {
        when (navigation) {
            DetailsNavigation.ToBack -> findNavController().popBackStack()
        }
    }
}