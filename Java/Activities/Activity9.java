package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Kiwi");
        myList.add("Apple");
        myList.add("Orange");
        //Adding object at specific index
        myList.add(3, "Pineapple");
        myList.add(1, "Mango");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Chicku is in list: " + myList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Pineapple");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}