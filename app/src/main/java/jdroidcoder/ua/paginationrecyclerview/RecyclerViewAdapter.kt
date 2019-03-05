package jdroidcoder.ua.paginationrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_style.view.*

class RecyclerViewAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    fun addItems(items: ArrayList<String>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_style, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = items?.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: TextView = view.itemTextView
}