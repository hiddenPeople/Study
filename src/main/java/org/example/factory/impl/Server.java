package org.example.factory.impl;

import org.example.factory.Computer;

/***
 *  服务器
 *
 * @author Swei
 * @description
 * @date 2024/11/13 21:08
 **/
public class Server implements Computer {
    @Override
    public String description() {
        return "当前是高性能服务器！";
    }
}
