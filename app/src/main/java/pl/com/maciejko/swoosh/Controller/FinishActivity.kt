package pl.com.maciejko.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*
import pl.com.maciejko.swoosh.Model.Player
import pl.com.maciejko.swoosh.R
import pl.com.maciejko.swoosh.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagesText.text = "Looking for ${player.league} ${player.skill} league near you..."


    }
}
