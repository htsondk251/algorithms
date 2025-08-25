package com.example.test.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class _394_DecodeString {

    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        for (String ch : s.split("(?=[\\[\\]])|(?<=[\\[\\]])")) {
            if (!"]".equals(ch)) {
                stack.push(ch);
                continue;
            }

            StringBuilder encoded = new StringBuilder();
            while (!stack.isEmpty() && !"[".equals(stack.peek())) {
                encoded.insert(0, stack.pop());
            }

            //pop '['
            stack.pop();
            String origin = encoded.toString();
            int repeat = Integer.parseInt(stack.pop());
            for (int i = 0; i < repeat - 1; i++) {
                encoded.append(origin);
            }
            stack.push(encoded.toString());
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();

    }

    public static void main(String[] args) {
        _394_DecodeString i = new _394_DecodeString();
        System.out.println(i.decodeString("10[leetcode]"));
    }
}
