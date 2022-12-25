package com.marina.binlist.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marina.binlist.R
import com.marina.binlist.presentation.fragment.InfoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, InfoFragment.newInstance())
            .commit()
    }
}