package com.codexo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }

    private val addFab: FloatingActionButton by lazy { findViewById(R.id.fab_add) }
    private val editFab: FloatingActionButton by lazy { findViewById(R.id.fab_edit) }
    private val locationFab: FloatingActionButton by lazy { findViewById(R.id.fab_my_location) }
    private val voiceFab: FloatingActionButton by lazy { findViewById(R.id.fab_voice) }
    private var isOpen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFab.setOnClickListener {
            isOpen = !isOpen
            setVisibility()
            setAnimation()
        }
        editFab.setOnClickListener { showToast("Edit Fab") }
        locationFab.setOnClickListener { showToast("location Fab") }
        voiceFab.setOnClickListener { showToast("voice Fab") }
    }

    private fun setAnimation() {
        if (isOpen){
            addFab.startAnimation(rotateOpen)
            editFab.startAnimation(fromBottom)
            locationFab.startAnimation(fromBottom)
            voiceFab.startAnimation(fromBottom)
        } else {
            addFab.startAnimation(rotateClose)
            editFab.startAnimation(toBottom)
            locationFab.startAnimation(toBottom)
            voiceFab.startAnimation(toBottom)
        }
    }

    private fun setVisibility() {
        if (isOpen){
            editFab.visibility = View.VISIBLE
            locationFab.visibility = View.VISIBLE
            voiceFab.visibility = View.VISIBLE
        } else {
            editFab.visibility = View.GONE
            locationFab.visibility = View.GONE
            voiceFab.visibility = View.GONE
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, "$s clicked", Toast.LENGTH_SHORT).show()
    }
}