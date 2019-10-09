package com.siwuxie095.foryou.innerclassdemo.example4;

/**
 * @author Jiajing Li
 * @date 2019-10-08 22:46:35
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        System.out.println(anonymousInnerClass.getAnonymousVal(3).val);
    }

}

class AnonymousInnerClass {
    Anonymous getAnonymousVal(int val) {
        return new Anonymous(val);
    }
}

class Anonymous {
    int val;

    public Anonymous(int val) {
        this.val = val;
    }
}


