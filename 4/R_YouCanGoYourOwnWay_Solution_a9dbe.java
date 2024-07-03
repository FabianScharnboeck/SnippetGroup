import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution_a9dbe {

    public static void solve() throws Exception {
	int T = nextInt();
	for (int t = 1; t <= T; t++) {
	    int n = nextInt();
	    String moves = next();
	    StringBuilder sb = new StringBuilder();
	    char first = moves.charAt(0);
	    char last = moves.charAt(moves.length() - 1);
	    if (first != last) {
		for (int i = 0; i < n - 1; i++) {
		    sb.append(last);
		}
		for (int i = 0; i < n - 1; i++) {
		    sb.append(first);
		}
	    } else {
		char ch = first == 'E' ? 'S' : 'E';
		int num = 0;
		for (int i = 0; i < moves.length(); i++) {
		    if (moves.charAt(i) == ch) {
			num++;
			if (moves.charAt(i + 1) == ch) {
			    break;
			}
		    }

		}
		for (int i = 0; i < num; i++) {
		    sb.append(ch);
		}
		for (int i = 0; i < n - 1; i++) {
		    sb.append(first);
		}
		for (int i = 0; i < n - 1 - num; i++) {
		    sb.append(ch);
		}
	    }
	    println("Case #" + t + ": " + sb);
	}
    }

    public static void main(String[] args) throws Exception {
	try {
	    fastReader = new FastReader(System.in);
	    systemOut = new BufferedOutputStream(System.out);
	    solve();
	} finally {
	    systemOut.close();
	}
    }

    private static FastReader fastReader = null;
    private static BufferedOutputStream systemOut = null;

    public static void print(Object obj) {
	print(obj.toString());
    }

    public static void print(String str) {
	try {
	    systemOut.write(str.getBytes("utf-8"));
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static void println(Object obj) {
	println(obj.toString());
    }

    public static void println(String str) {
	try {
	    print(str);
	    systemOut.write('\n');
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    public static String next() {
	return fastReader.readNextToken(false);
    }

    public static String nextLine() {
	return fastReader.readNextToken(true);
    }

    public static int nextInt() {
	return Integer.parseInt(fastReader.readNextToken(false));
    }

    public static long nextLong() {
	return Long.parseLong(fastReader.readNextToken(false));
    }

    public static double nextDouble() {
	return Double.parseDouble(fastReader.readNextToken(false));
    }

    public static void exit() {
	try {
	    systemOut.close();
	} catch (IOException e) {
	    // should never happen
	}
	System.exit(0);
    }

    static class FastReader {
	private byte[] buf = new byte[65536];
	private int ind = 0;
	private int maxInd = -1;
	private InputStream is = null;
	private boolean eof = false;
	private boolean lastCharRead = false;

	public FastReader(InputStream is) {
	    this.is = is;
	}

	public String readNextToken(boolean endOfLine) {
	    try {
		StringBuilder sb = new StringBuilder();
		boolean found = false;
		while (true) {
		    if (lastCharRead) {
			return null;
		    } else if (ind > maxInd) {
			if (eof) {
			    lastCharRead = true;
			} else {
			    fillBuffer();
			}
		    }
		    byte b = '\n';
		    if (!lastCharRead) {
			b = buf[ind++];
		    }

		    if (b == '\r') {
			// ignore
		    } else if ((b == '\n' && endOfLine) || (Character.isWhitespace(b) && !endOfLine)) {
			if (found) {
			    break;
			}
		    } else {
			sb.append((char) b);
			found = true;
		    }
		}
		return sb.toString();
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}

	private void fillBuffer() {
	    try {
		int read = is.read(buf, 0, buf.length);
		if (read < buf.length) {
		    eof = true;
		}
		ind = 0;
		maxInd = read - 1;
	    } catch (Exception ex) {
		throw new RuntimeException(ex);
	    }
	}
    }
}
