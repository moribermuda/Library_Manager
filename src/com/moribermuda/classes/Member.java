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
public class Member extends Person
{
    private int mem_code;
    private Date mem_Date;
    private Date expireDate;
    private String tellNum;

    public String getTellNum()
    {
        return tellNum;
    }

    public void setTellNum(String tellNum)
    {
        this.tellNum = tellNum;
    }

    public int getMem_code()
    {
        return mem_code;
    }

    public void setMem_code(int mem_code)
    {
        this.mem_code = mem_code;
    }

    public Date getMem_Date()
    {
        return mem_Date;
    }

    public void setMem_Date(Date mem_Date)
    {
        this.mem_Date = mem_Date;
    }

    public Date getExpireDate()
    {
        return expireDate;
    }

    public void setExpireDate(Date expireDate)
    {
        this.expireDate = expireDate;
    }
    
}
