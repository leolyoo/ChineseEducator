package leolyoo.chineseeducator

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StageAdapter(private val context: Context, private val data: Array<Map<String, String>>) :
    RecyclerView.Adapter<StageAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text)
        val videoButton: Button = view.findViewById(R.id.button_video)
        val part1Button: Button = view.findViewById(R.id.button_part_1)
        val part2Button: Button = view.findViewById(R.id.button_part_2)
        val testButton: Button = view.findViewById(R.id.button_test)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_stage, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]["text"]
        holder.part1Button.setOnClickListener {
            Intent(context, PartActivity::class.java).apply {

            }
        }
        holder.part2Button.setOnClickListener {  }
        holder.testButton.setOnClickListener {  }

    }

    override fun getItemCount() = data.size
}