package com.example.diceout

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var rollResult: TextView
    lateinit var rollButton: Button
    var score: Int = 0
    lateinit var rand: Random
    var die1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        //Set initial score to zero
        score = 0

        rollResult = findViewById(R.id.rollResult)
        rollButton = findViewById(R.id.rollButton)

        rand = Random

        //Create greeting
        Toast.makeText(applicationContext, "Welcome to DiceOut!", Toast.LENGTH_SHORT).show()

    }

    public fun rollDice(v: View){
        rollResult.setText("Clicked")
        die1 = rand.nextInt(6) + 1
        val msg = "You rolled a $die1"
        rollResult.setText(msg)

//        var num: Int = rand.nextInt(6) + 1
//        var randomValue = "Number generated: $num"
//        Toast.makeText(applicationContext, randomValue, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}