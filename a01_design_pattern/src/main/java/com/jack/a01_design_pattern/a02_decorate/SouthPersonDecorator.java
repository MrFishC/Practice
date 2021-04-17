package com.jack.a01_design_pattern.a02_decorate;

/**
 * @创建者 Jack
 * @创建时间 2021/4/17 11:38
 * @描述
 */
public class SouthPersonDecorator extends Human{

    private Human mHuman;

    public SouthPersonDecorator(Human human) {
        mHuman = human;
    }

    @Override
    public void food() {
        System.out.println("啤酒");
    }

}
