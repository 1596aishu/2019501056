class Solution{
	public static String isMatching(String str){
		// fill you code Here
		String[] brackets= new String[str.length()];
		brackets= str.split("");
		String[] stack = new String[str.length()];
		int size = 0;
		for(String eachBrace : brackets) {
			if(eachBrace.equals("[") ||  eachBrace.equals("(") ||  eachBrace.equals("{")){
				stack[size++] = eachBrace;
			}else if(size > 0){
				String recentBrace = stack[size -1];
				
				if(recentBrace.equals("[") && eachBrace.equals("]")){
					size--;
				}
				else if(recentBrace.equals("(") && eachBrace.equals(")")){
					size--;
				}
				else if(recentBrace.equals("{") && eachBrace.equals("}")){
					size--;
				}
			}		
		}

		if(size == 0){
			return "YES";
		}else{
			return "NO";
		}
	}
}