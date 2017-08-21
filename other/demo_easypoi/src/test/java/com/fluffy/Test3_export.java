
package com.fluffy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;

import com.google.common.io.ByteSink;
import com.google.common.io.Files;

public class Test3_export {
  static String basePath;

  /**
   * <pre>
   * 将数据导出为excel文件
   * 
   * 数据格式，按照test3.xlsx为模版
   * </pre>
   */
  public static void main(String[] args) throws Exception {
    // 1. Excel格式模版文件
    TemplateExportParams params = new TemplateExportParams("src/test/resources/test3.xlsx");

    // 2.设置文件保存在demo_easypoi项目的根目录
    String base = System.getProperty("user.dir");
    File f = File.createTempFile("uuuuuuuuuuu", ".xlsx", new File(base));
    ByteSink byteSink = Files.asByteSink(f);

    // 3. 具体要保存的数据
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", "张三");
    map.put("age", 10);
    map.put("pwd", "aqqbcs");

    // 4. 按照模版将数据写到本地磁盘
    Workbook exportExcel = ExcelExportUtil.exportExcel(params, map);
    exportExcel.write(byteSink.openStream());
    System.out.println(f.getAbsolutePath());
  }
}
