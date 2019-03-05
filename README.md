# PaginationRecyclerView

This library based on RecyclerView, and has a purpose easy work with lazy loading (pagination) data.

You can use this library with our other library for work with Network API: https://github.com/JDroidCoder/apiservice

<b>Install:</b>
<ul>
<li>Add jitpack repository in gradle(project level)</li>
<pre>
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</pre>

<li>Add dependency in gradle(app level)</li>
<pre>
dependencies {
	implementation 'com.github.JDroidCoder:apiservice:1.0.2'
}
</pre>

<li>enjoy ;)</li>
</ul>

<b>Initialize library:</b>

<li>Init in the xml</li>
{% highlight xml %}

	<jdroidcoder.ua.paginationrecyclerview.PaginationRecyclerView
		android:id="@+id/paginationRecyclerView"
		android:layout_width="match_parent"
		android:layout_height="match_parent" />
{% endhighlight %}
<li>Add OnPageChangeListener</li>
<pre>  
 paginationRecyclerView?.setOnPageChangeListener(object : OnPageChangeListener {
    override fun onPageChange(page: Int) {
       // Here you will receive next page
    }
})
</pre>  

Code example:
<b>Xml (activity_main):</b>
<pre>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
<pre>
    <jdroidcoder.ua.paginationrecyclerview.PaginationRecyclerView
        android:id="@+id/paginationRecyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity" />
</pre>
</android.support.constraint.ConstraintLayout></pre>
<b>Activity class:</b>
<pre>
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter =  RecyclerViewAdapter(generateList(1))
        paginationRecyclerView.adapter =adapter
        paginationRecyclerView?.layoutManager = LinearLayoutManager(this)
        paginationRecyclerView?.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
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
</pre>
<b>item_style.xml:</b>
<pre>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/itemTextView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="20dp"
    android:textSize="20sp" />
</pre>
<b>RecyclerViewAdapter:</b>
<pre>
class RecyclerViewAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_style, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = items?.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    
    fun addItems(items: ArrayList<String>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemTextView: TextView = view.itemTextView
}
</pre>

If you have any question ask us here or write to email: jdroidcoder@gmail.com
