package com.example.newtestgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.newtestgame.databinding.ActivityTitleBinding


class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTitleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.normalModeButton.setOnClickListener{
            startActivity(Intent(this@TitleActivity, MainActivity::class.java))
        }
    }

}