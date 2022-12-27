package com.marina.binlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marina.binlist.databinding.CardItemBinding
import com.marina.binlist.presentation.entity.card.CardInfoUI

class CardAdapter :
    ListAdapter<CardInfoUI, CardAdapter.CardItemViewHolder>(CardDiffUtilCallback()) {

    var onCardItemClick: ((CardInfoUI) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder {
        val binding = CardItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        val card = getItem(position)
        with(holder) {
            binding.tvCardBin.text = card.bin
            itemView.setOnClickListener {
                onCardItemClick?.invoke(card)
            }
        }
    }

    class CardItemViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    class CardDiffUtilCallback : DiffUtil.ItemCallback<CardInfoUI>() {
        override fun areItemsTheSame(oldItem: CardInfoUI, newItem: CardInfoUI): Boolean {
            return oldItem.bin == newItem.bin
        }

        override fun areContentsTheSame(oldItem: CardInfoUI, newItem: CardInfoUI): Boolean {
            return oldItem == newItem
        }

    }
}