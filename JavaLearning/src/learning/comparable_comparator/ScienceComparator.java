package learning.comparable_comparator;

import java.util.Comparator;

//Descending Order Comparator:
public class ScienceComparator implements Comparator<StudentMark> {
	
	@Override
	public int compare(StudentMark firstStudentMarks, StudentMark secondStudentMarks) {
		if (firstStudentMarks.getScienceMarks() > secondStudentMarks.getScienceMarks())
			return -1;
		else if (firstStudentMarks.getScienceMarks() < secondStudentMarks.getScienceMarks())
			return 1;
		
		return 0;
	}

}
