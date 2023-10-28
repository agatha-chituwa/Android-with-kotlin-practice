package com.example.lordhavemercy

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.service.controls.actions.FloatAction
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {
    private  var mediaPlayer:MediaPlayer? = null

    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private  lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        //initializing seekbar
        seekBar = findViewById(R.id.seekBar)
        handler = Handler(Looper.getMainLooper())
        //onclick listener of three floating action buttons
        val playButton = findViewById<FloatingActionButton>(R.id.playy)
        val pauseButton = findViewById<FloatingActionButton>(R.id.fabPause)
        val stopButton = findViewById<FloatingActionButton>(R.id.fabStop)

        playButton.setOnClickListener {
            if(mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this, R.raw.clap)
                initializeSeekBar()
            }
            mediaPlayer?.start()
        }
        pauseButton.setOnClickListener {
            mediaPlayer?.pause()
        }
       stopButton.setOnClickListener {
            mediaPlayer?.stop()
           mediaPlayer?.reset()
            mediaPlayer?.release()
           mediaPlayer = null
           handler.removeCallbacks(runnable)
           seekBar.progress = 0

        }





    }

    //function for seekbar related tasks
    private fun initializeSeekBar(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(progress)

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        val tvPlayed = findViewById<TextView>(R.id.tvPlayed)
        val tvDue = findViewById<TextView>(R.id.tvindex)
        seekBar.max = mediaPlayer!!.duration
        runnable = Runnable {

            seekBar.progress = mediaPlayer!!.currentPosition
//            val playedTime = mediaPlayer!!.currentPosition /1000
//            tvPlayed.text = "$playedTime sec"
//
//            val duration = mediaPlayer!!.duration/1000
//            val dueTime = duration - playedTime
//            tvDue.text =  "$dueTime"

            handler.postDelayed(runnable, 1000)

        }
        handler.postDelayed(runnable, 1000)
    }
}