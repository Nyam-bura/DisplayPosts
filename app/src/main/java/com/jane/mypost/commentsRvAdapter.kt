package com.jane.mypost

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jane.mypost.databinding.ActivityCommentsBinding

class commentsRvAdapter (var currentlist:List<Comment>): RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding = ActivityCommentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment = currentlist.get(position)

        with(holder.bindingView){
            tvposttitle.text= currentComment.body
            tvpostbody.text = currentComment.name

        }

    }

    override fun getItemCount(): Int {
        return currentlist.size
    }
}
class CommentViewHolder(var bindingView: ActivityCommentsBinding):RecyclerView.ViewHolder(bindingView.root)