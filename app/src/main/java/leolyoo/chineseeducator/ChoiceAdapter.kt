package leolyoo.chineseeducator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ChoiceAdapter(private val quizViewModel: QuizViewModel) :
    RecyclerView.Adapter<ChoiceAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val choiceButton: Button = view.findViewById(R.id.button_choice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_choice, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.choiceButton.text = quizViewModel.tmpChoices[position]
        holder.choiceButton.setOnClickListener {
            quizViewModel.choose(position)
        }
    }

    override fun getItemCount(): Int = quizViewModel.tmpChoices.size

}