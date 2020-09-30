package animals;

abstract class AbstractAnimal
{
	private static int maxID = 0;
	private int id;
	private String name;
	private int yearNamed;
	private int food;

	public AbstractAnimal(String name, int yearNamed)
	{
		maxID++;
		id = maxID;
		this.name = name;
		this.yearNamed = yearNamed;
	}

	abstract String move();
	abstract String breath();
	abstract String reproduce();
	

	void consume()
	{
		food++;
	}

	public String getName()
	{
		return name;
	}

	public int getYear()
	{
		return yearNamed;
	}

	public int getID()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "id=" + id +", name=" + name + ", yearNamed=" + yearNamed;
	}

	public String toStringTwo()
	{
		return getName() + " " + reproduce() + " " + move() + " " + breath() + " " + getYear();
	}
}