package com.example.demo.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    private static RowHandler createRowHandler(final List<List> lists){
        return new RowHandler() {
            @Override
            public void handle(int i, long l, List<Object> list) {
                lists.add(list);
            }
        };
    }

    void readExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        List<List> list = new ArrayList<List>();
        Excel07SaxReader reader = new Excel07SaxReader(createRowHandler(list));

        reader.read(inputStream, 0);
    }

    public static void main(String[] args) throws Exception {
        OutputStream outputStreamExcel = null;
        File tmpFile = new File("E:" + File.separator + "file_route" + File.separator + "detail.xlsx");
        if (!tmpFile.getParentFile().exists()) {
            tmpFile.getParentFile().mkdirs();//创建目录
        }
        if(!tmpFile.exists()) {
            tmpFile.createNewFile();//创建文件
        }
        Workbook workbook = null;
        workbook = new XSSFWorkbook();//创建Workbook对象(excel的文档对象)
        Sheet sheet1 = workbook.createSheet("Sheet1");// 建建sheet对象（excel的表单）

        // 定义单元格背景色
        ExcelWriter writer = null;
        StyleSet style0 = writer.getStyleSet();
// 第二个参数表示是否也设置头部单元格背景
        style0.setBackgroundColor(IndexedColors.RED, false);
        // 设置单元格字体
        Font headerFont = workbook.createFont(); // 字体
        headerFont.setFontHeightInPoints((short)14);
        headerFont.setFontName("黑体");
//        // 设置单元格边框及颜色
//        CellStyle style = workbook.createCellStyle();
//        style.setBorderBottom(BorderStyle.valueOf((short)1));
//        style.setBorderLeft(BorderStyle.valueOf((short)1));
//        style.setBorderRight(BorderStyle.valueOf((short)1));
//        style.setBorderTop(BorderStyle.valueOf((short)1));
//        style.setWrapText(true);

        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("编号");
        row.createCell(2).setCellValue("支付订单号");
        row.createCell(3).setCellValue("商品订单号");

        Row row1 = sheet1.createRow(1);
        row1.createCell(0).setCellValue("10001");
        row1.createCell(1).setCellValue("90001");
        row1.createCell(2).setCellValue("1000000000012");
        row1.createCell(3).setCellValue("9000000000099");

        outputStreamExcel = new FileOutputStream(tmpFile);
        workbook.write(outputStreamExcel);
        outputStreamExcel.flush();
        outputStreamExcel.close();
    }

//    public static void main(String[] args) throws IOException {
////        ExcelUtils excelUtils = new ExcelUtils();
////        File file = new File("E:\\IdeaWork\\hello.spring.boot\\src\\main\\java\\com\\example\\demo\\excel\\test.xlsx");
////        FileInputStream fileInputStream = new FileInputStream(file);
////        MockMultipartFile mockMultipartFile = new MockMultipartFile(file.getName(), fileInputStream);
////
////        for (User u: excelUtils.readExcel(mockMultipartFile)) {
////            System.out.println(u);
////        }
//
//        ExcelReader reader = ExcelUtil.getReader("E:\\IdeaWork\\hello.spring.boot\\src\\main\\java\\com\\example\\demo\\excel\\test.xlsx");
//        List<List<Object>> readAll = reader.read();
//
//        for (List<Object> l: readAll) {
//            System.out.println(l);
////            for (Object a: l) {
////                System.out.println(a);
////            }
//        }
//    }

}
