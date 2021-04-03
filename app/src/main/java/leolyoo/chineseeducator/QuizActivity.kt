package leolyoo.chineseeducator

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuizActivity : AppCompatActivity() {
    private lateinit var lifeTextView: TextView
    private lateinit var remainingTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var meaningTextView: TextView
    private lateinit var choiceAdapter: ChoiceAdapter
    private var viewModel = QuizViewModel(
        { initViews() },
        {
            if (it) Toast.makeText(this, "Good!", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Bad...", Toast.LENGTH_SHORT).show()
        },
        {
            if (it) {
                Toast.makeText(this, "Pass!", Toast.LENGTH_SHORT).show()
                if (QuizCookie.isExam) {
                    val sharedPref =
                        getSharedPreferences(
                            getStagePrefKey(QuizCookie.stage),
                            Context.MODE_PRIVATE
                        )
                    with(sharedPref.edit()) {
                        putString(getStagePrefKey(QuizCookie.stage), getDate())
                        apply()
                    }
                }
            } else Toast.makeText(this, "Fail...", Toast.LENGTH_SHORT).show()
            finish()
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        lifeTextView = findViewById(R.id.text_life)
        remainingTextView = findViewById(R.id.text_remaining)
        questionTextView = findViewById(R.id.text_question)
        meaningTextView = findViewById(R.id.text_meaning)
        choiceAdapter = ChoiceAdapter(viewModel)
        findViewById<RecyclerView>(R.id.list_choices).also {
            it.adapter = choiceAdapter
            it.layoutManager = LinearLayoutManager(this)
        }

        viewModel.reset()
    }

    private fun initViews() {
        lifeTextView.text = getString(R.string.life, viewModel.life)
        questionTextView.text = viewModel.tmpQuestion
        meaningTextView.text = viewModel.tmpMeaning
        remainingTextView.text = getString(R.string.remaining, viewModel.remaining)
        choiceAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        QuizCookie.stage = 0
        super.onDestroy()
    }
}