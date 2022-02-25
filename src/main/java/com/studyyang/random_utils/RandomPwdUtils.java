package com.studyyang.random_utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： SheepJin
 * @date： 2022/2/24 - 4:12 PM
 * @description： 随机密码工具类
 * @modifiedBy：
 */
public class RandomPwdUtils {

    //定义密码组成字符
    public static final char[] upCaseLetter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] lowCaseLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] specialChar = {'.', '+', ')', '(', '_', '!', '@', '#', '$', '%', '^', '&', '*'};

    public static String randomStrByChar(int length) {

        //将长度限制于6-32位
        length = Math.max(length, 6);
        length = Math.min(length, 32);

        //获取非特殊字符和特殊字符的每种组成字符的所需个数
        int noSpecialCharNum = (length / 3) - 1;
        int specialCharNum = length - noSpecialCharNum * 3;

        //生成指定位数随机字符
        StringBuilder resetPwd = new StringBuilder();
        List<String> resetPwdChar = Arrays.stream(resetPwd.append(RandomStringUtils.random(noSpecialCharNum, upCaseLetter))
                .append(RandomStringUtils.random(noSpecialCharNum, lowCaseLetter))
                .append(RandomStringUtils.random(noSpecialCharNum, num))
                .append(RandomStringUtils.random(specialCharNum, specialChar))
                .toString().split("")).collect(Collectors.toList());

        //将生成的密码字符的顺序进行打乱
        Collections.shuffle(resetPwdChar);
        StringBuilder shufflePwdChar = new StringBuilder();
        resetPwdChar.forEach(shufflePwdChar::append);

        return shufflePwdChar.toString();
    }

    public static void main(String[] args) {
        System.out.println(RandomPwdUtils.randomStrByChar(9));
        System.out.println(RandomPwdUtils.randomStrByChar(18));
        System.out.println(RandomPwdUtils.randomStrByChar(32));
    }
}
