package leolyoo.chineseeducator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SentenceAdapter(private val dataSet: List<Sentence>) :
    RecyclerView.Adapter<SentenceAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterTextView: TextView = view.findViewById(R.id.text_sentence_character)
        val pronunciationTextView: TextView = view.findViewById(R.id.text_sentence_pronunciation)
        val meaningTextView: TextView = view.findViewById(R.id.text_sentence_meaning)
        val speechButton: ImageButton = view.findViewById(R.id.button_speech)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sentence, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet[position]
        holder.characterTextView.text = data.character
        holder.pronunciationTextView.text = data.pronunciation
        holder.meaningTextView.text = data.meaning
        holder.speechButton.setOnClickListener { TTS.speech(data.character) }
    }
}