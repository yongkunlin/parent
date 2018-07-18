package com.bamboo.core.util;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具类
 * Created by yklin on 2018/5/29.
 */
public class VerifyCodeUtil {

    //图片宽度
    private static final int default_width = 106;
    //图片高度
    private static final int default_height = 40;
    // 验证码字符个数
    private static final int codeCount = 4;

    // 验证码
    private String code = null;
    // 验证码图片Buffer
    private BufferedImage buffImg = null;

    private static Random random = new Random();

    // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
    private static final char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String getSimpleCode(){
        // randomCode记录随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        // 随机产生codeCount个字符的验证码。
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        // 将四位数字的验证码保存到Session中。
        return randomCode.toString();
    }
}
