package umn.ac.id.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import umn.ac.id.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list for storing all the list data
    private val cats = mutableListOf<CatModel>()

    // A function to set the mutable list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Notify the adapter that the dataset has changed
        notifyDataSetChanged()
    }

    // A view holder is used to bind the data to the layout views
    // onCreateViewHolder instantiates the view holder itself
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    // Get the amount of data/items in the list
    override fun getItemCount() = cats.size

    // Bind each data to each layout view
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // The holder parameter stores our previously created ViewHolder
        holder.bindData(cats[position])
    }
}