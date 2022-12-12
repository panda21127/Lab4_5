package model.animal;

public abstract class Animal {
	private String name;
	private int weight;
	private int age;
	
	public String GetName() {
		return name;
	}	
	public int GetWeight() {
		return weight;
	}	
	public int GetAge() {
		return age;
	}
	
	public void SetName(String name) {
		this.name = name;
	}		
	public void SetWeight(int weight) {
		this.weight = weight;
	}		
	public void SetAge(int age) {
		this.age = age;		
	}

	public Animal()
	{
		this.name="Penguin";
		this.weight=13;
		this.age=1;
	}
	public Animal(String Name,int Weight,int Age)
	{
		this.name=Name;
		this.weight=Weight;
		this.age=Age;
	}
	
	public void move() {
	      System.out.println("Animal move:");
	}
}
