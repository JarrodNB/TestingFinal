public class Card 
{
	private String type;
	private int value;
	private int points;
	
	public Card(String type, int value, int points) 
	{
		setType(type);
		setValue(value);
		setPoints(points);
	}

	public String getType() 
	{
		return type;
	}

	public int getValue() 
	{
		return value;
	}

	private void setType(String type) 
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

	public void setValue(int value) 
	{
		if (value < 0 || value > 13)
		{
			throw new RuntimeException("Invalid Card Value");
		}
		this.value = value;
	}
	
	
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		if (points < 0 || points > 11)
		{
			throw new RuntimeException("Invalid Card Points");
		}
		this.points = points;
	}

	@Override
	public String toString()
	{
		switch (value)
		{
			case 1: return "Ace of " + type;
			case 11: return "Jack of " + type;
			case 12: return "Queen of " + type;
			case 13: return "King of " + type;
			default: return value + " of " + type;
		}
	}
}
