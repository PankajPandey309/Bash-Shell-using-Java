import java.io.*;

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
		char cmd=' ';
		String line;
		Reader rdr = new InputStreamReader(System.in);
		BufferedReader brdr = new BufferedReader(rdr);
		while(true) {
			System.out.print("cmd:");
			try { 
			    line = brdr.readLine(); 
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

/////////////////// Main.java //////////////////////

/*
 * Created on Oct 25, 2004
 * @author wirthj
 */
