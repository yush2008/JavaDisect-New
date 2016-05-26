package innerclass;

import java.util.Comparator;

public class InnerMain {

    public static void main(String[] args) {

        Parent p1 = new Child();
        Child p2 = new Child() {

            public void show1() {
                System.out.println("Anonymos Child");
            }

            public void show() {
                System.out.println("Anonymos Child");
            }
        };


        Outer out = new Outer();
        out.createInner();

        Outer.Inner iner = out.new Inner();

    }

}

class Outer {

    private int x = 10;
    public int y = 10;
    private static int j = 20;

    private String className = "Outer";


    class Sorter implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }


    public void main() {
        Outer otr = new Outer();
        Sorter st = new Sorter();
    }


    public static void main(String[] args) {
        Outer otr = new Outer();
        Sorter st = otr.new Sorter();
    }

    static class StatInner {
        private int x = 10;
        private static String statStr = "STatic";

        public static void statShow() {
            j++;
            //y++;
        }
    }


    public void innerClass() {

        abstract class MethodLocal {

            public void access() {
                j++;
            }

        }


        class MethodLocalSub extends MethodLocal {

            public void access() {
                x++;
            }

        }
    }

    static class StaticInner {
        public static void sadd() {
            j++;
        }
    }


    class Inner {

        private int x = 10;
        public int y = 10;
        //private static int j=20;

        private String className = "Inner";


        public void getOuterVar() {

            j++;
            System.out.println("className=" + Outer.this.className);
        }

        public void getInnerVar() {

            System.out.println("className=" + className);
        }

	/*If a inner class is not static we can't add a static variable there.
    Reason: Non-static inner class can't be accessed by class name. Like Outer.Inner o1 = new Outer.Inner();
	it should be accessed as    Outer.Inner o1 = outer.new Inner(); Hence if it can be accessed as a object not as a class
	there is no point of having a class level variable.
*/

    }


    public void createInner() {
        Inner i = new Inner();
        i.getOuterVar();

    }

}


class Parent {
    public void disp() {
        System.out.println("Parent");
    }

}

class Child extends Parent {

    public void show() {
        System.out.println("Child");
    }

}


class A {
    void m() {
        System.out.println("outer");
    }
}

class TestInners {
    public static void main(String[] args) {
        new TestInners().go();
    }

    void go() {

        class A {
            void m() {
                System.out.println("inner");
            }
        }
        new A().m();
        new TestInners().new A().m();
        new innerclass.A().m();
    }

    class A {
        void m() {
            System.out.println("middle");
        }
    }
}

class Clidder {
    private final void flipper() {
        System.out.println("Clidder");
    }
}

class Clidlet extends Clidder {

    public void flipper() {
        System.out.println("Clidlet");
    }

    public static void main(String[] args) {
        Clidlet obj = new Clidlet();
        obj.flipper();
    }
}


class Dog {
    public void bark() {
        System.out.print("woof ");
    }
}

class Hound extends Dog {
    public void sniff() {
        System.out.print("sniff ");
    }

    public void bark() {
        System.out.print("howl ");
    }
}

class GreyHoud extends Hound {

}

class DogShow {
    public static void main(String[] args) {

        new DogShow().go();

        GreyHoud gh = new GreyHoud();
        Hound hn = new GreyHoud();
        Hound hnd = new Hound();
        gh = (GreyHoud) hnd;

        Hound h = ((Hound) new GreyHoud());


    }

    void go() {
        new Hound().bark();
        ((Dog) new Hound()).bark();
        //((Dog)new Hound()).sniff();
    }
}


class Redwood extends Tree {
    public static void main(String[] args) {
        new Redwood().go();
    }

    void go() {
        go2(new Tree(), new Redwood());
        go2((Redwood) new Tree(), new Redwood());
    }

    void go2(Tree t1, Redwood r1) {
        Redwood r2 = (Redwood) t1;
        Tree t2 = (Tree) r1;
    }

    public static void sing() {
    }
}

class Tree {

    public static void sing() {
    }
}


class Mammal {
    String name = "Mammal";
    static String sName = "staticMammal";

    String makeNoise() {
        return "generic noise";
    }
}

class Zebra extends Mammal {
    String name = "zebra ";
    static String sName = "staticZebra";

    String makeNoise() {
        System.out.println(super.name);
        System.out.println(this.name);
        return "bray";
    }
}

class ZooKeeper {
    public static void main(String[] args) {
        new ZooKeeper().go();
    }
    void go() {
        Mammal m = new Zebra();
        System.out.println(m.name+ m.sName + m.makeNoise());
    }
}