package com.studyyang.function_pdf;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

/**
 * @author： SheepJin
 * @date： 2022/2/20 - 10:13 AM
 * @description： 1、创建新的pdf文档
 * @modifiedBy：
 */
public class CreateNewPdfFile {

    public static void createNewPdfFile() throws IOException {
        //创建pdf文档对象
        PDDocument document = new PDDocument();

        //省略一些操作。。。。

        //创建pdf
        String fileSavePath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()
                + File.separator + "dev" + File.separator + "pdfbox.pdf";
        System.out.println("系统桌面路径：" + fileSavePath);
        document.save(fileSavePath);

        //关闭文档流
        document.close();
    }

    public static void main(String[] args) throws IOException {
        //只生成不添加页面的pdf是损坏的
        CreateNewPdfFile.createNewPdfFile();
    }

}