package com.example.shopping_cart.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    // Đọc chuỗi giá trị của tham số
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }    

    // Đọc số nguyên giá trị của tham số
    public int getInt(String name, int defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Integer.parseInt(value);
    }

    // Đọc số thực giá trị của tham số
    public double getDouble(String name, double defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Double.parseDouble(value);
    }

    // Đọc giá trị boolean của tham số
    public boolean getBoolean(String name, boolean defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Boolean.parseBoolean(value);
    }

    // Đọc giá trị thời gian của tham số
    public Date getDate(String name, String pattern) {
        String value = getString(name, "");
        try {
            return new SimpleDateFormat(pattern).parse(value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    // Lưu file upload vào thư mục
    public File save(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            File dir = new File(request.getServletContext().getRealPath(path));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try {
                File saveFiled = new File(dir, file.getOriginalFilename());
                file.transferTo(saveFiled);
                return saveFiled;
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return null;
    }
}
