package df;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 1:10
 **/
public class Test {


    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("D:\\study road\\MyCode\\LazyBoy\\report-gen\\src\\main\\resources"));
                cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Map<String, Object> root = new HashMap<>();

        root.put("user", "MFine");
        Product product = new Product();
        product.setUrl("mfine/ok");
        product.setName("red house");

        root.put("latestProduct", product);

        Template template = cfg.getTemplate("report.ftl");

        File file = new File("D:\\study road\\MyCode\\LazyBoy\\report-gen\\src\\main\\resources\\out\\test.vue");
            //判断有没有父路径，就是判断文件整个路径是否存在
        if (!file.getParentFile().exists()) {
            //不存在就全部创建
            boolean mkdir = file.getParentFile().mkdir();

        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        template.process(root, writer);
        writer.flush();
        writer.close();
    }
}
