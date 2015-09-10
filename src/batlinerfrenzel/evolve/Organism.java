package batlinerfrenzel.evolve;

import java.util.HashMap;
import java.util.function.Function;

public class Organism {
	private final static double	MAX_ENERGY = 100;
	private final static double	MIN_ENERGY = 0;
	
	private Genome genome;
	private double energy;
	
	//create action classes, implement fat stores, work on decideAction
	// create Environment
	
	public Organism(Genome genome, double startEnergy) {
		this.genome = genome;
		if (startEnergy < MIN_ENERGY || startEnergy > MAX_ENERGY) {
			throw new IllegalArgumentException("Energy above or below limits");
		}
		this.energy = startEnergy;
	}
	
	public Organism breed(Organism other) {		
		Genome newGenome = this.genome.breed(other.getGenome());
		if (newGenome == null) {
			return null;
		}
		return new Organism(newGenome, );
		
	}
	
	public void move() {
	
	}
	
	public Genome getGenome() {
		return genome;
	}
	
}
