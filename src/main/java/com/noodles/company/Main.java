package com.noodles.company;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        System.out.println();
//        String url = "https://s3.meituan.net/v1/mss_8828ac18af9a48fe85ae212f487e4516/mt-joy-merchant/cc26a7a0d14753c1efcd2017d192f293.mp4";
//        String url = "https://s3.meituan.net/v1/mss_8828ac18af9a48fe85ae212f487e4516/mt-joy-merchant/739b21c01cd81d808891bb4c46e33b0d.mp4";
        String url = "https://s3.meituan.net/v1/mss_8828ac18af9a48fe85ae212f487e4516/mt-joy-merchant/5e058e8f10cddecabd65c0cba13a9012.mp4";
        FFmpegFrameGrabber g = new FFmpegFrameGrabber(url);
        g.setSampleRate(1);
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage image = null;
        g.start();
        long lengthInTime = g.getLengthInTime();
        double frameRate = g.getFrameRate();
        int _frameRate = (int)frameRate;
        int lengthInFrames = g.getLengthInFrames();
        for (int i = 1; i <= lengthInFrames; i+=(5*_frameRate)) {
            System.out.println(i);
            try {
                if (i > 0) g.setFrameNumber(i);
                Frame frame = g.grabFrame();
                if (frame != null) {
                    ImageIO.write(converter.convert(frame), "jpg", new File("/Users/gaoxinwei/Desktop/grab_pic/" + i + ".png"));
                } else {
                    System.out.println(i + " escape");
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        g.stop();

        long end = System.currentTimeMillis();
        System.out.println((start - end) / 1000 + "s");
    }
}
