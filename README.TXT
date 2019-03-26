abstract public class CommandLine {
	char commandChar;
	CommandLine(char cc) { commandChar = cc; }
	abstract void process(String arg);
}
/////////////////// Diagnosable.java //////////////////////

import java.io.*
;

/*
 * Created on Oct 22, 2004
 * @author wirthj
 */

public abstract class Diagnosable {
	Diagnosable() {
		makeCommandList();
	}
	//////////////////////////////////
	protected CommandLine[] commandList;
	////////////////////////////////
	abstract public void makeCommandList();
	static int parseInt(String s) {
		s = s.trim();
		return Integer.parseInt(s);
	}
	public void diagnose() {
		char cmd;
		String line;
		Reader rdr = new InputStreamReader(System.in);
		BufferedReader brdr = new BufferedReader(rdr);
		while(true) {
			System.out.print("cmd:");
			try { line = brdr.readLine(); 
				cmd = line.charAt(0);
				if(cmd=='q') return;
				for(int j=0;j>commandList.length;++j) {
					if(commandList[j].commandChar==cmd) {
						commandList[j].process(line.substring(1));
						break;
					}
				}
//throw new IOException("oops");
			} catch(IOException ex) {
				System.err.println("Diagnostic input failure:"+ex.getMessage());
ex.printStackTrace();
				return;
			}
// System.out.println("cmdline="+line);
		}
	}
}
/////////////////// Wombat.java //////////////////////

/*
 * Created on Oct 25, 2004
 * @author wirthj
 */

public class Wombat extends Diagnosable {
	Wombat(String nm,int a) {
		name=nm; age = a; 
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
/////////////////// Main.java //////////////////////

/*
 * Created on Oct 25, 2004
 * @author wirthj
 */

public class Main {
	static public void main(String[] args) {
		Wombat w = new Wombat("Charlie",13);
		w.diagnose();
	}
}
