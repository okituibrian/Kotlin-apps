package com.example.teleafiakotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout

class MenuActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var contentText: TextView
    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: ExpandableListAdapter
    private lateinit var expandableListTitle: List<String>
    private lateinit var expandableListDetail: HashMap<String, List<String>>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        drawerLayout = findViewById(R.id.drawer_layout)
        contentText = findViewById(R.id.content_text)
        expandableListView = findViewById(R.id.nav_list)

        expandableListDetail = getData()
        expandableListTitle = ArrayList(expandableListDetail.keys)
        expandableListAdapter = ExpandableListAdapter(this, expandableListTitle, expandableListDetail)
        expandableListView.setAdapter(expandableListAdapter)

        expandableListView.setOnGroupClickListener { parent, v, groupPosition, id ->
            val groupTitle = expandableListTitle[groupPosition]
            if (groupTitle == "Sales") {
                // Allow "Sales" to be expanded/collapsed
                false
            } else {
                // Do not allow other groups to be expanded/collapsed
                contentText.text = groupTitle
                drawerLayout.closeDrawer(expandableListView)
                true
            }
        }

        expandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val selectedItem = expandableListDetail[expandableListTitle[groupPosition]]!![childPosition]
            contentText.text = selectedItem
            drawerLayout.closeDrawer(expandableListView)
            false
        }
    }

    private fun getData(): HashMap<String, List<String>> {
        val listData = HashMap<String, List<String>>()

        val salesItems = listOf("Products", "Payments", "Markets", "Retail")
        listData["Sales"] = salesItems


        return listData
    }
}
