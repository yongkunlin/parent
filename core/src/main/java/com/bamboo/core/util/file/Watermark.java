package com.bamboo.core.util.file;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 图片添加水印
 * Created by yklin on 2018/6/14.
 */
public class Watermark {
    /**
     * @param srcImgPath       源图片路径
     * @param tarImgPath       保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font             水印字体
     */
    public void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {

        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            System.out.println("获取图片的宽================" + srcImgWidth);
            System.out.println("获取图片的高================" + srcImgHeight);
            //设置水印的坐标
            int x = 20;
            int y = srcImgHeight - 10;
            g.drawString(waterMarkContent, x, y);  //画出水印
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            System.out.println("添加水印完成");
            outImgStream.flush();
            outImgStream.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    public static void main(String[] args) {

        File file = new File("C:/Users/yklin/Desktop/1623423456112.jpg");
//        System.out.println(file.getPath());
//        String fileName = file.getName();
//        int index = fileName.indexOf(".");
//        String name = fileName.substring(0, index);
//        String suffix = fileName.substring(index);
//        System.out.println(name);
//        System.out.println(suffix + "_WaterMark");
//        System.out.println(substring0);
        Font font = new Font(null, Font.BOLD, 20);                     //水印字体
//        String srcImgPath = "C:/Users/yklin/Desktop/1623423456112.jpg"; //源图片地址
//        String tarImgPath = "C:/Users/yklin/Desktop/new1623423456112.jpg"; //待存储的地址
        String srcImgPath = "C:/Users/yklin/Desktop/2222111.jpg"; //源图片地址
        String tarImgPath = "C:/Users/yklin/Desktop/new2222111.jpg"; //待存储的地址
        String waterMarkContent = "2018-06-14";  //水印内容
        Color color = new Color(255, 255, 255, 128);                               //水印图片色彩以及透明度
        new Watermark().addWaterMark(srcImgPath, tarImgPath, waterMarkContent, Color.red, font);

    }
}
