package com.moribermuda.classes;

/**
 *
 * @author MORTEZA
 */
public class Book_Stack 
{

    private int stack_ID;
    private int stack_Row;
    private int stack_Coulomn;

    private int book_ID;
    private String property;


    public int getStack_ID()
    {
        return stack_ID;
    }

    public void setStack_ID(int stack_ID)
    {
        this.stack_ID = stack_ID;
    }

    public int getStack_Row()
    {
        return stack_Row;
    }

    public void setStack_Row(int stack_Row)
    {
        this.stack_Row = stack_Row;
    }

    public int getStack_Coulomn()
    {
        return stack_Coulomn;
    }

    public void setStack_Coulomn(int stack_Coulomn)
    {
        this.stack_Coulomn = stack_Coulomn;
    }

    public String getProperty()
    {
        property = String.valueOf(stack_ID) + "-" + String.valueOf(stack_Row) + "-" + String.valueOf(stack_Coulomn);
        return property;
    }

    public int getBook_ID()
    {
        return book_ID;
    }

    public void setBook_ID(int book_ID)
    {
        this.book_ID = book_ID;
    }

}
