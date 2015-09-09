package batlinerfrenzel.evolve;

public class Organism {
	
	private Genome genome;

	public Organism(Genome genome) {
		this.genome = genome;
	}
	
	public Organism breed(Organism other) {		
		Genome newGenome = this.genome.breed(other.getGenome());
		if (newGenome == null) {
			return null;
		}
		return new Organism(newGenome);
	}
	
	public Genome getGenome() {
		return genome;
	}

}
