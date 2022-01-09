package learning.comparable_comparator;

public class StudentMark implements Comparable<StudentMark> {
	
	private String studentName;
	private int mathsMarks;
	private int scienceMarks;
	private int englishMarks;
	private int hindiMarks;
	private int totalMarks;
	private int totalMaxMarks;
	
	private StudentMark() {
		mathsMarks = 0;
		scienceMarks = 0;
		englishMarks = 0;
		hindiMarks = 0;
		totalMarks = 0;
		totalMaxMarks = 0;
	}
	
	public StudentMark(String studentName) {
		this();
		this.studentName = studentName;
	}
	
	public StudentMark(String studentName,
			int mathsMarks, int scienceMarks,
			int englishMarks, int hindiMarks) {
		this.studentName = studentName;
		totalMarks += this.mathsMarks = mathsMarks;
		totalMarks += this.scienceMarks = scienceMarks;
		totalMarks += this.englishMarks = englishMarks;
		totalMarks += this.hindiMarks = hindiMarks;
		
		if (mathsMarks > 0)
			totalMaxMarks += 100;
		
		if (scienceMarks > 0)
			totalMaxMarks += 100;
		
		if (englishMarks > 0)
			totalMaxMarks += 100;
		
		if (hindiMarks > 0)
			totalMaxMarks += 100;
		
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getMathsMarks() {
		return mathsMarks;
	}
	
	public void setMathsMarks(int mathsMarks) {
		if (mathsMarks<0)
			throw new IllegalArgumentException("Invalid Marks!");
		
		if (this.mathsMarks>0 && mathsMarks==0)
			totalMaxMarks -= 100;
		else if (this.mathsMarks==0 && mathsMarks>0)
			totalMaxMarks += 100;
		
		totalMarks -= this.mathsMarks;
		totalMarks += this.mathsMarks = mathsMarks;
	}
	
	public int getScienceMarks() {
		return scienceMarks;
	}
	
	public void setScienceMarks(int scienceMarks) {
		if (scienceMarks<0)
			throw new IllegalArgumentException("Invalid Marks!");
		
		if (this.scienceMarks>0 && scienceMarks==0)
			totalMaxMarks -= 100;
		else if (this.scienceMarks==0 && scienceMarks>0)
			totalMaxMarks += 100;
		
		totalMarks -= this.scienceMarks;
		totalMarks += this.scienceMarks = scienceMarks;
	}
	
	public int getEnglishMarks() {
		return englishMarks;
	}
	
	public void setEnglishMarks(int englishMarks) {
		if (englishMarks<0)
			throw new IllegalArgumentException("Invalid Marks!");
		
		if (this.englishMarks>0 && englishMarks==0)
			totalMaxMarks -= 100;
		else if (this.englishMarks==0 && englishMarks>0)
			totalMaxMarks += 100;
		
		totalMarks -= this.englishMarks;
		totalMarks += this.englishMarks = englishMarks;
	}
	
	public int getHindiMarks() {
		return hindiMarks;
	}
	
	public void setHindiMarks(int hindiMarks) {
		if (hindiMarks<0)
			throw new IllegalArgumentException("Invalid Marks!");
		
		if (this.hindiMarks>0 && hindiMarks==0)
			totalMaxMarks -= 100;
		else if (this.hindiMarks==0 && hindiMarks>0)
			totalMaxMarks += 100;
		
		totalMarks -= this.hindiMarks;
		totalMarks += this.hindiMarks = hindiMarks;
	}
	
	public int getTotalMarks() {
		return totalMarks;
	}
	
	public int getTotalMaxMarks() {
		return totalMaxMarks;
	}
	
	private int getPercentage() {
		if (totalMaxMarks > 0)
			return (totalMarks*100)/totalMaxMarks;
		else
			return 0;
	}
	
	//Descending Order Comparator:
	@Override
	public int compareTo(StudentMark otherStudentMarks) {
		if (this.getPercentage() > otherStudentMarks.getPercentage())
			return -1;
		else if (this.getPercentage() < otherStudentMarks.getPercentage())
			return 1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		return studentName + " secured : "+getPercentage()+"%\n"
				+ "Maths: " + mathsMarks + "	|	Science: " + scienceMarks
				+ "	|	English: " + englishMarks + "	|	Hindi: " + hindiMarks
				+ "\nHis Total Marks are = " + totalMarks + "/" + totalMaxMarks
				+ "\n";
	}
	
}
