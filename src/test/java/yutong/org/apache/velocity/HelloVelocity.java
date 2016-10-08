package yutong.org.apache.velocity;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class HelloVelocity {

    public static void main(String[] args) {
        VelocityEngine ve = new VelocityEngine();
        // ve.setProperty("encoding.default", "UTF-8");
        // ve.setProperty("input.encoding", "UTF-8");
        // ve.setProperty("output.encoding", "UTF-8");
        // ve.setProperty("default.contentType", "text/html");

        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());

        Properties properties = new Properties();
        InputStream in = Object.class.getResourceAsStream(
                "/yutong/org/apache/velocity/volecity.properties");
        try {
            properties.load(in);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // ve.init();
        ve.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        String templatePath = "yutong/org/apache/velocity/";

        /* 开始配置 */
        Template template = ve.getTemplate(templatePath + "hellovelocity.vm");

        velocityContext.put("name", "velocity");
        velocityContext.put("date", (new Date()).toString());

        List<String> list = new ArrayList<String>();
        list.add("a1");
        list.add("a2");
        velocityContext.put("list", list);

        StringWriter sw = new StringWriter();

        template.merge(velocityContext, sw);

        System.out.println(sw.toString());
    }
}
