package com.playground.extend;

/**
 * @author: Vermouth
 * @create: 2021-08-06 16:32
 * @description:
 **/

public class CreateObjectTest implements Cloneable {

    String name;
    int age;

    public CreateObjectTest() {
    }

    public CreateObjectTest(String name) {
        this.name = name;
        initAge();
    }

    private void initAge() {
        this.age = 0;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {
        CreateObjectTest cot = new CreateObjectTest("xxx");
        System.out.println(cot);

        CreateObjectTest cot1 = (CreateObjectTest) Class.forName("com.playground.extend.CreateObjectTest").newInstance();
        System.out.println(cot1);

        CreateObjectTest cot2 = (CreateObjectTest) cot.clone();
        System.out.println(cot2);

    }

}
