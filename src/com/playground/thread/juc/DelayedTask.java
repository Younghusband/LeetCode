package com.playground.thread.juc;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;



public class DelayedTask implements Delayed {
    
    private Integer taskId;
    private long start = System.currentTimeMillis();
    private long time;
    
    
    public DelayedTask(Integer taskId, int mins) {
        this.taskId = taskId;
        this.time = mins * 60 * 1000;
    }
    
    
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start + time) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
    
    
    @Override
    public int compareTo(Delayed o) {
        DelayedTask o1 = (DelayedTask) o;
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }


    @Override
    public String toString() {
        return "DelayedTask [taskId=" + taskId + ", start=" + start + ", time=" + time + "]";
    }

}
