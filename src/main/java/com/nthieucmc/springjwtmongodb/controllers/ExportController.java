package com.nthieucmc.springjwtmongodb.controllers;

import com.nthieucmc.springjwtmongodb.dto.UserDTO;
import com.nthieucmc.springjwtmongodb.dto.response.BaseResponseDTO;
import com.nthieucmc.springjwtmongodb.service.UserService;
import com.nthieucmc.springjwtmongodb.utils.UserExcelExporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ExportController {
    @Resource
    UserService userService;

    @GetMapping("/export-user")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headKey = "Content-Disposition";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormat.format(new Date());
        String fileName = "users_" + currentDateTime + ".xlsx";

        String headValue = "attachement; filename=" + fileName;

        response.setHeader(headKey, headValue);

        List<UserDTO> listUser = userService.getListUser();

        UserExcelExporter excelExporter = new UserExcelExporter(listUser);
        excelExporter.export(response);
    }}
