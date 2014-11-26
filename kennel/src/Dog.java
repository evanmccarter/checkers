public class Dog
{
	int age;
	String name;
	
	Dog(int a, String s)
	{
		this.age = a;
		this.name = s;
	}
	
	int getAge()
	{
		return this.age;
	}
	
	public void setAge(int n)
	{
		this.age = n;
	}
	
	String getName()
	{
		return this.name;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public String toString()
	{
		return this.name + " " + this.age;
	}
}