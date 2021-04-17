package com.jack.a01_design_pattern.a02_decorate;

/**
 * @创建者 Jack
 * @创建时间 2021/4/17 11:38
 * @描述
 */
public class NorthPersonDecorator extends Human{
    private Human mHuman;

    public NorthPersonDecorator(Human human) {
        mHuman = human;
    }

    @Override
    protected void food() {
        System.out.println("白酒");
    }

}
