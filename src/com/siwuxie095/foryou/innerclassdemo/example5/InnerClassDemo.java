package com.siwuxie095.foryou.innerclassdemo.example5;

import java.sql.SQLOutput;

/**
 * @author Jiajing Li
 * @date 2019-10-08 22:50:56
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        System.out.println(anonymousInnerClass.getAnonymousVal().val);
    }

}

class AnonymousInnerClass {
    Anonymous getAnonymousVal() {

      return new Anonymous(5) {

      };
  }
}

abstract class Anonymous {
    int val;

    public Anonymous(int val) {
        this.val = val;
    }
}