package com.example.koshelektask

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setTitle(R.string.label_main)

        val spinner: Spinner = findViewById(R.id.currency_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.currency_array_main,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        val bottomNavigationMenu: BottomNavigationView = findViewById(R.id.navigation_main)
        bottomNavigationMenu.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.action_ask -> {
                    Toast.makeText(this, "Ask", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_bind -> {
                    Toast.makeText(this, "Bind", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_difference -> {
                    val intent = Intent(this, DifferenceActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
                    true
                }

                else -> false
            }
        }
    }
}

