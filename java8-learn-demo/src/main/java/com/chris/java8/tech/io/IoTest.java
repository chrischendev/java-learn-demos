package com.chris.java8.tech.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * create by: Chris Chan
 * create on: 2019/9/7 11:58
 * use for:
 */
public class IoTest {
    public static void main(String[] args) throws Exception {
//        testInput();
//        testOutput();
//        testReader();
//        testWrite();
//        testBufferedReader();
        testBufferedWriter();
//        testCopyFile();
//        testCopyTxtFile();
    }

    /**
     * 测试 字节输入流
     */
    private static void testInput() throws IOException {
        String srcFilePath = "D://temp/file/in_test.txt";

        File srcFile = new File(srcFilePath);

        if (!srcFile.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(srcFile);
        //字节数组 缓冲区
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            String str = new String(bytes, 0, len);
            sb.append(str);
        }
        System.out.println(sb.toString());

        fis.close();

    }

    /**
     * 测试 字节输出流
     */
    private static void testOutput() throws IOException {
        String tgtFilePath = "D:\\temp\\file\\out_test.txt";

        File tgtFile = new File(tgtFilePath);

        if (!tgtFile.exists()) {
            tgtFile.createNewFile();
        }

        String str = "正月里来是新春";
        FileOutputStream fos = new FileOutputStream(tgtFile);
        fos.write(str.getBytes(Charset.forName("UTF-8")));

        fos.flush();
        fos.close();
    }

    /**
     * 测试 字符输入流
     */
    private static void testReader() throws IOException {
        String srcFilePath = "D://temp/file/in_test.txt";

        File srcFile = new File(srcFilePath);

        if (!srcFile.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(srcFile);
        //字符数组 缓冲区
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1) {
            String str = new String(chars, 0, len);
            sb.append(str);
        }
        System.out.println(sb.toString());

        fr.close();
    }

    /**
     * 测试 字符输出流 适合输出包括文本文件以及其他如图片、音乐、视频、软件等全部文件
     */
    private static void testWrite() throws IOException {
        String tgtFilePath = "D://temp/file/out_test_02.txt";

        File tgtFile = new File(tgtFilePath);

        if (!tgtFile.exists()) {
            tgtFile.createNewFile();
        }
        String str = "八月十五月儿明，爷爷为我打月饼";
        FileWriter fw = new FileWriter(tgtFile);
        fw.write(str);

        fw.flush();
        fw.close();
    }

    /**
     * 测试 缓冲读取
     */
    private static void testBufferedReader() throws IOException {
        String srcFilePath = "D://temp/file/in_test.txt";

        File srcFile = new File(srcFilePath);

        if (!srcFile.exists()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(srcFile);

        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        //字符数组 缓冲区
        char[] chars = new char[1024];
        int len;
        while ((len = br.read(chars)) != -1) {
            String str = new String(chars, 0, len);
            sb.append(str);
        }
        System.out.println(sb.toString());

        fis.close();
    }

    /**
     * 测试缓冲写入
     */
    private static void testBufferedWriter() throws IOException {
        String tgtFilePath = "D:\\temp\\file\\out_test_03.txt";

        File tgtFile = new File(tgtFilePath);

        if (!tgtFile.exists()) {
            tgtFile.createNewFile();
        }

        String str = "烧花鸭烧子鹅";
        FileOutputStream fos = new FileOutputStream(tgtFile);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        bw.write(str);

        bw.flush();
        bw.close();
        osw.close();
        fos.close();
    }

    /**
     * 测试 文件复制
     */
    private static void testCopyFile() throws IOException {
        //源文件 输入流部分
        String srcFilePath = "D:\\temp\\file\\v.mp4";
        File srcFile = new File(srcFilePath);
        if (!srcFile.exists()) {
            return;
        }
        FileInputStream fis = new FileInputStream(srcFile);


        //目标文件 输出流部分
        String tgtFilePath = "D:\\temp\\file\\v_copy.mp4";
        File tgtFile = new File(tgtFilePath);
        if (!tgtFile.exists()) {
            tgtFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(tgtFile);

        //复制
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            //边读边写
            fos.write(bytes,0,len);
        }

        //关闭流 倒序
        fos.flush();
        fos.close();
        fis.close();
    }

    /**
     * 测试 文本文件复制 使用字符流进行读写
     */
    private static void testCopyTxtFile() throws IOException {
        //源文件 输入流部分
        String srcFilePath = "D:\\temp\\file\\io_copy_test.txt";
        File srcFile = new File(srcFilePath);
        if (!srcFile.exists()) {
            return;
        }
        FileReader fr = new FileReader(srcFile);


        //目标文件 输出流部分
        String tgtFilePath = "D:\\temp\\file\\io_copy_test_02.txt";
        File tgtFile = new File(tgtFilePath);
        if (!tgtFile.exists()) {
            tgtFile.createNewFile();
        }
        FileWriter fw=new FileWriter(tgtFile);

        //复制
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1) {
            //边读边写
            fw.write(chars,0,len);
        }

        //关闭流 倒序
        fw.flush();
        fw.close();
        fr.close();
    }
}
