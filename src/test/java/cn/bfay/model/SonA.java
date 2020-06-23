package cn.bfay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SonA extends FatherA {
    private int age;

    public static void main(String[] args) {
        SonA a = new SonA();
        System.out.println("----" + a.getName());
    }
}