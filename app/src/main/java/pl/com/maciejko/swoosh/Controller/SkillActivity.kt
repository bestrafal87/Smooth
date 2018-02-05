package pl.com.maciejko.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import pl.com.maciejko.swoosh.Model.Player
import pl.com.maciejko.swoosh.Utilities.EXTRA_LEAGUE
import pl.com.maciejko.swoosh.R
import pl.com.maciejko.swoosh.Utilities.EXTRA_LEVEL
import pl.com.maciejko.swoosh.Utilities.EXTRA_PLAYER

class SkillActivity : BaseActivity() {


    //obiekt który możemy zainicjalizować potem
    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

        println(player.league)
    }

    fun onFinishClicked(view: View) {
        if(player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }

    fun onBeginnerClicked(view: View) {
        bollerSkilBtn.isChecked = false
        player.skill = "beginner"

    }

    fun onBollerClicked(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"

    }
}
