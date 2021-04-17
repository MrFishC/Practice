package com.jack.a01_design_pattern.a02_decorate;

/**
 * @创建者 Jack
 * @创建时间 2021/4/17 11:32
 * @描述
 */
public class DecorateClent {
    public static void main(String[] arg){

        System.out.println("南方人===未增加装饰对象");
        SouthPerson southPerson = new SouthPerson();
        southPerson.food();

        System.out.println("南方人===增加装饰对象");
        SouthPersonDecorator southPersonDecorator = new SouthPersonDecorator(southPerson);
        southPersonDecorator.food();

        System.out.println("北方人===未增加装饰对象");
        NorthPerson northPerson = new NorthPerson();
        northPerson.food();

        System.out.println("北方人===增加装饰对象");
        NorthPersonDecorator northPersonDecorator = new NorthPersonDecorator(northPerson);
        northPersonDecorator.food();

    }


}
