package com.parisubalan.bottom_navigation_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.parisubalan.bottom_navigation_kotlin.R
import com.parisubalan.bottom_navigation_kotlin.databinding.FragementLayBinding

object ChatFragment : Fragment() {

    lateinit var binding: FragementLayBinding

    fun getInstance(screenName : String?): ChatFragment {
        var fragment = ChatFragment
        var bundle = Bundle()
        bundle.putString("screenName", screenName)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragement_lay, container, false)
        binding = FragementLayBinding.bind(view)
        initUI()
        return view
    }

    private fun initUI() {
        if (arguments != null) {
            var bundle = arguments
            binding.tvScreenName.text = bundle!!.getString("screenName")
        }
    }
}