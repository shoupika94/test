package com.example.newtestgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newtestgame.databinding.ActivityFailureBinding

class FailureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFailureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result)
        binding = ActivityFailureBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //正解数を取得する
        //val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)

        //TextViewに表示させる
       // binding.resultLabel.text = getString(R.string.result_score, score)

        //「もう一度」ボタン
        binding.tryAgainBtn1.setOnClickListener{
            startActivity(Intent(this@FailureActivity, MainActivity::class.java))
        }

    }
}