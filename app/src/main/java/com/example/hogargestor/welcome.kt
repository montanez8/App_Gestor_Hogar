package com.example.hogargestor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, ToDoFragment::class.java, null,"todo")
        }

    }
}