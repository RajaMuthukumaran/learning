package com.demo.feature;

public class DefaultMethodsforInterfaces implements Formula {

	public static void main(String arg[]){
	
		Formula formula = new Formula() {
		    @Override
		    public double calculate(int a) {
		    	System.out.println("cal called");
		        return sqrt(a * 100);
		    }
		};
		System.out.println("call formulate calculate"+formula.calculate(100)); 
		System.out.println("call formulate calculate"+formula.sqrt(16)); 
	}
	@Override
	public double calculate(int a) {
		// TODO Auto-generated method stub
		return a*1.0;
	}

	
}
