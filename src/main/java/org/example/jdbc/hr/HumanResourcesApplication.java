package org.example.jdbc.hr;

import org.example.jdbc.hr.command.Command;
import org.example.jdbc.hr.command.impl.BatchCommand;
import org.example.jdbc.hr.command.impl.DeleteCommand;
import org.example.jdbc.hr.command.impl.InsertCommand;
import org.example.jdbc.hr.command.impl.QueryCommand;

import java.util.Scanner;

/***
 *
 *
 * @author Swei
 * @description
 * @date 2024/11/6 15:23
 **/
public class HumanResourcesApplication {
    public static void main(String[] args) {
        System.out.println("1-查询员工");
        System.out.println("2-添加员工");
        System.out.println("3-批量增加");
        System.out.println("4-删除员工");
        System.out.print("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Command command;
        switch (choice) {
            case 1:
                command = new QueryCommand();
                command.execute();
                break;
            case 2:
                command = new InsertCommand();
                command.execute();
                break;
            case 3:
                command = new BatchCommand();
                command.execute();
                break;
            case 4:
                command = new DeleteCommand();
                command.execute();
                break;
        }
    }
}
