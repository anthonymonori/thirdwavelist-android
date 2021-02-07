package com.thirdwavelist.coficiando.splash.presentation

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.thirdwavelist.coficiando.navigation.NavigationFlow
import com.thirdwavelist.coficiando.navigation.NavigationOrchestrator
import com.thirdwavelist.coficiando.splash.R
import com.thirdwavelist.coficiando.splash.SplashFragmentBinding

class SplashFragment : Fragment() {

    private lateinit var binding: SplashFragmentBinding

    private var onLottieAnimationListener: Animator.AnimatorListener? = object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) = Unit
        override fun onAnimationEnd(animation: Animator?) = navigateToHome()
        override fun onAnimationCancel(animation: Animator?) = navigateToHome()
        override fun onAnimationRepeat(animation: Animator?) = Unit
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_splash, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.animationView.addAnimatorListener(onLottieAnimationListener)
    }

    override fun onDestroyView() {
        onLottieAnimationListener = null
        super.onDestroyView()
    }

    private fun navigateToHome() = (requireActivity() as NavigationOrchestrator).navigateToFlow(NavigationFlow.HomeFlow)
}