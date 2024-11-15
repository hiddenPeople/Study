package org.example.factory;

import org.junit.jupiter.api.Test;

/**
 * 工厂模式测试用例
 *
 * @author Swei
 * @description
 * @date 2024/11/14 08:46
 */
class AssistantTest {

    @Test
    public void buyComputer() {
        Assistant assistant = new Assistant();
        String description = "商务办公";
        Computer computer = assistant.suggestComputer(description);
        System.out.println(computer.description());
    }
}