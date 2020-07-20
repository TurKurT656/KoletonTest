package com.example.koletontest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_test.view.*

class Adp : ListAdapter<Itemm, Adp.Vhl>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Itemm>() {
            override fun areItemsTheSame(oldItem: Itemm, newItem: Itemm): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Itemm, newItem: Itemm): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vhl {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false)
        return Vhl(view)
    }

    override fun onBindViewHolder(holder: Vhl, position: Int) {
        holder.bind(getItem(position))
    }

    class Vhl(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Itemm?) = with(itemView){
            txt_title.text = item?.name
        }

    }
}