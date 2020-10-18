package org.solent.com504.ood;

/**
 * This is a javadoc comment on the Main class
 *
 */
public class MyTestClass
{
    private MyTestClass()
    {
        // unused constructor, only included to remove linter warning
    }

    public static void main(String[] args)
    {
        // this is a local comment which doesnt go in javadoc
        MyTestClass myTestClass = new MyTestClass();
        myTestClass.writeAboutMe();
    }

    /**
     * This is a javadoc comment on writeAboutMe
     *
     */
    public void writeAboutMe()
    {
         System.out.println("I am running the following java class: " + MyTestClass.class);
    }
}
