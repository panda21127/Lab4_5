package model.animal;

public class KindAnimals extends Animal {
	private int kindAnimal;
	
	public int GetKindAnimal() {
		return kindAnimal;
	}
	public void SetkindAnimal(int kindAnimal) {
		this.kindAnimal = kindAnimal;
	}
	
	public KindAnimals()
	{
		super();
		this.kindAnimal=2;
	}
	public KindAnimals(String Name,int Weight,int Age,int KindAnimal)
	{
		super(Name,Weight,Age);
		this.kindAnimal=KindAnimal;
	}
	
	public String ChangeKindAnimal(int KindAnimal)
	{
		switch(KindAnimal)
		{
		case 1:
		{
			String line="Waterfowl";
			return line;
		}
		case 2:
		{
			String line="Feathered";
			return line;
		}
		case 3:
		{
			String line="Ungulates";
			return line;
		}
		case 4:
		{
			String line="Cold-blooded";
			return line;
		}
		default:
		{
			String line="Error";
			return line;
		}
		}
	}
	public String Print()
	{
		return super.GetName()+" "+String.valueOf(super.GetWeight())+" "
		+String.valueOf(super.GetAge())+" "+String.valueOf(kindAnimal);
	}
	public void PrintInf()
	{
		System.out.println(super.GetName()+"\t"+ChangeKindAnimal(kindAnimal)+"\t"+String.valueOf(super.GetWeight())+"\t"
	+String.valueOf(super.GetAge()));
	}
	public void move(int KindAnimal) {
		cell prison=new cell();
		super.move();
	    System.out.println(ChangeKindAnimal(KindAnimal)+" move in "+ prison.ChangeKindCell(KindAnimal)+"["+prison.PrintCell(super.GetWeight())+"]");
	    
	}

}

