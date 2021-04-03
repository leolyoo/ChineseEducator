package leolyoo.chineseeducator

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RelativeLayout

class StageButton(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    var stageIndex = 0

    init {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.button_stage, this, false).also {
            addView(it)
        }

        context.theme.obtainStyledAttributes(attrs, R.styleable.StageButton, 0, 0).apply {
            try {
                stageIndex = getInt(R.styleable.StageButton_indexStage, 0)
                findViewById<Button>(R.id.button).text =
                    context.getString(R.string.stage, stageIndex)
            } finally {
                recycle()
            }
        }
    }

    fun setOnStageClickListener(listener: (stageIndex: Int) -> Unit) {
        findViewById<Button>(R.id.button).setOnClickListener {
            listener.invoke(stageIndex)
        }
    }
}