package com.example.oclocktravel.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.room.Room
import com.example.oclocktravel.R

class ListScreen : AppCompatActivity() {
    private lateinit var listContainer: LinearLayout
    private lateinit var database: AppDatabase
    private val items = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_screen)
        listContainer = findViewById(R.id.listContainer)
        database = Room.databaseBuilder(this, AppDatabase::class.java, "app_database").allowMainThreadQueries().build()
        loadItemsFromDatabase()
        updateList()
    }

    private fun loadItemsFromDatabase() {
        val itemList = database.itemDao().getAll()
        items.clear()
        for (item in itemList) {
            if (!items.contains(item.name)) {
                items.add(item.name)
            }
        }
    }

    private fun updateList() {
        listContainer.removeAllViews() // Очищаем контейнер перед обновлением
        for (item in items) {
            val textView = TextView(this)
            textView.text = item
            textView.setTextColor(resources.getColor(android.R.color.black))
            textView.textSize = 18f
            listContainer.addView(textView)
        }
    }

    fun date(view: View) {
        val intent = Intent(this, DateScreen::class.java)
        startActivity(intent)
    }
}