package com.elvonic.haloteyvat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        setActionBarTitle("About Me")

        // enable back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}