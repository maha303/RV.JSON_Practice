package com.example.rvjson_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var edNum:EditText
    private lateinit var btGet:Button
    private lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNum=findViewById(R.id.edNum)
        tv=findViewById(R.id.tv)
        btGet=findViewById(R.id.btGet)

        btGet.setOnClickListener {
            val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
            apiInterface?.getName()?.enqueue(object :Callback<List<NameItem>>{
                override fun onResponse(
                    call: Call<List<NameItem>>,
                    response: Response<List<NameItem>>
                ) {
                      val num=edNum.text.toString().toInt()
                    tv.text = response.body()!![num].name
                }
                override fun onFailure(call: Call<List<NameItem>>, t: Throwable) {
                    call.cancel()
                }
            })
        }
    }
}