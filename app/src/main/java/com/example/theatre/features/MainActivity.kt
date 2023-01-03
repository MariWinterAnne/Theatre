package com.example.theatre.features

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.theatre.R
import com.example.theatre.databinding.ActivityMainBinding
import com.example.theatre.features.info.presentation.ui.detail.person.PersonDetailViewModel
import com.example.theatre.features.info.presentation.ui.detail.theatre.TheatreDetailViewModel
import com.example.theatre.features.poster.presentation.ui.detail.PosterDetailsViewModel
import com.example.theatre.features.spectacles.presentation.ui.detail.SpectacleDetailsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val spectacleViewModel by viewModel<SpectacleDetailsViewModel>()
    private val theatreViewModel by viewModel<TheatreDetailViewModel>()
    private val personViewModel by viewModel<PersonDetailViewModel>()
    private val posterDetailsViewModel by viewModel<PosterDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigation

        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home,
                R.id.favourite,
                R.id.performance,
                R.id.info
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_home, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_settings -> {
                        val myDialogFragment = DialogFragment()
                        val manager = supportFragmentManager
                        myDialogFragment.show(manager, "myDialog")
                    }
                }
                return true
            }
        })
    }
}