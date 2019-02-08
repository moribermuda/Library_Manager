/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moribermuda.classes;

import java.util.Date;

/**
 *
 * @author MORTEZA
 */
public class Order
{
    private int id;
    private int Book_Code;
    private int mem_Code;
    private String titell;
    private String fname;
    private String lname;
    private Date init_Date;
    private Date finish_Date;

    public String getTitell()
    {
        return titell;
    }

    public void setTitell(String titell)
    {
        this.titell = titell;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getBook_Code()
    {
        return Book_Code;
    }

    public void setBook_Code(int Book_Code)
    {
        this.Book_Code = Book_Code;
    }

    public int getMem_Code()
    {
        return mem_Code;
    }

    public void setMem_Code(int mem_Code)
    {
        this.mem_Code = mem_Code;
    }

    public Date getInit_Date()
    {
        return init_Date;
    }

    public void setInit_Date(Date init_Date)
    {
        this.init_Date = init_Date;
    }

    public Date getFinish_Date()
    {
        return finish_Date;
    }

    public void setFinish_Date(Date finish_Date)
    {
        this.finish_Date = finish_Date;
    }
    
}
