package batlinerfrenzel.evolve;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		Trait speedy = new Trait("speed", 2.0, 1.0, 3.0, 0.1, 0);
		Trait slow = new Trait("speed", 1.1, 1.0, 3.0, 0.1, 0);
		
		ArrayList<Trait> speedyTraits = new ArrayList<>();
		speedyTraits.add(speedy);
		
		ArrayList<Trait> slowTraits = new ArrayList<>();
		slowTraits.add(slow);
		
		Genome speedyGenome = new Genome(speedyTraits);
		Genome slowGenome = new Genome(slowTraits);
		
		Organism speedyOrganism = new Organism(speedyGenome);
		Organism slowOrganism = new Organism(slowGenome);
		
		System.out.println(speedyOrganism.breed(slowOrganism).getGenome().getTraitByName("speed").getValue());
	}
}
