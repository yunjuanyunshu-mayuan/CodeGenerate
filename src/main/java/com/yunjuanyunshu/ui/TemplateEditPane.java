package com.yunjuanyunshu.ui;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.uiDesigner.core.GridConstraints;
import com.yunjuanyunshu.CodeMakerSettings;
import com.yunjuanyunshu.CodeTemplate;

import javax.swing.*;
import java.awt.*;

/**
 * @author hansong.xhs
 * @version $Id: TemplateEditPane.java, v 0.1 2017-01-31 9:06 hansong.xhs Exp $$
 */
public class TemplateEditPane {

    private JPanel     templateEdit;
    private JTextField templateNameText;
    private JTextField packageNameText;
    private JTextField classNameText;
    private JButton    deleteTemplateButton;
    private JPanel     editorPane;
    private Editor editor;

    public TemplateEditPane(CodeMakerSettings settings, String template,
                            CodeMakerConfiguration parentPane) {
        CodeTemplate codeTemplate = settings.getCodeTemplate(template);
        if (codeTemplate == null) {
            codeTemplate = CodeTemplate.EMPTY_TEMPLATE;
        }

        templateNameText.setText(codeTemplate.getName());
        packageNameText.setText(codeTemplate.getPackageName());
        classNameText.setText(codeTemplate.getClassNameVm());
        addVmEditor(codeTemplate.getCodeTemplate());
        deleteTemplateButton.addActionListener(e -> {
            int result = Messages.showYesNoDialog("Delete this template?", "Delete", null);
            if (result == Messages.OK) {
                settings.removeCodeTemplate(template);
                parentPane.refresh(settings);
            }
        });
    }

    private void addVmEditor(String template) {
        EditorFactory factory = EditorFactory.getInstance();
        Document velocityTemplate = factory.createDocument(template);
        editor = factory.createEditor(velocityTemplate, null, FileTypeManager.getInstance()
            .getFileTypeByExtension("vm"), false);
        GridConstraints constraints = new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(300, 300), null, 0, true);
        editorPane.add(editor.getComponent(), constraints);
    }

    /**
     * Getter method for property <tt>templateEdit</tt>.
     *
     * @return property value of templateEdit
     */
    public JPanel getTemplateEdit() {
        return templateEdit;
    }

    public String getClassName() {
        return classNameText.getText();
    }

    public String getTemplateName() {
        return templateNameText.getText();
    }

    public String getTemplate() {
        return editor.getDocument().getText();
    }

    /**
     * 获取包前缀名
     * @return 包前缀名
     */
    public String getPackageName() {
            return packageNameText.getText();
    }
}
