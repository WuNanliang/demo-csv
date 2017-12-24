package com.example.demo.service;

import com.example.demo.CsvUtils;
import com.example.demo.dto.UserExportToCsvDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 为了方便，就不写接口和实现分离了
 *
 * @author wunanliang
 * @date 2017/12/24
 * @since 1.0.0
 */
@Service
public class FileService {


    /**
     * 导出用户到csv文件
     *
     * @param users 导出的数据（用户）
     * @return
     */
    public byte[] exportUsersToCsv(List<UserExportToCsvDTO> users) {
        // 为了方便，也不写dao层
        List<LinkedHashMap<String, Object>> exportData = new ArrayList<>(users.size());
        // 行数据
        for (UserExportToCsvDTO user : users) {
            LinkedHashMap<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("1", user.getUsername());
            rowData.put("2", user.getNickname());
            rowData.put("3", user.getLevel());
            exportData.add(rowData);
        }
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("1", "用户账号");
        header.put("2", "用户昵称");
        header.put("3", "用户等级");
        return CsvUtils.exportCSV(header, exportData);
    }

}
