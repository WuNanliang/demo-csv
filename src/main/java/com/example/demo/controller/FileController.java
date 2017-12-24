package com.example.demo.controller;

import com.example.demo.dto.UserExportToCsvDTO;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wunanliang
 * @date 2017/12/24
 * @since 1.0.0
 */
@RestController
public class FileController {


    @Autowired
    private FileService fileService;

    @PostMapping("/api/v1/export/csv/users")
    public void exportCsv(HttpServletResponse response, HttpServletRequest request) throws IOException {

        // 模拟导出数据，这里数据可以是从数据库获取回来的，也可以是前端传过来再解析的
        // 这里的数据应该放在dao层获取的，就先简单放在这里，大家不必介意，只是demo演示
        List<UserExportToCsvDTO> users = new ArrayList<>();
        users.add(new UserExportToCsvDTO("13800138001", "圣诞老人1", "VIP1"));
        users.add(new UserExportToCsvDTO("13800138002", "圣诞老人2", "VIP7"));
        users.add(new UserExportToCsvDTO("13800138003", "圣诞老人3", "VIP8"));
        // csv文件名字，为了方便默认给个名字，当然名字可以自定义，看实际需求了
        String fileName = "我是csv文件.csv";
        // 解决不同浏览器出现的乱码
        fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
        FileCopyUtils.copy(fileService.exportUsersToCsv(users), response.getOutputStream());
    }
}
