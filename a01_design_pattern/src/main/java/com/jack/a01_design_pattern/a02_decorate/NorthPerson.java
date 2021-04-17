package com.jack.a01_design_pattern.a02_decorate;

/**
 * @创建者 Jack
 * @创建时间 2021/4/17 11:35
 * @描述
 */
public class NorthPerson extends Human{

    public NorthPerson() {
        super();
    }

    @Override
    public void food() {
        System.out.println("北方人的主食是面条");
    }

}
