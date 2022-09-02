package com.example.newtestgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.newtestgame.databinding.ActivityMainBinding
import com.example.newtestgame.databinding.ActivityTitleBinding


import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var rightAnswer : String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    //〇今のライフの設定をする
    private var nowlife = 3
    //クイズの出題数　
    private val QUIZ_COUNT = 5


    private val quizData = mutableListOf(
        mutableListOf("北海道", "札幌市", "長崎市", "福島市", "前橋市"),
        mutableListOf("青森県", "青森市", "広島市", "甲府市", "岡山市"),
        mutableListOf("岩手県", "盛岡市", "大分市", "秋田市", "福岡市"),
        mutableListOf("宮城県", "仙台市", "水戸市", "岐阜市", "福井市"),
        mutableListOf("秋田県", "秋田市", "横浜市", "鳥取市", "仙台市"),
        mutableListOf("山形県", "山形市", "青森市", "山口市", "奈良市"),
        mutableListOf("福島県", "福島市", "盛岡市", "新宿区", "京都市"),
        mutableListOf("茨城県", "水戸市", "金沢市", "名古屋市", "奈良市"),
        mutableListOf("栃木県", "宇都宮市", "札幌市", "岡山市", "奈良市"),
        mutableListOf("群馬県", "前橋市", "福岡市", "松江市", "福井市")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        quizData.shuffle()

        showNewtQuiz()

        val textView : TextView = binding.life
        val countLabel : TextView = binding.countLabel
        val questionLabel : TextView = binding.questionLabel
        val answerBtn1 : Button = binding.ansBtn1
        val answerBtn2 : Button = binding.ansBtn2
        val answerBtn3 : Button = binding.ansBtn3
        val answerBtn4 : Button = binding.ansBtn4
    }

    //クイズの出題
    fun showNewtQuiz(){
        //〇ライフの表示
        binding.life.text = "残りライフ：${nowlife}"

        //カウントラベルの更新
        binding.countLabel.text = getString(R.string.count_label, quizCount)

        //クイズを1問取り出す
        val quiz = quizData[0]

        //問題をセットする
        binding.questionLabel.text = quiz[0]

        //正解をセットする
        rightAnswer = quiz[1]

        //タイトルを削除
        quiz.removeAt(0)

        //正解と選択肢3つをシャッフルする
        quiz.shuffle()

        //正解と選択肢をセットする
        binding.ansBtn1.text = quiz[0]
        binding.ansBtn2.text = quiz[1]
        binding.ansBtn3.text = quiz[2]
        binding.ansBtn4.text = quiz[3]

        //出題したクイズの削除
        quizData.removeAt(0)
    }

    //解答ボタンが押されたら呼ばれる
    fun checkAnswer(view: View){
        //どのボタンが押されたか
        val ansBtn: Button = findViewById(view.id)
        val btnText = ansBtn.text.toString()

        //ダイアログのタイトルを作成
        val alartTitle: String
        //もし正解なら
        if (btnText == rightAnswer){
            alartTitle = "正解！"
            rightAnswerCount++
        }
        //誤っていたら
        else{
            alartTitle = "不正解..."
            nowlife--
        }

        //ダイアログの作成
        AlertDialog.Builder(this)
            .setTitle(alartTitle)
            .setMessage("答え : $rightAnswer")
            .setPositiveButton("次へ"){ dialogInterface, i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()
    }

    //出題数をチェックする or 〇ライフがいくつあるかをチェックする
    fun checkQuizCount(){
        if ((quizCount == QUIZ_COUNT)||(nowlife == 0)){
            //結果を表示
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            intent.putExtra("nowlife",nowlife)
            startActivity(intent)

        }

        else{
            quizCount++
            showNewtQuiz()
        }
    }

}