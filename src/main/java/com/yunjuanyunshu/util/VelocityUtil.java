package com.yunjuanyunshu.util;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogChute;

import java.io.StringWriter;
import java.util.Map;

/**
 * @author hansong.xhs
 * @version $Id: VelocityUtil.java, v 0.1 2017-01-22 8:49 hansong.xhs Exp $$
 * 模板转换类
 */
public class VelocityUtil {

    private final static VelocityEngine velocityEngine;

    static {
        velocityEngine = new VelocityEngine();
        // Disable separate Velocity logging.
        velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
            NullLogChute.class.getName());
        velocityEngine.init();
    }

    /**
     *
     * @param template 模板字符串
     * @param map <关键字,替换值> <$YEAR,2017>
     * @return
     */
    public static String evaluate(String template, Map<String, Object> map) {
        VelocityContext context = new VelocityContext();
        map.forEach(context::put);
        StringWriter writer = new StringWriter();
        velocityEngine.evaluate(context, writer, "", template);
        return writer.toString();
    }

}
