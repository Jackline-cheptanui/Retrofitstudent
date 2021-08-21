package com.example.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CourseRecyclerViewAdapter (var courseList: List<Course>):RecyclerView.Adapter<CourseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.course_list_item,parent,false)
        return CourseViewHolder(itemView )

    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        var currentCourse=courseList.get(position)
        holder.tvCourseName.text=currentCourse.CourseName
        holder.tvCourseCode.text=currentCourse.CourseCode
        holder.tvdescription.text=currentCourse.description
        holder.tvinstructor.text=currentCourse.instructor
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}
class CourseViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvdescription = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvinstructor = itemView.findViewById<TextView>(R.id.tvCourseName)
}