package com.code.firstlinecoding08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mFloatingActionButton: FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFloatingActionButton = findViewById<FloatingActionButton>(R.id.fab);
        mFloatingActionButton.setOnClickListener {
//            Toast.makeText(this,"悬浮",Toast.LENGTH_SHORT).show()

            Snackbar
                    .make(mFloatingActionButton, "Data deleted", Snackbar.LENGTH_SHORT)
                    .setAction("Undo") {
                        Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                    }
                    .show()
        }
    }
}