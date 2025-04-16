package SOLIDPrinciple;

//Dependency Inversion Principle
public class DependencyInversionPrincipleDemo {
    //5. Class should depend on interfaces rather than concrete classes

    //lets see problem

    //interface keyboard and its various implementing class
    interface Keyboard{

    }

    class WiredKeyboard implements Keyboard{

    }

    class BluetoothKeyboard implements Keyboard{

    }


    //interface Mouse and its various implementing class
    interface Mouse{

    }

    class WiredMouse implements Mouse{

    }

    class BluetoothMouse implements Mouse{

    }

    class Macbook{

//        private WiredKeyboard keyboard;
//        private WiredMouse mouse;
//
//        public Macbook(){
//            keyboard=new WiredKeyboard();
//            mouse=new WiredMouse();
//        }

        //example when : when classes are dependent on concrete classes
        //now in future if we want bluetooth mouse not wired mouse then I have to change
        //field and also the constructor
        //so it is not a good way to do this


        //better way to do this
        //class should depend on interfaces rather than concrete class
        private Keyboard keyboard;
        private Mouse mouse;

        Macbook(Keyboard keyboard,Mouse mouse){
            this.keyboard=keyboard;
            this.mouse=mouse;
        }

        //so here problem is solved now we can  call macbook constructor
        //with any combinations of wired or bluetooth keyboard or mouse it will take that
    }
}
