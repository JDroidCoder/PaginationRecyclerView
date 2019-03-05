package jdroidcoder.ua.paginationrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =  RecyclerViewAdapter(generateList(1))
        paginationRecyclerView.adapter =adapter
        paginationRecyclerView?.layoutManager = LinearLayoutManager(this)
        paginationRecyclerView?.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
                println("page = $page")
                adapter.addItems(generateList(page))
            }

        })
    }

    private fun generateList(page: Int): ArrayList<String> {
        val arrayList = ArrayList<String>()
        for (i in 0..10) {
            arrayList.add("Item $i page $page")
        }
        return arrayList
    }
}
