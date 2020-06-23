package cn.bfay;

import cn.bfay.model.Employee;
import org.junit.Test;

public class ReflectTest {

    @Test
    public void test() {
        // 第一、通过Class.forName方式
        Class clazz1 = null;
        try {
            clazz1 = Class.forName("cn.bfay.model.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 第二、通过对象实例方法获取对象
        Class clazz2 = Employee.class;

        // 第三、通过Object类的getClass方法
        Employee employee = new Employee();
        Class clazz3 = employee.getClass();

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);


        // 获取对象实例
        Employee employee1 = null;
        try {
            employee1 = (Employee) clazz1.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        employee1.setName("终结者");
        System.out.println("employee1:" + employee1.toString());
    }
}