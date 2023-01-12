package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapter ( val context: Context, val articles:List<Article>): RecyclerView.Adapter<VIholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VIholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.itemview,null)



        return VIholder(view)
    }

    override fun onBindViewHolder(holder: VIholder, position:Int) {
        val article=articles[position]
        holder.newsTitle.text=article.title
        holder.newsDes.text=article.descripton
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
        holder.itemView.setOnClickListener{
            Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return articles.size
    }

}
class VIholder(itemView:View):RecyclerView.ViewHolder(itemView){
      var newsImage=itemView.findViewById<ImageView>(R.id.imageview)
        var newsTitle=itemView.findViewById<TextView>(R.id.txttittle)
    var newsDes=itemView.findViewById<TextView>(R.id.txtdescrption)

}


