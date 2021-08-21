package com.example.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseActivity : AppCompatActivity() {
    lateinit var rvCourse: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
    }
    fun  displayCourse(){
        var courseList= listOf<Course>(
            Course("Android","AND 120","Native Android","John OWUAR"),
            Course("python","KML140","framework","Jamemwai")


        )
        rvCourse=findViewById(R.id.rvCourse)
        var CourserAdapter= CourseRecyclerViewAdapter(courseList)
        rvCourse.layoutManager=LinearLayoutManager(baseContext)
        rvCourse.adapter=CourserAdapter
    }
}