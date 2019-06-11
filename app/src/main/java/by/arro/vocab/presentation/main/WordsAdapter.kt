package by.arro.vocab.presentation.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.arro.vocab.R
import by.arro.vocab.domain.entity.Word
import kotlinx.android.synthetic.main.item_word.view.*

class WordsAdapter(context: Context, val onItemClicked: (Int) -> Unit) : RecyclerView.Adapter<WordViewHolder>() {
    private val inflater = LayoutInflater.from(context)

    private val items = mutableListOf<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = inflater.inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view, onItemClicked)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, posution: Int) {
        holder.updateWith(items[posution])
    }

    fun update(newItems: List<Word>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class WordViewHolder(
        itemView: View,
        onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var model: Word? = null

    init {
        itemView.setOnClickListener {
            model?.let { model ->
                onItemClicked(model.id)
            }
        }
    }

    fun updateUI() {
        model?.apply {
            itemView.tvEnWord.text = enValue
            itemView.tvRuWord.text = ruValue
        }
    }

    fun updateWith(newModel: Word) {
        model = newModel
        updateUI()
    }
}
