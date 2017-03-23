package test;

import model.utility.Utilities;;

public class test_Utilities
{

    public static void main(String[] args)
    {
        System.out.println(Utilities.convertCamelCaseToLowerCaseUnderscores("testy"));
        System.out.println(Utilities.convertCamelCaseToLowerCaseUnderscores("testyTestting"));
        System.out.println(Utilities.convertCamelCaseToLowerCaseUnderscores("testyTEstTesting"));
    }

}
