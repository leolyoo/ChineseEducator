package leolyoo.chineseeducator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part)

        findViewById<RecyclerView>(R.id.recycler_sentence).also {
            it.adapter = SentenceAdapter(PartCookie.requestSentences())
            it.layoutManager = LinearLayoutManager(this)
        }

        findViewById<RecyclerView>(R.id.recycler_word).also {
            it.adapter = WordAdapter(PartCookie.requestWords())
            it.layoutManager = LinearLayoutManager(this)
        }

        findViewById<Button>(R.id.button_word_quiz).setOnClickListener {
            QuizCookie.initWord()
            startActivity(Intent(this, QuizActivity::class.java))
        }

        findViewById<Button>(R.id.button_blank_quiz).setOnClickListener {
            QuizCookie.initBlank()
            startActivity(Intent(this, QuizActivity::class.java))
        }

        findViewById<Button>(R.id.button_arrange_quiz).setOnClickListener {
            QuizCookie.initArrange()
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}