package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String ID="99";
    // //requires one empty constructor
    public IdGenerate(){}
    // returnes current ID
    public static String getCurrentId(){
        return ID;
    }
    //must reset the currentId back to 99
    public static void reset(){
        ID="99";
    }
    //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
    public static void generateID(){
        ID= Integer.parseInt(ID) +1 + "";
    }
}