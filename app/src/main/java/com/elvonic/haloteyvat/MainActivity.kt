package com.elvonic.haloteyvat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    private lateinit var rvCharacters: RecyclerView
    private var  list: ArrayList<Character> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle("Penduduk Teyvat")

        rvCharacters = findViewById(R.id.rv_characters)
        rvCharacters.setHasFixedSize(true)

        list.addAll(CharactersData.listData)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_me, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val move = Intent(this@MainActivity, AboutMe::class.java)
        startActivity(move)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvCharacters.layoutManager = LinearLayoutManager(this)
        val listCharacterAdapter = ListCharacterAdapter(list)
        rvCharacters.adapter = listCharacterAdapter

        listCharacterAdapter.setOnItemClickDetail(object : ListCharacterAdapter.OnItemClickDetail{
            override fun onItemClicked(data: Character) {
                showCharacterDetail(data)
            }

        })
    }

    private fun showCharacterDetail(character : Character) {
        val move = Intent(this@MainActivity, DetailCharacter::class.java)
        move.putExtra(DetailCharacter.EXTRA_CHARACTER, character)
        startActivity(move)
    }

     private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}