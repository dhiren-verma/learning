package learning.comparable_comparator;

import java.util.Comparator;

//Descending Order Comparator:
public class MathComparator implements Comparator<StudentMark> {
	
	@Override
	public int compare(StudentMark firstStudentMarks, StudentMark secondStudentMarks) {
		if (firstStudentMarks.getMathsMarks() > secondStudentMarks.getMathsMarks())
			return -1;
		else if (firstStudentMarks.getMathsMarks() < secondStudentMarks.getMathsMarks())
			return 1;
		
		return 0;
	}

}
