package org.example;

/**
 * @author Swei
 * @description
 * @date 2024/10/23 17:58
 */// 按两次 ⇧ 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        // 当文本光标位于高亮显示的文本处时按 ⌥⏎，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        System.out.printf("Hello and welcome!");

        // 按 ⇧F10 或点击间距中的绿色箭头按钮以运行脚本。
        for (int i = 1; i <= 5; i++) {

            // 按 ⇧F9 开始调试代码。我们已为您设置了一个断点，
            // 但您始终可以通过按 ⌘F8 添加更多断点。
            System.out.println("i = " + i);
        }
    }
}