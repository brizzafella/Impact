package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;
public class GetNumbers{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get numbers input
		String s ="0,1,2,4,6,7,8,11,12,14,15,16,17,18,19,20,21,22,23,24,25,27,28,29,30,31,32,33,35,36,37,38,39";
		//String s ="1,2,3,4,5,12,13,14,19";
		Checks check=new Checks();
		System.out.println(check.summarizeCollection(check.collect(s)));
		
		
		
		
	}

	
	
	

}
class Checks implements NumberRangeSummarizer{
	public Collection<Integer> collect(String input) {
		// TODO Auto-generated method stub
		List<Integer> result = Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
		return result;
	}

	public String summarizeCollection(Collection<Integer> input) {
		// TODO Auto-generated method stub
	
		Integer[] arr = input.stream().toArray(Integer[]::new);
		ArrayList<String> outer=new ArrayList<String>();
		 int len = arr.length;
		 int current=0;
		 String line="";
		 while(current<len){
			 int next=current+1;
			 ArrayList<Integer> inner=new ArrayList<Integer>();
			
			 if((next+1<len)&&(arr[next]-1==arr[current])&&(arr[next+1]-1==arr[next])){
			
				 inner.add(arr[current]);
				 inner.add(arr[next]);
				 inner.add(arr[next+1]);
				 
				 for(int k=next+1;k<len;k++) {
					 
					 if((k+1<len)&&(arr[k+1]-arr[k]==1)) {
					
						 inner.add(arr[k+1]);
						 current=k+1;
					 }
					
					 else {
						 
						 current=k+1;
						 String keeper= inner.get(0)+"-"+inner.get(inner.size()-1);
						 outer.add(keeper);
						 
						 break;
					 }
				 }
			 }
			 
			 else {
				 //
			
				
				 outer.add(arr[current]+"");
				 current=current+1;
			 }
	}
		 System.out.println(line);
		 
		 String listString = outer.stream().map(Object::toString)
                 .collect(Collectors.joining(", "));
		return listString;
	}
	
}
