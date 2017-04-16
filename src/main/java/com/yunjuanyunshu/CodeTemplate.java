package com.yunjuanyunshu;

import com.intellij.openapi.util.text.StringUtil;

/**
 * @author hansong.xhs
 * @version $Id: CodeTemplate.java, v 0.1 2017-01-28 9:41 hansong.xhs Exp $$
 */
public class CodeTemplate {

    /**
     * template name
     */
    private String name;

    /**
     * the generated class name, support velocity
     */
    private String classNameVm;

    /**
     * code template in velocity
     */
    private String codeTemplate;

    /**
     * the number of template context class
     */
    private String packageName;

    public CodeTemplate() {
    }

    public CodeTemplate(String name, String classNameVm, String codeTemplate, String packageName) {
        this.name = name;
        this.classNameVm = classNameVm;
        this.codeTemplate = codeTemplate;
        this.packageName = packageName;
    }

    public boolean isValid() {
        return StringUtil.isNotEmpty(getClassNameVm()) && StringUtil.isNotEmpty(getName())
               && StringUtil.isNotEmpty(getCodeTemplate()) && StringUtil.isNotEmpty(packageName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CodeTemplate that = (CodeTemplate) o;

        if (packageName != null && packageName.equals(that.packageName))
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (classNameVm != null ? !classNameVm.equals(that.classNameVm) : that.classNameVm != null)
            return false;
        return codeTemplate != null ? codeTemplate.equals(that.codeTemplate)
            : that.codeTemplate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (classNameVm != null ? classNameVm.hashCode() : 0);
        result = 31 * result + (codeTemplate != null ? codeTemplate.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        return result;
    }

    public static final CodeTemplate EMPTY_TEMPLATE = new CodeTemplate("", "", "", "");

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>codeTemplate</tt>.
     *
     * @return property value of codeTemplate
     */
    public String getCodeTemplate() {
        return codeTemplate;
    }

    /**
     * Setter method for property <tt>codeTemplate</tt>.
     *
     * @param codeTemplate value to be assigned to property codeTemplate
     */
    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    /**
     * Getter method for property <tt>classNumber</tt>.
     *
     * @return property value of classNumber
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Setter method for property <tt>classNumber</tt>.
     *
     * @param packageName value to be assigned to property classNumber
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Getter method for property <tt>classNameVm</tt>.
     *
     * @return property value of classNameVm
     */
    public String getClassNameVm() {
        return classNameVm;
    }

    /**
     * Setter method for property <tt>classNameVm</tt>.
     *
     * @param classNameVm value to be assigned to property classNameVm
     */
    public void setClassNameVm(String classNameVm) {
        this.classNameVm = classNameVm;
    }
}
