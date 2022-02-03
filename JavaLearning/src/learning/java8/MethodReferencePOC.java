package learning.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferencePOC {
	
	/**
	 * Method References can be used as a shorter and more readable
	 * alternative for a Lambda Expression which only calls existing methods.
	 * 
	 * There are 4 variants of Method Reference:
	 * 
	 * 1. Static Method Reference				-> ContainingClass::methodName
	 * 2. Reference to an Instance Method		-> containingInstance::methodName
	 * 3. Reference to an Instance Method
	 * 	  of an Object of a Particular Type		-> ContainingType::methodName
	 * 4. Reference to a Constructor			-> ClassName::new
	 */
	
	static boolean checkIfNull(Object obj) {
		return obj==null;
	}
	
	public static void main(String[] args) {
		MethodReferencePOC obj = new MethodReferencePOC();
		
		//1
		List<Object> list = new ArrayList<>();
		
		list.add(123);
		list.add("Hello");
		list.add(null);
		
		//1. Static Method Reference:
		//Earlier:
//		boolean hasNullEntry = list.stream().anyMatch(entry -> MethodReferencePOC.checkIfNull(entry));
		//with Java 8:
		boolean hasNullEntry = list.stream().anyMatch(MethodReferencePOC::checkIfNull);
		
		System.out.println("Null element in List status is: " + hasNullEntry);
		
		
		//2
		UserNameValidator nameValidator = obj.new UserNameValidator();
		List<User> userList = new ArrayList<>();
		
		userList.add(new User("karen"));
		userList.add(new User("demain_maia"));
		
		//2. Reference to an Instance Method:
//		boolean hasInvalidNamedUser = userList.stream().anyMatch(user -> nameValidator.isValidName(user));
		boolean hasInvalidNamedUser = userList.stream().
				anyMatch(nameValidator::isValidName);
		
		System.out.println("Invalid Usernames in Users list status is: "+hasInvalidNamedUser);
		
		
		//3
		List<String> someString = new ArrayList<>();
		someString.add("");
		someString.add("Allen");
		someString.add("Wes");
		someString.add("");
		someString.add("Donald");
		someString.add("Barack");
		
		//3. Reference to an Instance Method of an Object of a Particular Type:
		//Example 1:
//		int emptyStringCount = (int) someString.stream().filter(str -> str.isEmpty()).count();
		int emptyStringCount = (int) someString.stream().
				filter(String::isEmpty).
				count();
		
		//Example 2:
		List<String> formattedUserNames = userList.stream().
				map(User::getFormattedName).
				collect(Collectors.toList());
		
		System.out.println("Number of Empty String in String List are: "+emptyStringCount);
		System.out.println("Formatted User Names: "+formattedUserNames);
		
		
		//4. Reference to a Constructor:
//		List<User> newUsers = someString.stream().filter(name -> !name.isEmpty()).map(name -> new User(name)).collect(Collectors.toList());
		List<User> newUsers = someString.stream().
				filter(name -> !name.isEmpty()).
				map(User::new).
				collect(Collectors.toList());
		
		System.out.println("New Users List are:\n"+newUsers);
	}
	
	class UserNameValidator {
		boolean isValidName(User user) {
			return !user.getUserName().contains("_");
		}
	}
	
//	class User {
//		
//		private String userName;
//		
//		User(String userName) {
//			this.userName = userName;
//		}
//		
//		String getUserName() {
//			return userName;
//		}
//		
//		String getFormattedName() {
//			StringBuilder builder = new StringBuilder();
//			
//			if (!userName.isEmpty()) {
//				String[] words = userName.split("[\\W_]+");
//				
//				for (int i = 0; i < words.length; i++) {
//				    String word = words[i];
//				    if (i == 0) {
//				        word = word.isEmpty() ? word : word.toLowerCase();
//				    } else {
//				        word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();      
//				    }
//				    builder.append(word);
//				}
//			}
//			
//			return builder.toString();
//		}
//		
//	}
	
}
