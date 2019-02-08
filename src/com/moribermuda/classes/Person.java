
package com.moribermuda.classes;

/**
 *
 * @author MORTEZA
 */
public class Person
{
    private String fname;
    private String lname;
    private String from;
    private long identityCode;
    private String brithday;

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

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public long getIdentityCode()
    {
        return identityCode;
    }

    public void setIdentityCode(long identityCode)
    {
        this.identityCode = identityCode;
    }

    public String getBrithday()
    {
        return brithday;
    }

    public void setBrithday(String brithday)
    {
        this.brithday = brithday;
    }
    
}
