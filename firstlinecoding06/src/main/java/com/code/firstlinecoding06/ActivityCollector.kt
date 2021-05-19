package com.code.firstlinecoding06

import android.app.Activity

/**
 * @创建者 Jack
 * @创建时间 2021/4/27 11:04
 * @描述
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){

    }

    fun removeActivity(activity: Activity){

    }

    fun finishAll(){
        for(activity in activities){
            activity.finish()
        }

        activities.clear()
    }

}