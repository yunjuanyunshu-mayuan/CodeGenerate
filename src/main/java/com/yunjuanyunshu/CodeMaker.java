package com.yunjuanyunshu;

import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

/**
 * @author hansong.xhs
 * @version \$Id: com.xiaohansong.codemaker.CodeMaker.java, v 0.1 2017-01-19 10:18 hansong.xhs Exp $$
 */
public class CodeMaker implements ApplicationComponent {
    public CodeMaker() {
    }

    @Override
    public void initComponent() {
    }

    @Override
    public void disposeComponent() {
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "com.yunjuanyunshu.CodeMaker";
    }
}
