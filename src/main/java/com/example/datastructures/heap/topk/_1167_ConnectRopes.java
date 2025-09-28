package com.example.datastructures.heap.topk;

import java.util.PriorityQueue;

/**
 * @version 1.0
 * @description:
 * @author: son.hoangthanh
 * @date: 27/09/2025 7:31 AM
 */

public class _1167_ConnectRopes {

    public int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> length = new PriorityQueue<>();
        int result = 0;
        for (int ropeLength : ropeLengths) {
            length.add(ropeLength);
        }

        while (length.size() > 1) {
            int cost = length.poll() +  length.poll();
            result += cost;
            length.add(cost);
        }

        return result;
    }

    public static void main(String[] args) {
        _1167_ConnectRopes i = new _1167_ConnectRopes();
        System.out.println(i.minimumCostToConnectRopes(new int[]{1,3,11,5})); //33
        System.out.println(i.minimumCostToConnectRopes(new int[]{3,4,5,6}));    //36
    }
}
