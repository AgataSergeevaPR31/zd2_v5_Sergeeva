package com.example.oclocktravel.presentation

import android.app.ListActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.room.Room
import com.example.oclocktravel.R

class Images : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var backroom: LinearLayout
    private lateinit var hell: LinearLayout
    private lateinit var space: LinearLayout
    private lateinit var btnAdd: Button
    private lateinit var database: AppDatabase
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        // Инициализация компонентов
        editText = findViewById(R.id.editText)
        btnAdd = findViewById(R.id.btnAdd)
        backroom = findViewById(R.id.backroom)
        hell = findViewById(R.id.hell)
        space = findViewById(R.id.space)

        database = Room.databaseBuilder(this, AppDatabase::class.java, "app_database").allowMainThreadQueries().build()
        sharedPreferences = getSharedPreferences("smart_watch_prefs", Context.MODE_PRIVATE)

        btnAdd.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isNotEmpty()) {
                saveToSharedPreferences("ITEM_TEXT", text)
                val item = Item(name = text)
                database.itemDao().insert(item)
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }
        }
        backroom.setOnClickListener {
                saveToSharedPreferences("ITEM_TEXT", "Бэкрум")
                val item = Item(name = "Бэкрум")
                database.itemDao().insert(item)
        }

        hell.setOnClickListener {
            saveToSharedPreferences("ITEM_TEXT", "Тартар")
            val item = Item(name = "Тартар")
            database.itemDao().insert(item)
        }

        space.setOnClickListener {
            saveToSharedPreferences("ITEM_TEXT", "Космос")
            val item = Item(name = "Космос")
            database.itemDao().insert(item)
        }
    }

    private fun saveToSharedPreferences(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun date(view: View) {
        val intent = Intent(this, DateScreen::class.java)
        startActivity(intent)
    }
}