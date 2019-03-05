package jdroidcoder.ua.paginationrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class PaginationRecyclerView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {
    private var scrollListener: EndlessRecyclerViewScrollListener? = null
    private var onPageChangeListener: OnPageChangeListener? = null

    override fun setLayoutManager(layout: LayoutManager?) {
        super.setLayoutManager(layout)
        if (scrollListener == null && layout != null) {
            scrollListener = object : EndlessRecyclerViewScrollListener(layout) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    onPageChangeListener?.onPageChange(page)
                }
            }
        }
        scrollListener?.let { addOnScrollListener(it) }
    }

    fun setOnPageChangeListener(onPageChangeListener: OnPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener
    }
}