package pl.com.maciejko.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*
import pl.com.maciejko.swoosh.Model.Player
import pl.com.maciejko.swoosh.Utilities.EXTRA_LEAGUE
import pl.com.maciejko.swoosh.R
import pl.com.maciejko.swoosh.Utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view: View) {
        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            // aby przekazac obiekt urzywamy metody putextra dla obietow parcelable
            // przekazywany obiekt musi dziedziczyc po klasie parcelable
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_LONG).show()
        }
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "coed"
    }

}
