package com.cad.demo.service.xieweihaoService;

import org.springframework.stereotype.Service;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class OcrService{
    //识别图片具体代码
    public String readArticle(File img, String lan) throws Exception {
        String orcResult = null;
        ITesseract iTesseract = new Tesseract();
        iTesseract.setDatapath("/usr/local/share/tessdata");
        iTesseract.setLanguage(lan);
        BufferedImage binaryImage = null;
        BufferedImage bi = ImageIO.read(img);
        binaryImage = binaryImage(bi);
        binaryImage = denoise(binaryImage);
        //File img = new File(img_path);
        orcResult = iTesseract.doOCR(binaryImage);
        //orcResult = iTesseract.doOCR(img);
        return orcResult;
    }

    public static BufferedImage binaryImage(BufferedImage image) throws Exception {
        int w = image.getWidth();
        int h = image.getHeight();
        float[] rgb = new float[3];
        double[][] zuobiao = new double[w][h];
        int black = new Color(0, 0, 0).getRGB();
        int white = new Color(255, 255, 255).getRGB();
        BufferedImage bi= new BufferedImage(w, h,
                BufferedImage.TYPE_BYTE_BINARY);;
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int pixel = image.getRGB(x, y);
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                float avg = (rgb[0]+rgb[1]+rgb[2])/3;
                zuobiao[x][y] = avg;

            }
        }

        //这里是阈值，白底黑字还是黑底白字，大多数情况下建议白底黑字，后面都以白底黑字为例
        double SW = 192;
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (zuobiao[x][y] < SW) {
                    bi.setRGB(x, y, black);
                }else{
                    bi.setRGB(x, y, white);
                }
            }
        }
        return bi;
    }

    public static BufferedImage denoise(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        int white = new Color(255, 255, 255).getRGB();

        if(isWhite(image.getRGB(1, 0)) && isWhite(image.getRGB(0, 1)) && isWhite(image.getRGB(1, 1))){
            image.setRGB(0,0,white);
        }
        if(isWhite(image.getRGB(w-2, 0)) && isWhite(image.getRGB(w-1, 1)) && isWhite(image.getRGB(w-2, 1))){
            image.setRGB(w-1,0,white);
        }
        if(isWhite(image.getRGB(0, h-2)) && isWhite(image.getRGB(1, h-1)) && isWhite(image.getRGB(1, h-2))){
            image.setRGB(0,h-1,white);
        }
        if(isWhite(image.getRGB(w-2, h-1)) && isWhite(image.getRGB(w-1, h-2)) && isWhite(image.getRGB(w-2, h-2))){
            image.setRGB(w-1,h-1,white);
        }

        for(int x = 1; x < w-1; x++){
            int y = 0;
            if(isBlack(image.getRGB(x, y))){
                int size = 0;
                if(isWhite(image.getRGB(x-1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y+1))){
                    size++;
                }
                if(isWhite(image.getRGB(x-1, y+1))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y+1))){
                    size++;
                }
                if(size>=5){
                    image.setRGB(x,y,white);
                }
            }
        }
        for(int x = 1; x < w-1; x++){
            int y = h-1;
            if(isBlack(image.getRGB(x, y))){
                int size = 0;
                if(isWhite(image.getRGB(x-1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y-1))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y-1))){
                    size++;
                }
                if(isWhite(image.getRGB(x-1, y-1))){
                    size++;
                }
                if(size>=5){
                    image.setRGB(x,y,white);
                }
            }
        }

        for(int y = 1; y < h-1; y++){
            int x = 0;
            if(isBlack(image.getRGB(x, y))){
                int size = 0;
                if(isWhite(image.getRGB(x+1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y+1))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y-1))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y-1))){
                    size++;
                }
                if(isWhite(image.getRGB(x+1, y+1))){
                    size++;
                }
                if(size>=5){
                    image.setRGB(x,y,white);
                }
            }
        }

        for(int y = 1; y < h-1; y++){
            int x = w - 1;
            if(isBlack(image.getRGB(x, y))){
                int size = 0;
                if(isWhite(image.getRGB(x-1, y))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y+1))){
                    size++;
                }
                if(isWhite(image.getRGB(x, y-1))){
                    size++;
                }
                //斜上下为空时，去掉此点
                if(isWhite(image.getRGB(x-1, y+1))){
                    size++;
                }
                if(isWhite(image.getRGB(x-1, y-1))){
                    size++;
                }
                if(size>=5){
                    image.setRGB(x,y,white);
                }
            }
        }

        //降噪，以1个像素点为单位
        for(int y = 1; y < h-1; y++){
            for(int x = 1; x < w-1; x++){
                if(isBlack(image.getRGB(x, y))){
                    int size = 0;
                    //上下左右均为空时，去掉此点
                    if(isWhite(image.getRGB(x-1, y))){
                        size++;
                    }
                    if(isWhite(image.getRGB(x+1, y))){
                        size++;
                    }
                    //上下均为空时，去掉此点
                    if(isWhite(image.getRGB(x, y+1))){
                        size++;
                    }
                    if(isWhite(image.getRGB(x, y-1))){
                        size++;
                    }
                    //斜上下为空时，去掉此点
                    if(isWhite(image.getRGB(x-1, y+1))){
                        size++;
                    }
                    if(isWhite(image.getRGB(x+1, y-1))){
                        size++;
                    }
                    if(isWhite(image.getRGB(x+1, y+1))){
                        size++;
                    }
                    if(isWhite(image.getRGB(x-1, y-1))){
                        size++;
                    }
                    if(size>=8){
                        image.setRGB(x,y,white);
                    }
                }
            }
        }

        return image;
    }

    public static boolean isBlack(int colorInt)
    {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() <= 300)
        {
            return true;
        }
        return false;
    }

    public static boolean isWhite(int colorInt)
    {
        Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() > 300)
        {
            return true;
        }
        return false;
    }

    public static int isBlack(int colorInt, int whiteThreshold) {
        final Color color = new Color(colorInt);
        if (color.getRed() + color.getGreen() + color.getBlue() <= whiteThreshold) {
            return 1;
        }
        return 0;
    }





}
