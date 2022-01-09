package learning.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorComparatorTest {

	public static void main(String[] args) {
		StudentMark davidMarks = new StudentMark("David");
		davidMarks.setMathsMarks(75);
		davidMarks.setScienceMarks(93);
		davidMarks.setEnglishMarks(77);
		davidMarks.setHindiMarks(65);
		
		StudentMark allenMarks = new StudentMark("Allen", 70, 80, 75, 75);
		StudentMark wesMarks = new StudentMark("Wes", 87, 90, 70, 65);
		StudentMark andrewMarks = new StudentMark("Andrew", 78, 83, 80, 70);
		StudentMark patriciaMarks = new StudentMark("Patricia", 75, 85, 75, 70);
		
		List<StudentMark> studentMarks = new ArrayList<>();
		studentMarks.add(davidMarks);
		studentMarks.add(allenMarks);
		studentMarks.add(wesMarks);
		studentMarks.add(andrewMarks);
		studentMarks.add(patriciaMarks);
		
		printAllStudents(studentMarks, "All Students are:");
		
		//Default Implementation sorts on the basis of Total Percentage Scored by the Student:
		//If need to find Toppers for each subject, then we have to used their respective Comparator Implementation:
		Collections.sort(studentMarks);
		printAllStudents(studentMarks, "Students as per their Percentage are:");
		
		Collections.sort(studentMarks, new MathComparator());
		printAllStudents(studentMarks, "Students as per their Maths marks are:");

		Collections.sort(studentMarks, new ScienceComparator());
		printAllStudents(studentMarks, "Students as per their Science marks are:");

		Collections.sort(studentMarks, new EnglishComparator());
		printAllStudents(studentMarks, "Students as per their English marks are:");

		Collections.sort(studentMarks, new HindiComparator());
		printAllStudents(studentMarks, "Students as per their Hindi marks are:");
		
	}
	
	private static void printAllStudents(List<StudentMark> studentMarks, String msg) {
		System.out.println(msg);
		studentMarks.stream().forEach(System.out::println);
	}

}
