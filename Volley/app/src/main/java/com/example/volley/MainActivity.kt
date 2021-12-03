package com.example.volley

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volley.databinding.ActivityMainBinding
import com.example.volley.reqres.User
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var user: JSONArray? = null
    val userList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        binding.rwUser.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rwUser.adapter = UserAdapter(this@MainActivity, userList)


    }

    fun get() {
        val url = "https://reqres.in/api/users"
        val req = StringRequest(
            Request.Method.GET,
            url,
            { res ->
                Log.e("RESPONSE", res)
                try {
                    val jsonObject = JSONObject(res)
                    val data = jsonObject.getJSONArray("data")

                    Log.e("DATA", data.toString())

                    for (i in 0 until data.length()) {
                        Log.e("SPEC DATA", data.getJSONObject(i).get("email").toString())
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            },
            { it.printStackTrace() })

        Volley.newRequestQueue(this).add(req)

    }

    fun getData(): JSONArray? {
        val url = "https://reqres.in/api/users"
        var data: JSONArray? = null

        val req = StringRequest(
            Request.Method.GET,
            url,
            { res ->
                try {
                    val jsonObject = JSONObject(res)
                    data = jsonObject.getJSONArray("data")
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                data?.let {
                    for (i in 0 until data!!.length()) {
                        val id = data!!.getJSONObject(i)?.get("id").toString().toInt()
                        val email = data!!.getJSONObject(i)?.get("email").toString()
                        val firstName = data!!.getJSONObject(i)?.get("first_name").toString()
                        val lastName = data!!.getJSONObject(i)?.get("last_name").toString()
                        val avatar = data!!.getJSONObject(i)?.get("avatar").toString()

                        Log.e("main", data!!.get(i).toString())
                        userList.add(i, User(id, firstName, lastName, email, avatar))
                    }
                }
            },
            { it.printStackTrace() })
        Volley.newRequestQueue(this@MainActivity).add(req)
        binding.rwUser.adapter = UserAdapter(this@MainActivity, userList)

        return data
    }

}