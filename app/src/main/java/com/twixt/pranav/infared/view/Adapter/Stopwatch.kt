package com.twixt.pranav.infared.view.Adapter

/**
 * Created by Pranav on 11/13/2017.
 */
class Stopwatch {

    private var startTime: Long = 0
    private var stopTime: Long = 0
    private var running = false


    fun start() {
        this.startTime = System.currentTimeMillis()
        this.running = true
    }


    fun stop() {
        this.stopTime = System.currentTimeMillis()
        this.running = false
    }


    // elaspsed time in milliseconds
    fun getElapsedTime(): Long {
        return if (running) {
            System.currentTimeMillis() - startTime
        } else stopTime - startTime
    }


    // elaspsed time in seconds
    fun getElapsedTimeSecs(): Long {
        return if (running) {
            (System.currentTimeMillis() - startTime) / 1000
        } else (stopTime - startTime) / 1000
    }


    // sample usage
    fun main(args: Array<String>) {
        val s = Stopwatch()
        s.start()
        // code you want to time goes here
        s.stop()
        println("elapsed time in milliseconds: " + s.getElapsedTime())
    }


}