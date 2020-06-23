package com.example.diceout

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var rollResult: TextView
    lateinit var rollButton: Button
    var score: Int = 0
    lateinit var rand: Random
    var die1: Int = 0
    var die2: Int = 0
    var die3: Int = 0

    lateinit var dice: ArrayList<Int>
    lateinit var diceImageViews: ArrayList<ImageView>

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

        dice = ArrayList()
        var die1Image = findViewById<ImageView>(R.id.die1Image)
        var die2Image = findViewById<ImageView>(R.id.die2Image)
        var die3Image = findViewById<ImageView>(R.id.die3Image)

        diceImageViews = ArrayList<ImageView>()
        diceImageViews.add(die1Image)
        diceImageViews.add(die2Image)
        diceImageViews.add(die3Image)

        //Create greeting
        Toast.makeText(applicationContext, "Welcome to DiceOut!", Toast.LENGTH_SHORT).show()

    }

    public fun rollDice(v: View){
        rollResult.setText("Clicked")
        die1 = rand.nextInt(6) + 1
        die2 = rand.nextInt(6) + 1
        die3 = rand.nextInt(6) + 1

        dice.clear()
        dice.add(die1)
        dice.add(die2)
        dice.add(die3)

        for (dieOfSet in 0..2) {
            val imageName = "die_" + dice.get(dieOfSet) + ".png"
            try {
                val stream = applicationContext.assets.open(imageName)
                val drawable = Drawable.createFromStream(stream, "")
                diceImageViews.get(dieOfSet).setImageDrawable(drawable)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


        val msg = "You rolled a $die1 and a $die2 and a $die3"
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