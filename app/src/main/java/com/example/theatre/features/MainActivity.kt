package com.example.theatre.features

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.theatre.R
import com.example.theatre.databinding.ActivityMainBinding
import com.example.theatre.features.favourite.FavoriteFragment
import com.example.theatre.features.poster.presentation.ui.detail.PosterFragment
import com.example.theatre.features.info.presentation.ui.InfoFragment
import com.example.theatre.features.spectacles.presentation.ui.list.SpectaclesFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val fragment = PosterFragment()
                    loadFragment(fragment)
                }
                R.id.favourite -> {
                    val fragment = FavoriteFragment()
                    loadFragment(fragment)
                }
                R.id.performance -> {
                    val fragment = SpectaclesFragment()
                    loadFragment(fragment)
                }
                R.id.info -> {
                    val fragment = InfoFragment()
                    loadFragment(fragment)
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fragment, "Fragment")
            .addToBackStack("Fragment")
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                val myDialogFragment = DialogFragment()
                val manager = supportFragmentManager
                myDialogFragment.show(manager, "myDialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}