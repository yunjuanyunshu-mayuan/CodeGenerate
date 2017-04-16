package com.yunjuanyunshu.util;

import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 * Created by unize4 on 17/4/17.
 * 验证器
 */
public class ValidatorUtil {

    /**
     * 判断是否为空
     * @param type 显示的内容类型字符串,如用户名.多个需用逗号分开
     * @param components 需要判断的组件
     * @return 返回布尔值
     */
    public static boolean validation(String type,JTextComponent...components){
        int i=0;
        for(JTextComponent component:components) {
            if (isEmpty(component)) {
                showWarning(type.split(",")[i] + "不能为空！", "数据库连接");
                component.requestFocus();
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * 判断输入框是否为空
     * @param component   输入框
     * @return 返回布尔值
     */
    public static boolean isEmpty(JTextComponent component){
        String content = component.getText();
        return null == content || content.equals("");
    }

    /**
     * 错误提示
     * @param title 标题
     * @param msg 信息
     */
    public static void showError(String msg,String title){
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * 警告提示
     * @param title 标题
     * @param msg 信息
     */
    public static void showWarning(String msg,String title){
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, msg, title, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * 信息提示
     * @param title 标题
     * @param msg 信息
     */
    public static void showInfo(String msg,String title){
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, msg, title, JOptionPane.INFORMATION_MESSAGE);


    }
}
