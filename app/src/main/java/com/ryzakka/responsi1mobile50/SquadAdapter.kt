package com.ryzakka.responsi1mobile50

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ryzakka.responsi1mobile50.databinding.DaftarpemainBinding

class SquadAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<SquadAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: DaftarpemainBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = DaftarpemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.tvPlayerName.text = player.name
        holder.binding.tvPlayerNationality.text = player.nationality

        val backgroundColor = when (player.position) {
            "Goalkeeper" -> Color.parseColor("#FFEB3B")
            "Defence" -> Color.parseColor("#2196F3")
            "Midfield" -> Color.parseColor("#4CAF50")
            "Offence" -> Color.parseColor("#F44336")
            else -> Color.GRAY
        }
        holder.binding.playerCard.setCardBackgroundColor(backgroundColor)

        holder.itemView.setOnClickListener {
            onItemClick(player)
        }
    }
}
