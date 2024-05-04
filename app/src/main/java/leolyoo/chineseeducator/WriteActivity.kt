package leolyoo.chineseeducator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class WriteActivity : AppCompatActivity() {
    private class PaintView(context: Context) : View(context) {
        private data class Point(var x: Float, var y: Float, var check: Boolean, var color: Int)

        val points = ArrayList<Point>()
        private val paint = Paint()
        val color = Color.BLACK

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            paint.strokeWidth = 4F
            for (i in 1 until points.size) {
                paint.color = points[i].color
                if (!points[i].check)
                    continue
                canvas?.drawLine(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y, paint)
            }
        }

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> points.add(Point(event.x, event.y, false, color))
                MotionEvent.ACTION_MOVE -> points.add(Point(event.x, event.y, true, color))
                MotionEvent.ACTION_UP -> performClick()
            }
            invalidate()
            return true
        }

        override fun performClick(): Boolean {
            Log.d(javaClass.name, "performClick()")
            return super.performClick()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        val gif = intent.getIntExtra(EXTRA_GIF, R.raw.gif_error)

        val paintView = PaintView(this)
        findViewById<GridLayout>(R.id.view_paint).addView(paintView)

        val gifImageView: ImageView = findViewById(R.id.image_gif)
        Glide.with(this).load(gif).into(gifImageView)

        findViewById<Button>(R.id.button_clear).setOnClickListener {
            paintView.points.clear()
            paintView.invalidate()
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}