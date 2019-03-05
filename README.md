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
<xml>
<jdroidcoder.ua.paginationrecyclerview.PaginationRecyclerView
        android:id="@+id/paginationRecyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity" />
</xml>
<li>Add OnPageChangeListener</li>
<pre>  
 paginationRecyclerView?.setOnPageChangeListener(object : OnPageChangeListener {
    override fun onPageChange(page: Int) {
       // Here you will receive next page
    }
})
</pre>  

