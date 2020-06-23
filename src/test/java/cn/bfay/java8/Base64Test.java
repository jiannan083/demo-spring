package cn.bfay.java8;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * Base64Test.
 *
 * @author wangjiannan
 */
public class Base64Test {
    // 基本：输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
    // URL：输出映射到一组字符A-Za-z0-9+_，输出是URL和文件。
    // MIME：输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割。

    @Test
    public void testBase64() throws UnsupportedEncodingException {
        String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
        System.out.println("Base64 编码字符串(基本):" + base64encodedString);
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("Base64 解码字符串(基本):" + new String(base64decodedBytes, "utf-8"));
        System.out.println("Base64 解码字符串(基本):runoob?java8");

        base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
        System.out.println("Base64 编码字符串(URL):" + base64encodedString);
        base64decodedBytes = Base64.getUrlDecoder().decode(base64encodedString);
        System.out.println("Base64 解码字符串(URL):" + new String(base64decodedBytes, "utf-8"));
        System.out.println("Base64 原始字符串(URL):TutorialsPoint?java8");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
        }
        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64 编码字符串(MIME):" + mimeEncodedString);
        byte[] mimedecodeBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
        System.out.println("Base64 解码字符串(MIME):" + new String(mimedecodeBytes, "utf-8"));
        System.out.println("Base64 原始字符串(MIME):" + stringBuilder.toString());


        System.out.println(UUID.randomUUID().toString().length());
    }
}
