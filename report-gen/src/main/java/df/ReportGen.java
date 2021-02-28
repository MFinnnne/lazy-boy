package df;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MFine
 * @version 1.0
 * @date 2021/2/28 1:10
 **/
public class ReportGen {


    public static void main(String[] args) throws IOException, TemplateException, SQLException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("D:\\study road\\MyCode\\LazyBoy\\report-gen\\src\\main\\resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

        Map<String, Object> root = new HashMap<>(10);
        List<ReportColumnProperty> list = new ArrayList<>();

        ResultSet parse = TableParse.parse();
        String[] tableInfo = TableParse.getTableInfo();

        while (parse.next()) {
            if (tableInfo[1].equals(parse.getString("COLUMN_NAME"))) {
                continue;
            }
            list.add(new ReportColumnProperty(CamelAndUnderLineConverter.lineToHump(parse.getString("COLUMN_NAME")), parse.getString("REMARKS")));
        }

        String captureName = CamelAndUnderLineConverter.captureName(CamelAndUnderLineConverter.lineToHump(tableInfo[0]));
        root.put("reportColumns", list);
        root.put("reportDetail", captureName + "Detail");

        ArrayList<String> ftls = new ArrayList<>();
        ftls.add(captureName);
        ftls.add(captureName + "Detail");
        ftls.forEach((ftl) -> {
            Template template = null;
            try {
                template = cfg.getTemplate((ftl.contains("Detail") ? "ReportDetail" : "Report") + ".ftl");
                File file = new File("D:\\study road\\MyCode\\LazyBoy\\report-gen\\src\\main\\resources\\out\\" + ftl + ".vue");
                //判断有没有父路径，就是判断文件整个路径是否存在
                if (!file.getParentFile().exists()) {
                    //不存在就全部创建
                    boolean mkdir = file.getParentFile().mkdir();
                }
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
                template.process(root, writer);
                writer.flush();
                writer.close();
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }


        });

    }
}
