package animals;

import java.util.List;
import java.util.ArrayList;

public class Main
{
	private static List<AbstractAnimal> filterAnimal(List<AbstractAnimal> animals, CheckAnimal tester)
	{
		List<AbstractAnimal> tempList = new ArrayList<>();

		for (AbstractAnimal a : animals)
		{
			if (tester.test(a))
			{
				tempList.add(a);
			}
		}

		return tempList;
	}

	public static void main(String[] args)
	{
		Mammals panda = new Mammals("Panda", 1869);
		Mammals zebra = new Mammals("Zebra", 1778);
		Mammals koala = new Mammals("Koala", 1816);
		Mammals sloth = new Mammals("Sloth", 1804);
		Mammals armadillo = new Mammals("Armadillo", 1758);
		Mammals raccoon = new Mammals("Raccoon", 1758);
		Mammals bigfoot = new Mammals("Bigfoot", 2021);

		Birds pigeon = new Birds("Pigeon", 1837);
		Birds peacock = new Birds("Peacock", 1821);
		Birds toucan = new Birds("Toucan", 1758);
		Birds parrot = new Birds("Parrot", 1824);
		Birds swan = new Birds("Swan", 1758);

		Fish salmon = new Fish("Salmon", 1758);
		Fish catfish = new Fish("Catfish", 1817);
		Fish perch = new Fish("Perch", 1758);

		List<AbstractAnimal> myList = new ArrayList<>();
		myList.add(panda);
		myList.add(zebra);
		myList.add(koala);
		myList.add(sloth);
		myList.add(armadillo);
		myList.add(raccoon);
		myList.add(bigfoot);
		myList.add(pigeon);
		myList.add(peacock);
		myList.add(toucan);
		myList.add(parrot);
		myList.add(swan);
		myList.add(salmon);
		myList.add(catfish);
		myList.add(perch);

		System.out.println("\n\n*** Sort List Descending By Year Named ***");
		myList.sort((a1, a2) -> a2.getYear() - a1.getYear());
		myList.forEach((v) -> System.out.println(v));

		System.out.println("\n\n*** Sort List Alphabetically ***");
		myList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
		myList.forEach((v) -> System.out.println(v));

		System.out.println("\n\n*** Sort List by How They Move ***");
		myList.sort((a1, a2) -> a1.move().compareToIgnoreCase(a2.move()));
		myList.forEach((v) -> System.out.println(v));

		System.out.println("\n\n*** Animals That Breath With Lungs ***");
		List<AbstractAnimal> filteredList = filterAnimal(myList, a -> (a.breath().equals("lungs")));
		filteredList.forEach((v) -> System.out.println(v.toStringTwo()));

		System.out.println("\n\n*** Animals That Breath With Lungs & Named in 1758 ***");
		filteredList = filterAnimal(myList, a -> (a.breath().equals("lungs") && (a.getYear() == 1758)));
		filteredList.forEach((v) -> System.out.println(v.toStringTwo()));

		System.out.println("\n\n*** Animals That Lay Eggs & Breath With Lungs ***");
		filteredList = filterAnimal(myList, a -> (a.reproduce().equals("eggs") && (a.breath().equals("lungs"))));
		filteredList.forEach((v) -> System.out.println(v.toStringTwo()));

		System.out.println("\n\n*** Sort Alphabetically Animals Named in 1758 ***");
		filteredList = filterAnimal(myList, a -> a.getYear() == 1758);
		filteredList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
		filteredList.forEach((v) -> System.out.println(v.toStringTwo()));

		System.out.println("\n\n*** Sort Mammals Alphabetically ***");
		filteredList = filterAnimal(myList, a -> (a instanceof Mammals));
		filteredList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
		filteredList.forEach((v) -> System.out.println(v.toStringTwo()));
	}
}