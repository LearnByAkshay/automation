package java1;

public class ClassB extends ClassA{
	
	public void run(){
		System.out.println("I am from child class");
	}

	public static void main(String[] args) {
		
		ClassA obj = new ClassA();
		obj.run();
		
		ClassA obj1 = new ClassB();
		obj1.run();
		
		
		ClassB obj2 = new ClassB();
		obj2.run();
	}

}
