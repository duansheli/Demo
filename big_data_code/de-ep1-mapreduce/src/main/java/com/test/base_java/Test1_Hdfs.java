package com.test.base_java;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Test1_Hdfs {
  public static void main(String[] args) throws IOException {
    String hdfs_path = "hdfs://172.18.0.2:9000/";
    System.setProperty("hadoop.home.dir", "D:/fluffy/dev/hadoop/hadoop-common-2.2.0-bin");

    Configuration conf = new Configuration();
    conf.set("fs.default.name", hdfs_path);
    FileSystem fs = FileSystem.get(conf);
    // 上传文件 将文件写入hdfs上
    final FSDataOutputStream out = fs.create(new Path("/test_word.txt"));
    final FileInputStream in = new FileInputStream("D:/hadoop-pipes/WordCount.java");
    IOUtils.copyBytes(in, out, 1024, true);

  }
}
