package com.yunjuanyunshu;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author hansong.xhs
 * @version \$Id: com.xiaohansong.codemaker.CodeMaker.java, v 0.1 2017-01-19 10:18 hansong.xhs Exp $$
 */
@State(name = "com.yunjuanyunshu.CodeMaker", storages = {@Storage(file = "$WORKSPACE_FILE$"
)})
public class CodeMaker implements ApplicationComponent, PersistentStateComponent<CodeMaker> {
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

    public void loadState(CodeMaker state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public CodeMaker getState() {
        return this;
    }
}
