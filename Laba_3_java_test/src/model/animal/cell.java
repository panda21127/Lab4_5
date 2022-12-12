package model.animal;

public class cell {
	private int kindCell;
	private int height;
	public int GetKindCell() {
		return kindCell;
	}
	public void SetkindAnimal(int KindCell) {
		this.kindCell = KindCell;
	}
	public int GetKHeight() {
		return height;
	}
	public void SetHeight(int Height) {
		this.height = Height;
	}
	
	public cell()
	{
		this.kindCell=2;
	}
	public cell(int KindCell)
	{
		this.kindCell=KindCell;
	}
		
	public String ChangeKindCell (int KindCell)
	{
		switch(KindCell)
		{
		case 1:
		{
			String line="Aquariums";
			return line;
		}
		case 2:
		{
			String line="Aviaries covered with mesh";
			return line;
		}
		case 3:
		{
			String line="Open aviaries";
			return line;
		}
		case 4:
		{
			String line="Aviaries with infrared lighting";
			return line;
		}
		default:
		{
			String line="Error";
			return line;
		}
		}
	}
	public String PrintCell (int Weight)
	{
		int flag;
		if (Weight<=21)
		{
			flag=1;
		}
		else
		{
			if((21<Weight)&&(Weight<40))
			{
				flag=2;
			}
			else
			{
				flag=3;
			}
		}
		switch(flag)
		{
		case 1:
		{
			String line="Small";
			return line;
		}
		case 2:
		{
			String line="Medium";
			return line;
		}
		case 3:
		{
			String line="Huge";
			return line;
		}
		default:
		{
			String line="Error";
			return line;
		}
	}
	}
}
