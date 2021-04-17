package leolyoo.chineseeducator

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener: (indexStage: Int) -> Unit = {
            val sharedPref = getSharedPreferences(getStagePrefKey(it), Context.MODE_PRIVATE)

            showStageDialog(it, getClearDate(sharedPref, it))
        }
        findViewById<StageButton>(R.id.button_stage_01).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_02).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_03).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_04).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_05).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_06).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_07).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_08).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_09).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_10).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_11).setOnStageClickListener(listener)
        findViewById<StageButton>(R.id.button_stage_12).setOnStageClickListener(listener)
    }

    private fun getClearDate(sharedPref: SharedPreferences, indexStage: Int): String {
        return sharedPref.getString(getStagePrefKey(indexStage), "") ?: ""
    }

    private fun showStageDialog(indexStage: Int, clearDate: String) {
        AlertDialog.Builder(this).apply {
            var items = arrayOf("소개", "PART 1", "PART 2", "종합퀴즈")
            if (clearDate != "") items = items.plus("클리어 [$clearDate]")
            setTitle(getString(R.string.stage, indexStage))
            setItems(items) { _, which ->
                when (which) {
                    0 -> {
                    }
                    1 -> {
                        PartCookie.init(indexStage, 1)
                        startActivity(Intent(context, PartActivity::class.java))
                    }
                    2 -> {
                        PartCookie.init(indexStage, 2)
                        startActivity(Intent(context, PartActivity::class.java))
                    }
                    3 -> {
                        QuizCookie.initExam(indexStage)
                        startActivity(Intent(context, QuizActivity::class.java))
                    }
                }
            }
        }.show()
    }
}