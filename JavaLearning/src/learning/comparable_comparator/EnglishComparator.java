package learning.comparable_comparator;

import java.util.Comparator;

//Descending Order Comparator:
public class EnglishComparator implements Comparator<StudentMark> {
	
	@Override
	public int compare(StudentMark firstStudentMarks, StudentMark secondStudentMarks) {
		if (firstStudentMarks.getEnglishMarks() > secondStudentMarks.getEnglishMarks())
			return -1;
		else if (firstStudentMarks.getEnglishMarks() < secondStudentMarks.getEnglishMarks())
			return 1;
		
		return 0;
	}

}
