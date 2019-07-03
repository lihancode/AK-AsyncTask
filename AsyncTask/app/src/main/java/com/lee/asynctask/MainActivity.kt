package com.lee.asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL

class MainActivity : AppCompatActivity() {

    
    val TAG = MainActivity::class.java.simpleName
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        GithubAsyncTask().execute("https://api.github.com/users")
    }

    inner class GithubAsyncTask : AsyncTask<String,Int,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d(TAG, "onPreExecute: ")
            //next to doInBackground
        }
        override fun doInBackground(vararg p0: String?): String {
            val readText = URL(p0[0]).readText()
            //Log.d(TAG, "doInBackground: $readText")
            //result to onPostExecute
            publishProgress(100)
            //use publishProgress to onProgressUpdate
            return readText
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            Log.d(TAG, "onProgressUpdate: ${values[0]}")
            //update your progress bar ... etc
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.d(TAG, "onPostExecute:  $result")
            // is result

        }


    }


}

