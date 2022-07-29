package com.jane.mypost

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jane.mypost.databinding.ActivityMainBinding
import com.jane.mypost.databinding.DisplayPostItemBinding

class displayPostsRvAdapter(var Context: Context, var displaypost:List<Posts>):
RecyclerView.Adapter<displayPostsRvAdapter.retrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):retrofitViewHolder {
        var binding = DisplayPostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return retrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: displayPostsRvAdapter.retrofitViewHolder, position: Int) {
        var currentPosts = displaypost.get(position)
        holder.binding.tvUserid.text = currentPosts.userId.toString()
        holder.binding.tvId.text = currentPosts.id.toString()
        holder.binding.tvtitle.text = currentPosts.title
        holder.binding.tvBody.text = currentPosts.body

    }

    override fun getItemCount(): Int {
        return displaypost.size
    }
    class retrofitViewHolder(val binding: DisplayPostItemBinding): RecyclerView.ViewHolder(binding.root)

}