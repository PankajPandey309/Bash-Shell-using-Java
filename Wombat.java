
/*
 * Created on Oct 25, 2004
 * @author wirthj
 */

public class Wombat extends Diagnosable {
	Wombat(String nm,int a) {
		String name=nm; 
		int age = a; 
	}
	////////////////////////////////////
	String name;
	int age;
	////////////////////////////////////
	public void makeCommandList() {
		commandList = new CommandLine[] {
			new CommandLine('n') {
				void process(String arg) { System.out.println(name); } },
			new CommandLine('a') {
				void process(String arg) { System.out.println(age); } },
			new CommandLine('A') {
				void process(String arg) { age = parseInt(arg); } },
			new CommandLine('n') {
				void process(String arg) { System.out.println(name); } },
			new CommandLine('w') {
				void process(String arg) {
					System.out.println("I am "+this+
							" my outie is "+Wombat.this);
				}
			}
		};
	}

}