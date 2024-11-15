package org.example.factory.impl;

import org.example.factory.Computer;

/***
 * DIY
 * @author Swei
 * @description
 * @date 2024/11/13 21:15
 **/
public class Other implements Computer {
    @Override
    public String description() {
        return "当前是DIY其他电脑";
    }
}
