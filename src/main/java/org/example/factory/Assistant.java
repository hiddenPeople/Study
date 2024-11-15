package org.example.factory;

import org.example.factory.impl.DeskTop;
import org.example.factory.impl.NoteBook;
import org.example.factory.impl.Other;
import org.example.factory.impl.Server;

/***
 * 工厂模式
 *
 * @author Swei
 * @description
 * @date 2024/11/13 21:17
 **/
public class Assistant {
    public Computer suggestComputer(String description) {
        switch (description) {
            case "搭建网站服务":
                return new Server();
            case "玩游戏":
                return new DeskTop();
            case "商务办公":
                return new NoteBook();
            default:
                return new Other();
        }
    }
}
