package leolyoo.chineseeducator

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val dataSet: List<Word>) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterTextView: TextView = view.findViewById(R.id.text_word_character)
        val pronunciationTextView: TextView = view.findViewById(R.id.text_word_pronunciation)
        val meaningTextView: TextView = view.findViewById(R.id.text_word_meaning)
        val writeButton: ImageButton = view.findViewById(R.id.button_write)
        val speechButton: ImageButton = view.findViewById(R.id.button_speech)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet[position]
        holder.characterTextView.text = data.character
        holder.pronunciationTextView.text = data.pronunciation
        holder.meaningTextView.text = data.meaning
        holder.writeButton.setOnClickListener {
            val intent = Intent(holder.writeButton.context, WriteActivity::class.java)
            intent.putExtra(EXTRA_GIF, data.gif)
            ContextCompat.startActivity(holder.writeButton.context, intent, null)
        }
        holder.speechButton.setOnClickListener { TTS.speech(data.character) }
    }
}