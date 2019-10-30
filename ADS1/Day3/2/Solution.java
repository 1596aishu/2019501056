class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		for (int i = 0; i < (teams.length)-1; i++) {
			int min = i;
			for (int j = i + 1; j < teams.length; j++) {
				if (teams[j].compareTo(teams[min]) == 1) {
					min = j;
				}
			}
				Team temp = teams[min];
				teams[min] = teams[i];
				teams[i] = temp;
			
		}
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return "";
	}
	public int compareTo(Team team) {
		if (this.noOfWins > team.noOfWins)
		return 1;
		else if (this.noOfWins < team.noOfWins) {
			return -1;
		}
		else {
			if (this.noOfLosses > team.noOfLosses)
				return 1;
			else if (this.noOfLosses < team.noOfLosses) {
				return -1;
			}
			else {
				if (this.noOfDraws > team.noOfDraws)
					return 1;
				else if (this.noOfDraws < team.noOfDraws) {
					return -1;
				}
			}
		}return 0;
	}
}