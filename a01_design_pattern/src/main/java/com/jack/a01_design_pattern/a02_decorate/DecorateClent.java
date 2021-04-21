package com.jack.a01_design_pattern.a02_decorate;

/**
 * @创建者 Jack
 * @创建时间 2021/4/17 11:32
 * @描述
 *
 * 使用场景：拓展一个类的功能，动态添加，撤销功能 。            可以替代继承
 * 优点：装饰类和被装饰类 可以 独立发展。         是继承的一种替代模式。
 * 缺点：多层装饰比较复杂。
 *
 *
 * 向现有的对象添加额外的功能，对现有类进行包装。
 *
 *
 * 结构型模式
 *
 * 拓展功能一般使用继承，但是在不想增加很多子类的情况下，可以使用装饰器模式。
 *
 *
 * ====================Java与Android中的源码体现===========
 * IO流
 * Context
 * Component
 *
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
