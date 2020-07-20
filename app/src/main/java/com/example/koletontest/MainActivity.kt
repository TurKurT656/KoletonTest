package com.example.koletontest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adp = Adp()
        my_list.adapter = adp
        my_list.loadSkeleton(R.layout.item_test) {
            shimmer(true)
            color(R.color.colorAccent)
            itemCount(8)
        }
        handler.postDelayed(5000) {
            my_list.hideSkeleton()
            handler.postDelayed(500) {
                adp.submitList(
                        listOf(
                                Itemm(1),
                                Itemm(2),
                                Itemm(3),
                                Itemm(4),
                                Itemm(5)
                        )
                )
            }
        }
    }
}