package com.example.newtestgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.newtestgame.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //正解数を取得する
        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)

        //〇ライフの値を引っ張ってくる
        val life = intent.getIntExtra("nowlife",3)

        //TextViewに表示させる
        binding.resultLabel.text = getString(R.string.result_score, score)

        //〇ライフが無くなったことを表示する
        if (life == 0){
            findViewById<TextView>(R.id.lifetext).setVisibility(View.VISIBLE);
        }

        //「もう一度」ボタン
        binding.tryAgainBtn.setOnClickListener{
            startActivity(Intent(this@ResultActivity, TitleActivity::class.java))
        }

    }
}