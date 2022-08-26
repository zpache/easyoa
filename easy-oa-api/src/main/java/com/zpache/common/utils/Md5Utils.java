package com.zpache.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @desc: md5加密算法
 * @author: Ryan
 * @createTime: 2021/7/6 8:02 下午
 */
public class Md5Utils {

    public static String md5(String plainText) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] md5bytes = messageDigest.digest(plainText.getBytes());
            return Hex.encodeHexString(md5bytes).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
