import edu.princeton.cs.algs4.Vector;

public class Candidate extends Vector {
    //Dimension
    private int d;
    //Scores and hired data
    private double social, algorithm, gpa, age, y;
    private double[] data;

    //Constructor that takes values separately
	/*public Candidate(double soc, double alg, double g, double a, double y) {
		super(new double[]{soc, alg, g, a});
		social = soc;
		algorithm = alg;
		gpa = g;
		age = a;
		this.y = y;
		data = new double[]{soc, alg, g, a};
		this.d = data.length;
	}*/

    //Constructor that takes values as an array
    public Candidate(double[] data) {
        super(data[0], data[1], data[2], data[3]);
        this.social = data[0];
        this.algorithm = data[1];
        this.gpa = data[2];
        this.age = data[3];
        this.y = data[4];
        this.d = data.length - 1;
        this.data = data;
		/*for(int i = 0;i<d;i++)
			this.data[i] = data[i];*/
    }

    //Creates a unit candidate(vector) from an integer
    public Candidate(int d) {
        this.d = d;
        data = new double[d];
    }

    //Method to check if the candidate is hired
    public boolean checkHired() {
        if (y == 1.0)
            return true;
        else
            return false;
    }

    //Creates a new candidate(vector) from the difference of two candidates(vectors)
    public Candidate minus(Candidate that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        Candidate c = new Candidate(d);
        for (int i = 0; i < d; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    }

    //Calculates the dot product of two candidates(vectors)
    public double dot(Candidate that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        double sum = 0.0;
        for (int i = 0; i < d; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    }

    //Calculates the magnitude of a candidate(vector) by taking its dot product with itself
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    //Finally, this method takes the difference of two vectors and calculates the magnitude of the difference vector
    public double distanceTo(Candidate that) {
        if (this.d != that.d) throw new IllegalArgumentException("Dimensions don't agree");
        return this.minus(that).magnitude();
    }

    //Getters and setters
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSocial() {
        return social;
    }

    public void setSocial(double social) {
        this.social = social;
    }

    public double getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(double algorithm) {
        this.algorithm = algorithm;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
