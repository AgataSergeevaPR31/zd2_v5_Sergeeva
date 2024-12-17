package com.example.oclocktravel.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.oclocktravel.R

class DateScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_screen)
    }

    fun login(view: View) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }
    fun images(view: View) {
        val intent = Intent(this, Images::class.java)
        startActivity(intent)
    }
    fun list(view: View) {
        val text2 = intent.getStringExtra("ITEM_TEXT")
        if (text2 != null) {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val currentText = sharedPreferences.getString("ITEM_TEXT", "") ?: ""
            editor.putString("ITEM_TEXT", currentText + text2 + "\n")
            editor.apply()
        }
        val intent = Intent(this, ListScreen::class.java)
        startActivity(intent)
    }

    companion object {
        var text = ""
    }
}