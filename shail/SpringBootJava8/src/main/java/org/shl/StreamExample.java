package org.shl;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public long getEmptyElementCount(List<String> datas){
		return datas.stream().filter(s -> s.isEmpty()).count();
	}
	
	public long getCountOfStringWithMatchesString(List<String> datas,String match){
		return datas.parallelStream().filter(s -> s.toLowerCase().contains(match.toLowerCase())).count();
	}
	
	public String concatenateNonEmptyString(List<String> datas){
		return datas.parallelStream().filter(s -> !s.isEmpty())
				.collect(Collectors.joining(","));
	}
}
