package cn.bfay.sourcecode;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * MyBean2.
 *
 * @author wangjiannan
 * @since 2019/11/27
 */
//@Order(value = 1)
public class MyBean2 {
    @Autowired
    private MyBean myBean;
}
