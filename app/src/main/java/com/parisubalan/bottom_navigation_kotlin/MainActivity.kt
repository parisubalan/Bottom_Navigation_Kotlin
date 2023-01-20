package com.parisubalan.bottom_navigation_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.parisubalan.bottom_navigation_kotlin.databinding.ActivityMainBinding
import com.parisubalan.bottom_navigation_kotlin.fragments.ChatFragment
import com.parisubalan.bottom_navigation_kotlin.fragments.HomeFragment
import com.parisubalan.bottom_navigation_kotlin.fragments.ProfileFragment
import com.parisubalan.bottom_navigation_kotlin.fragments.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialization()
    }

    private fun initialization() {
        replaceFragment(HomeFragment.getInstance("Home Screen"))
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment.getInstance("Home Screen"))
                    true
                }
                R.id.chat -> {
                    replaceFragment(ChatFragment.getInstance("Chat Screen"))
                    true
                }
                R.id.settings->{
                    replaceFragment(SettingFragment.getInstance("Settings Screen"))
                    true
                }
                R.id.profile->{
                    replaceFragment(ProfileFragment.getInstance("Profile Screen"))
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.plusBtn.setOnClickListener {
            Toast.makeText(this,"You are click plus icon",Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaceFragment(fragmentName: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainContainer, fragmentName)
        transaction.commitNow()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}