public class Card {
	
	private String type;
	private int num;
	
	public Card(String type, int num) 
	{
		setType(type);
		setNum(num);
	}

	String getType() 
	{
		return type;
	}

	int getNum() 
	{
		return num;
	}

	void setType(String type) 
	{
		switch(type)
		{
			case CardType.CLUBS: this.type = type; break;
			case CardType.DIAMONDS: this.type = type; break;
			case CardType.SPADES: this.type = type; break;
			case CardType.HEARTS: this.type = type; break;
			default: throw new RuntimeException("Invalid Card Value");
		}
	}

	void setNum(int num) 
	{
		if (num < 0 || num > 13)
		{
			throw new RuntimeException("Invalid Card Value");
		}
		this.num = num;
	}
	
}
