 import java.io.*;

abstract public class CommandLine {
	char commandChar;
	CommandLine(char cc) { commandChar = cc; }
	abstract void process(String arg);
}
/////////////////// Diagnosable.java //////////////////////


