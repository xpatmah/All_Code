package com.org.problemsolving.dp.first;

import com.org.problemsolving.ds.first.SingleLinkedListGeneration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SingleLinkedListGeneration list = new SingleLinkedListGeneration(12);
        Node start = list.getList();
        System.out.println();
        
    }
}
