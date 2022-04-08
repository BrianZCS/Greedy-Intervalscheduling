import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Interval implements Comparable<Interval>{
	int begin;
	int end;
	Interval(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	public int compareTo(Interval b) {
		if(this.end > b.end) return 1; 
	    if(this.end < b.end) return -1;
	    else return 0;
	}	
}
public class Schedule {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int instances = scan.nextInt();
		while(instances-- >0) {
			//Retrieve data
			int numJobs = scan.nextInt();
			ArrayList<Interval> schedule = new ArrayList<Interval>();
			while(numJobs-- >0) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			Interval job;
			if(a>b) {
				job = new Interval(b,a);
			}
			else {
				job = new Interval(a,b);
			}
			schedule.add(job);
			}
			Collections.sort(schedule);//O(N*Log(N)) Sort
			//O(N) Remove incompatible request
			int numSchedule = 1;
			int i = 0;
			for(int j = i+1; j<schedule.size();++j) {
				if(schedule.get(i).end<=schedule.get(j).begin) {
					numSchedule++;
					i = j;
				}
			}
			System.out.println(numSchedule);			
		}
		scan.close();
	}

}
