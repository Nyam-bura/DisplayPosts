package com.jane.mypost

import android.graphics.PostProcessor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.SurfaceHolder
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jane.mypost.databinding.ActivityMainBinding
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){
        var apiClient = ApiClient.buildApiclient(ApiInterface::class.java)
        var request =  apiClient.getPost()

        request.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(
                call: retrofit2.Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext,"Fetched ${posts!!.size} posts", Toast.LENGTH_LONG)
                        .show()

                    var displayPostsRvAdapter=displayPostsRvAdapter(baseContext,posts)
                    binding.rvDisplay.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvDisplay.adapter = displayPostsRvAdapter

                }
            }

            override fun onFailure(call: retrofit2.Call<List<Posts>>, t: Throwable) {
            }

        })


}}