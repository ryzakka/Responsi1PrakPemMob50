package com.ryzakka.responsi1mobile50

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ryzakka.responsi1mobile50.databinding.ActivityTimBinding

class TimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimBinding
    private lateinit var squadAdapter: SquadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val squadList = intent.getParcelableArrayListExtra<Player>("SQUAD_LIST")
        if (squadList != null) {
            setupRecyclerView(squadList)
        }
    }

    private fun setupRecyclerView(players: List<Player>) {
        squadAdapter = SquadAdapter(players) { selectedPlayer ->
            val bottomSheet = JendelaRincianBawah.newInstance(selectedPlayer)
            bottomSheet.show(supportFragmentManager, "JendelaRincianBawah")
        }
        binding.rvSquad.adapter = squadAdapter
    }}

