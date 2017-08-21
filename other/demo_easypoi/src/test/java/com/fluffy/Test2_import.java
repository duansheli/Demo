
package com.fluffy;

import java.io.File;
import java.util.List;

import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.imports.ExcelImportServer;

import com.google.common.io.ByteSource;
import com.google.common.io.Files;

public class Test2_import {
  static String basePath;
  /**
   * <pre>
   * 从excel文件导入数据
   * 
   * 读取的时候，当判断第一列有数据，则判定该行有数据
   * </pre>
   */
  public static void main(String[] args) throws Exception {
    // PoiPublicUtil.g etWebRootPath(filePath)
    // 1. 需要导入的Excel文件
    File f = new File("src/test/resources/DMP渠道行政信息导入.xlsx");
    ByteSource source = Files.asByteSource(f);

    // 2. 设置导入参数
    ImportParams params = new ImportParams();
    params.setHeadRows(2);

//    String[] fs = { "用户名", "密码", "年龄" };
//    params.setImportFields(fs);

    ExcelImportServer server = new ExcelImportServer();
    List<OaBranchAib> list = server.importExcelByIs(source.openStream(), OaBranchAib.class, params).getList();
    System.err.println("输出---------");
    System.err.println("---------");

    for (OaBranchAib user2 : list) {
        System.out.println(user2.getBname() );
      System.out.println(user2.getPersonalSealStatus() + user2.getPersonalSeal() + user2.getPrincipal());
    }
    System.out.println("done " + f.length() + f.getAbsolutePath());
  }
}
