package com.playground;

import java.util.List;

import lombok.Data;

/**
 * @author mr_yo
 * 电梯算法
 * 某日实在闲得无聊, 想到了平日坐的电梯的算法。
 * 这里根据自己的理解实现一下
 * 
 * 1. 给定一个两井电梯，且根据随机数生成一个初始状态  比如 [1,7] 代表左侧在一层，右侧在7层
 * 2. 假定每部电梯，每层耗费5秒时间。
 * 3. 假定两部电梯都到达目的层后如无人触发按钮则停在目的层
 * 4. 剩下的写在代码里
 */
@Data
public class Elevator {
    

    private List<Integer> elevators;
    
    
    public static void main(String[] args) {
        Elevator e = new Elevator();
        
    }
    
    
    /**
     * 
     */
    boolean move(int floor) {
        return false;
    }
    

}
