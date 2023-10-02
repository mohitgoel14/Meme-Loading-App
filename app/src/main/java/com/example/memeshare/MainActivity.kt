package com.example.memeshare


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request

import com.android.volley.toolbox.JsonObjectRequest

import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.memeshare.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.memeImageView
        loadMeme()
    }

    private fun loadMeme(){

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"

        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                var url = response.getString("url")
                val memeImageView : ImageView = findViewById(R.id.memeImageView)
                Glide.with(this).load(url).into(memeImageView)
            },
            {
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_LONG).show()
            })
        queue.add(stringRequest)
    }
    fun shareMeme() {
    }
    fun nextMeme() {
        loadMeme()
    }
}