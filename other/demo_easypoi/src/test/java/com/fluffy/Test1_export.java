
package com.fluffy;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;

import com.google.common.collect.Lists;
import com.google.common.io.ByteSink;
import com.google.common.io.Files;

import lombok.Data;

public class Test1_export {
  static String basePath;

  /**
   * <pre>
   * 将数据导出为excel文件
   * 
   * 1. User1.name User1.pwd 顺序通过注解orderNum控制
   * </pre>
   */
  public static void main(String[] args) throws Exception {
    String base = System.getProperty("user.dir");
    // 1.设置文件保存在demo_easypoi项目的根目录
    File f = File.createTempFile("uuuuuuuuuuu", ".xlsx", new File(base));
    ByteSink byteSink = Files.asByteSink(f);

    // 2. 需要导出的数据
    ArrayList<User1> list = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      User1 user = new User1();
      user.setName("hello" + i);
      user.setAge("" + 10 + i);
      user.setPwd("ppppp" + i);
      list.add(user);
    }

    // 3. 设置导出参数
    ExportParams param = new ExportParams("title:用户列表", "sheet111", ExcelType.XSSF);
    param.setFreezeCol(1);// 设置第一列在左右移动时固定
    param.setAddIndex(true);// 加一列编号1...N

    // 4. 导出
    Workbook exportExcel = ExcelExportUtil.exportExcel(param, User1.class, list);
    exportExcel.write(byteSink.openStream());

    System.out.println("done " + f.getAbsolutePath());
  }
}

@Data
class User1 {
  @Excel(name = "姓名", orderNum = "5")
  String name;
  @Excel(name = "密码", orderNum = "3")
  String pwd;
  @Excel(name = "年龄", orderNum = "4", isStatistics = true)
  String age;
}
