package org.example.factory.impl;

import org.example.factory.Computer;

/***
 * 笔记本
 *
 * @author Swei
 * @description
 * @date 2024/11/13 21:14
 **/
public class NoteBook implements Computer {
    @Override
    public String description() {
        return "当前是商务笔记本！";
    }
}
