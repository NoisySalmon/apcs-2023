package unit11.b;

import java.nio.file.ProviderMismatchException;

// let's explore inheritance!
public class Bear {
    // composition
    private Zoo whereILive;
    private String name;

    // public Bear() {
    //     this.name = "Mr. Bear";
    // }

    public String getName() {
        return this.name;
    }

    public Bear(String myName) {
        this.name = myName;
    }

    public static void main(String[] args) {
         Panda meiLan = new Panda("Mei Lan");
         System.out.println(meiLan.getName());
        //Bear mrBear = new Bear();
        //Panda mrPandaBear = new Panda();

    }
}

// https://wwf.panda.org/wwf_news/?163461/Is-the-giant-panda-a-bear
class Panda extends Bear {

    private String myPandaName;

    // implicit default constructor when there are no other constructors
    // public Panda() { 
    //     // called implicitly
    //     //super();       
    // }

    public Panda(String pandaName) {
        // always have to call one constructor
        // implicit construct called if it exists
        //super();
        super(pandaName);
        // cannot set private variables, even on a superclass
       // this.name = pandaName;
    }

}

// https://en.wikipedia.org/wiki/List_of_giant_pandas
class Zoo  {
    // composition
    private Panda inhabitant;

}

// Zookeeper, Visitor, etc.
