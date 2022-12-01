package com.example.sunrinsocialnetwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunrinsocialnetwork.data.Data

class MainFragmentAdapter : ListAdapter<Data, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    class DiffUtilCallback : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean = oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(
            oldItem: Data,
            newItem: Data
        ): Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: Data) {
            val content = itemView.findViewById<TextView>(R.id.textBoardItemContent)
            val nickname = itemView.findViewById<TextView>(R.id.textBoardItemProfile)
            val tag = itemView.findViewById<TextView>(R.id.textBoardItemTag)
            val image = itemView.findViewById<ImageView>(R.id.imageBoardItem)
            content.text = item.text
            nickname.text = item.user.username
            val tags = item.tags.split(",")
            tag.text = ""
            for(i in tags) {
                if(i.isNotBlank()) {
                    tag.text = "${tag.text} #$i"
                }
            }
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .centerCrop()
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_board,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(getItem(position))
    }

}