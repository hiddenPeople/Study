package org.example.factory.impl;

import org.example.factory.Computer;

/***
 * 个人电脑
 *
 * @author Swei
 * @description
 * @date 2024/11/13 21:10
 **/
public class DeskTop implements Computer {
    @Override
    public String description() {
        return "当前是游戏主机！";
    }
}
