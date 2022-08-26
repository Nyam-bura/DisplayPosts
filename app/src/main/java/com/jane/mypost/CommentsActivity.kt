package com.jane.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jane.mypost.databinding.ActivityCommentsBinding
import com.jane.mypost.databinding.DisplayPostItemBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Obtainposts()
        fetchPostsById()
        FetchComments()
    }
    fun Obtainposts(){
        postId = intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostsById(){
        var apiclient = ApiClient.buildApiclient(ApiInterface::class.java)
        var request = apiclient.getpostsById(postId)

        request.enqueue(object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvpostbody.text =post?.body
                    binding.tvposttitle.text = post?.title
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }
    fun FetchComments(){
        var apiclient = ApiClient.buildApiclient(ApiInterface::class.java)
        var request = apiclient.getCommentsId()

        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful){
                    var comment = response.body()
                    if (comment!=null)
                        displaycomment(comment)
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                var baseContext = null
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }


        })
    }
    fun displaycomment(commentList: List<Comment>){
        binding.rvcomments.layoutManager=LinearLayoutManager(this)
        var commentRvAdapter = commentsRvAdapter(commentList)
        binding.rvcomments.adapter = commentRvAdapter
    }




    }


