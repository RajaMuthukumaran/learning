package org.shl;

import java.util.List;

public class StreamExample {
	public long getEmptyElementCount(List<String> datas){
		return datas.stream().filter(s -> s.isEmpty()).count();
	}
	
	
}
