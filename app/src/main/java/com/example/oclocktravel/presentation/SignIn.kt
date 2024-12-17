package com.example.oclocktravel.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.oclocktravel.R

class SignIn : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        login = findViewById(R.id.login)
        pass = findViewById(R.id.pass)
    }

    fun next(view: View) {
        if (login.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
            if (pass.text. toString()== "ects2024" && login.text.toString() == "ects") {
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", login.text.toString())
                editor.putString("password", pass.text.toString())
                editor.apply()
                val intent = Intent(this, DateScreen::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()            }
        }
        else
        {
            Toast.makeText(this, "Заполните оба поля", Toast.LENGTH_SHORT).show()
        }
    }
}