package com.test.base_java;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Test2_WordCount {
  public static void main(String[] args) throws Exception {
    /////////////////////// 设置hadoop本地库
    System.setProperty("hadoop.home.dir", "D:/fluffy/dev/hadoop/hadoop-common-2.2.0-bin");

    Configuration conf = new Configuration();
    conf.set("fs.default.name", "hdfs://172.18.0.2:9000/");

    /////////////////////// cluster begin --------------------
    // 提交到集群中
    conf.set("mapreduce.framework.name", "yarn");
    conf.set("yarn.resourcemanager.hostname", "172.18.0.2");

    // 远程提交需设置此参数，从hadoop_2.6开始支持此参数
    conf.set("mapreduce.app-submission.cross-platform", "true");
    /////////////////////// cluster end --------------------

    /////////////////////// 貌似没有效果
    // System.setProperty("HADOOP_USER_NAME", "root1"); //默认身份为dr.who
    // conf.set("hadoop.job.user", "root2");
    // 指定jobtracker的ip和端口号
    // conf.set("mapred.job.tracker", "172.18.0.2:9001");//貌似没有效果,获取是因为默认就是9001吧

    /////////////////////// 执行具体任务
    Job job = Job.getInstance(conf, "word count");
    // !!! 运行在集群上需先将项目打jar包，否则ClassNotFoundException原因不明
    job.setJar("test1_mapreduce.jar"); // 需要将项目打成jar包
    job.setJarByClass(com.test.base_java.Test2_WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    // 可以添加多个输入源
    FileInputFormat.addInputPath(job, new Path("/test_word.txt"));
    FileOutputFormat.setOutputPath(job, new Path("/test6"));

    // 等待执行结果
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }

  public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
      }
    }
  }

  public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
    }
  }

}