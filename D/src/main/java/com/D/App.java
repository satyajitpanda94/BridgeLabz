package com.D;

import org.modelmapper.ModelMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Entity entity=new Entity(5,"sat");
    	Dto d=new Dto();

		ModelMapper map=new ModelMapper();
		map.map(entity, d);
    	System.out.println(d.getK());
    }
}
