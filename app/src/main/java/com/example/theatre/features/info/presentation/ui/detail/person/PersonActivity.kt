/*
 * Copyright (c) 2018. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.theatre.features.info.presentation.ui.detail.person

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.theatre.R
import com.example.theatre.databinding.ActivityEventBinding
import com.example.theatre.features.info.presentation.adapters.PersonPagerAdapter
import com.example.theatre.network.net.RetrofitClient
import com.example.theatre.features.info.presentation.ui.list.person.PersonViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonActivity : AppCompatActivity() {

    lateinit var binding: ActivityEventBinding
    private val spectacleViewModel by viewModel<PersonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        val personId = bundle?.getInt("person_id")
        lifecycleScope.launchWhenCreated {
            spectacleViewModel.init()
            try {
                val persons = personId?.let { RetrofitClient.retrofit.getPersonById(it) }

                with(binding.content) {
                    when(persons?.agentType){
                        "person" -> { textPrice.text = "Деятель" }
                        "organization" -> { textPrice.text = "Организация" }
                    }
                    textName.text = persons?.title?.replaceFirstChar { it.uppercaseChar() }
                    Picasso.get()
                        .load(persons?.images?.get(0)?.image.toString())
                        .into(imageThumbnail)
                    Picasso.get()
                        .load(persons?.images?.get(0)?.image.toString())
                        .into(binding.imageLarge)
                }
            } catch (e: Throwable) {
                Toast.makeText(
                    baseContext,
                    "Ошибка получения данных.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val viewPager = binding.content.viewPager
        viewPager.adapter = personId?.let { PersonPagerAdapter(supportFragmentManager) }

        val tabLayout = binding.content.tabs
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> finish()
            R.id.action_event -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/"))
                startActivity(browserIntent)
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
