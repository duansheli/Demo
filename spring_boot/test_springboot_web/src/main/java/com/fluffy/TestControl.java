package com.fluffy;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "d")
public class TestControl {

    @RequestMapping(value = "a")
    public ResponseEntity<String> aa() {
        String msg = "{'stat':2001, data:'hello world'}";
        HttpHeaders headers = new HttpHeaders();

        headers.set("MyResponseHeader", "MyValue");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // return ResponseEntity.ok(msg);
        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "b/{userId:^\\d+$}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<String> findUser(@PathVariable("userId") Integer userId) {
        // 返回值为json类型
        System.out.println("查询用户 " + userId);
        String user = "{'name':'张三', age:5 }";
        return new ResponseEntity<String>("添加失败", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "c")
    public ResponseEntity<String> addUser(String name) {
        // @GetMapping
        // @PutMapping
        // @DeleteMapping
        System.out.println("添加用户 " + name);
        return new ResponseEntity<String>("添加失败", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "download")
    public void download(HttpServletResponse response) throws IOException {
        System.out.println("文件下载 ");
        response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
        response.setHeader("Content-Disposition", "attachment;fileName=" + "a.txt");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write("abc".getBytes());
        outputStream.close();
    }

    @GetMapping(value = "download2")
    public ResponseEntity<byte[]> download2(HttpServletResponse response) throws IOException {
        String msg = "{'stat':2001, data:'hello world'}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "你好.txt", StandardCharsets.UTF_8);

        return new ResponseEntity<byte[]>(msg.getBytes(), headers, HttpStatus.OK);
    }

    @GetMapping(value = "e")
    public ResponseEntity<String> e(String name) throws URISyntaxException {
        System.out.println("添加用户 " + name);
        return ResponseEntity.badRequest().header("MyResponseHeader", "MyValue").body("Hello World");
    }

    @PostMapping(value = "f")
    @ResponseBody
    public ResponseEntity f(@RequestBody User user) throws URISyntaxException {
        System.out.println("接收一个json对象，并转为实体类");
        return ResponseEntity.ok().body("hello");
    }

}

class User {
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
