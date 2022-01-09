package learning.comparable_comparator;

import java.util.Comparator;

//Descending Order Comparator:
public class HindiComparator implements Comparator<StudentMark> {
	
	@Override
	public int compare(StudentMark firstStudentMarks, StudentMark secondStudentMarks) {
		if (firstStudentMarks.getHindiMarks() > secondStudentMarks.getHindiMarks())
			return -1;
		else if (firstStudentMarks.getHindiMarks() < secondStudentMarks.getHindiMarks())
			return 1;
		
		return 0;
	}

}
