package com.studyyang.function_pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

/**
 * @author： SheepJin
 * @date： 2022/2/20 - 10:13 AM
 * @description： 2、给pdf创建页面
 * @modifiedBy：
 */
public class AddPdfPage {

    public static void addPage() throws IOException {
        //创建pdf文档对象
        PDDocument document = new PDDocument();

        //添加空白页面
        PDPage pdPage = new PDPage();
        document.addPage(pdPage);

        //创建pdf
        String fileSavePath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
                + File.separator + "dev" + File.separator + "pdfbox.pdf";
        System.out.println("系统桌面路径：" + fileSavePath);
        document.save(fileSavePath);

        //关闭文档流
        document.close();
    }

    public static void main(String[] args) throws IOException {
        AddPdfPage.addPage();
    }

}