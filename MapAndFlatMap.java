// Example to show difference between MAP and FLAT MAP in java streams
// Map is used for just data transaformation whereas flat map is used to flatten the data as well after data transformation

import java.util.*;
import java.util.stream.*;
public class MapAndFlatMap
{
	public static void main(String[] args) 
	{

	    List<Employee> list=Arrays.asList(
	        new Employee(1,24,"sandeep",new ArrayList<String>(Arrays.asList("Hyderabad","Chennai"))),
	        new Employee(2,23,"pradeep",new ArrayList<String>(Arrays.asList("Hyderabad","Bangalore"))),
	        new Employee(3,26,"avinash",new ArrayList<String>(Arrays.asList("Chicago","New York"))),
	        new Employee(4,24,"nikhil",new ArrayList<String>(Arrays.asList("Hyderabad","Toronto")))
	        );
	        
	        // MAP example to perform data transaformation and print only unique ages of employes
	        
	        System.out.println(list.stream().map(a->a.age).collect(Collectors.toSet()));
	        
	        // FLatMap example to perform data transaformation first and then data flattening
	     Set<String> set=list.stream().flatMap(a->a.prefferedCities.stream()).collect(Collectors.toSet());
	     
	     System.out.println(set);
	        
	}
}

class Employee
{
  int id;
  int age;
  String name;
  List<String> prefferedCities;
  
  public Employee(int id,int age,String name,List<String> prefferedCities)
  {
      this.id=id;
      this.age=age;
      this.name=name;
      this.prefferedCities=prefferedCities;
  }
}
