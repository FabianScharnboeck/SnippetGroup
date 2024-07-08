//XYPHER//


import java.io.*;
import java.util.InputMismatchException;

class U_CubicUfo_Solution_24464 {
	static class point{
		double x;
		double y;
		double z;
		point(double x,double y,double z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		
		Reader a= new Reader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		//Scanner a = new Scanner(System.in);
			
			
				int t = a.nextInt();
				int q=1;
				while(t-->0){
				
					out.println("Case #"+q+":" );
					double area = a.nextDouble();
					double theta = Math.acos(1/Math.sqrt(2)) - Math.acos(area/Math.sqrt(2));
					//out.println(theta + " "+area);
					point[] A = new point[6];
					for(int i=0;i<6;i++){
						A[i] = new point(0,0,0);
					}
						A[0].x = -0.5;
					    A[0].y = 0.5;
					    
						A[1].x = -0.5;
						A[1].y = 0.5;
						
						A[2].x = 0.5;
						A[2].y = 0.5;
						
						A[3].x = 0.5;
						A[3].y = 0.5;
						
						A[4].x = 0.5 ;
						A[4].y = -0.5;
						
						A[5].x = 0.5;
						A[5].y = -0.5;
																	    
					for(int i=0;i<6;i++){
						double y = A[i].y;
						double x = A[i].x;
						A[i].x = x*Math.cos(theta) - y*Math.sin(theta);
						A[i].y = x*Math.sin(theta) + y*Math.cos(theta);
					//	out.println(A[i].x+" "+A[i].y+"asdasdasd");
					}
					point[] ans = new point[3];
					for(int i=0;i<3;i++){
						ans[i] = new point(0,0,0);
					}
					ans[1].x = (A[0].x+A[1].x+A[2].x+A[3].x)/4;
					ans[1].y = (A[0].y+A[1].y+A[2].y+A[3].y)/4;
					ans[1].z = 0;
					
					ans[0].x = (A[4].x+A[5].x+A[2].x+A[3].x)/4;
					ans[0].y = (A[4].y+A[5].y+A[2].y+A[3].y)/4;
					ans[0].z = 0;
					
					ans[2].x = 0;
					ans[2].y = 0;
					ans[2].z = 0.5;
					for(int i=0;i<3;i++){
						out.println(ans[i].x+" "+ans[i].y+" "+ans[i].z);
					}
					q++;
				}
    }
	

//--------------------------FAST IO-------------------------------------------------//
	private static class Reader {
		private InputStream stream;
		private byte[] buf = new byte[4*1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public Reader(InputStream stream) {
			this.stream = stream;
		}
		
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public String nextString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		
		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		
		public String next() {
			return nextString();
		}
		
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
	private static class OutputWriter {
		private final PrintWriter writer;
		
		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		
		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}
		
		
		
		public void println(Object... objects) {
			print(objects);
			writer.println();
			writer.flush();
		}
		
		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0) {
					writer.print(' ');
				}
				writer.print(objects[i]);
			}
			writer.flush();
		}
		
		public void close() {
			writer.close();
		}
		
		public void flush() {
			writer.flush();
		}
	}
} 