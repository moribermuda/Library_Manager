package com.moribermuda.classes;

/**
 *
 * @author MORTEZA
 */
public class Book
{

    private int id;
    private String title;
    private String publisher;
    private String translator;
    private double price;
    private int year;
    private String authorName;
    private boolean availibal;
    private int print_count;
    private int customer_ID;
    private BookType bookType;
    private String Stack_property;

    public String getStack_property()
    {
        return Stack_property;
    }

    public void setStack_property(String Stack_property)
    {
        this.Stack_property = Stack_property;
    }
    

    public Book()
    {
    }

    @Override
    public String toString()
    {
        return "Book{" + "id=" + id + ", title=" + title + ", publisher=" + publisher + ", translator=" + translator + ", price=" + price + ", year=" + year + ", authorName=" + authorName + ", availibal=" + availibal + ", print_count=" + print_count + ", customer_ID=" + customer_ID + ", bookType=" + bookType + '}';
    }

    public Book(int id, String title, String publisher, String translator, double price, int year, String authorName, boolean availibal, int print_count, int customer_ID, BookType bookType)
    {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.translator = translator;
        this.price = price;
        this.year = year;
        this.authorName = authorName;
        this.availibal = availibal;
        this.print_count = print_count;
        this.customer_ID = customer_ID;
        this.bookType = bookType;
    }

    public BookType getBookType()
    {
        return bookType;
    }

    public void setBookType(BookType bookType)
    {
        this.bookType = bookType;
    }

    public int getCustomer_ID()
    {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID)
    {
        this.customer_ID = customer_ID;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getTranslator()
    {
        return translator;
    }

    public void setTranslator(String translator)
    {
        this.translator = translator;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public boolean isAvailibal()
    {
        return availibal;
    }

    public void setAvailibal(boolean availibal)
    {
        this.availibal = availibal;
    }

    public int getPrint_count()
    {
        return print_count;
    }

    public void setPrint_count(int print)
    {
        this.print_count = print;
    }

}
