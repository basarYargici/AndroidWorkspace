package com.example.volley

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volley.databinding.ActivityMainBinding
import com.example.volley.reqres.ReqType
import com.example.volley.reqres.User
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val userList: MutableList<User> = mutableListOf()
    lateinit var queue: RequestQueue
    private val TAG: String = "VOLLEY_REQUEST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queue = Volley.newRequestQueue(this)
        binding.rwUser.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rwUser.adapter = UserAdapter(this@MainActivity, userList)

        getData()
        deleteUser(1)
        postUser("test", "software engineer")
    }

    private fun getData(): JSONArray? {
        val url = "https://reqres.in/api/users"
        var data: JSONArray? = null

        val req = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { res ->
                try {
                    data = res.getJSONArray("data")
                    jsonParse(data, ReqType.GET)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { it.printStackTrace() })
        queue.add(req)
        return data
    }

    private fun deleteUser(id: Int): Boolean {
        val url = "https://reqres.in/api/users"
        val req = StringRequest(
            Request.Method.DELETE,
            "$url/$id",
            { res ->
                Toast.makeText(
                    this,
                    if (res.toString().isEmpty())
                        "Deleted Successfully"
                    else
                        "Server Error",
                    Toast.LENGTH_LONG
                ).show();
            },
            { err -> Log.e(ReqType.DELETE.toString(), err.toString()) }
        )

        queue.add(req)
        return true
    }

    private fun postUser(name: String, job: String): Boolean {
        val url = "https://reqres.in/api/users"
        val params = HashMap<String, String>()
        params["name"] = name
        params["job"] = job

        val req = JsonObjectRequest(
            Request.Method.POST,
            url,
            JSONObject(params as Map<String, *>),
            { res ->
                Toast.makeText(this, res.toString(), Toast.LENGTH_LONG).show();
            },
            { err -> Log.e(ReqType.POST.toString(), err.toString()) }
        )
        queue.add(req)
        return true
    }

    private fun jsonParse(data: JSONArray?, reqType: ReqType) {
        data?.let {
            for (i in 0 until data.length()) {
                val id = data.getJSONObject(i)?.get("id").toString().toInt()
                val email = data.getJSONObject(i)?.get("email").toString()
                val firstName = data.getJSONObject(i)?.get("first_name").toString()
                val lastName = data.getJSONObject(i)?.get("last_name").toString()
                val avatar = data.getJSONObject(i)?.get("avatar").toString()

                Log.e("$TAG $reqType", data.get(i).toString())
                userList.add(i, User(id, firstName, lastName, email, avatar))
                binding.rwUser.adapter = UserAdapter(this@MainActivity, userList)
            }
        }
    }
}


