package cn.bfay.hanlp;

import org.junit.Test;

/**
 * HanlpTest.
 *
 * @author wangjiannan
 */
public class HanlpTest {
    @Test
    public void testHanlp() {
        // String s1 = "我是开发，你谁谁，fasdfdas.。 范德萨发答案是否都是  ，范德萨发生的！发送到发大发@fdsasdfasv 。";
        // String s1 = "你谁谁，发送到 范德萨发多少。ad所发生的的说法.发送理解女方没收到看电视可哈什蚂办法没带手机空格分割热量计划委托人和女孩杜尔决定性的";
        String s1 = "ad所发生的的说法;投票来看骗人的嘉宾我我玉兔一体UI哦我我我和是我会会卡萨会计师订舱单法师你谁谁，发送到 范德萨发多少。";
        String s2 = "你谁谁，发送到 范德萨发多少。ad所发生的的说法;投票来看骗人的嘉宾我我玉兔一体UI哦我我我和是我会会卡萨会计师订舱单法师";

        MySimHash hash1 = new MySimHash(s1, 64);
        MySimHash hash2 = new MySimHash(s2, 64);
        System.out.println(hash1.getSemblance(hash2));
    }

}
