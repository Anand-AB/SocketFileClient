import java.io.OutputStream;
import java.io.File;

import java.net.Socket;


public class Client {
	// host and port of receiver
	private static final int port = 8089;
	private static final String host = "localhost";

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(host, port);
			OutputStream os = socket.getOutputStream();

			int cnt_files = 1;

			// How many files?
			ByteStream.toStream(os, cnt_files);
			ByteStream.toStream(os, "dummy.pdf");
			ByteStream.toStream(os, new File("D:\\source.pdf"));

			os.flush();
			os.close();
			socket.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}