package sock;

import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	private Socket connSocket;

	public ServerThread(Socket connSocket) {
		this.connSocket = connSocket;
	}

	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());

			String requestLine = inFromClient.readLine();
			System.out.println("Request: " + requestLine);

			String headerLine;
			while ((headerLine = inFromClient.readLine()) != null && headerLine.length() != 0) {
				System.out.println("Header: " + headerLine);
			}

			int responseCode = 200;
			String contentType = "text/html";
			byte[] responseBody = new byte[0];

			if (requestLine != null && requestLine.startsWith("GET")) {
				String[] requestParts = requestLine.split(" ");
				String filePath = requestParts[1].substring(1);

				if (filePath.isEmpty()) {
					filePath = "browser.html";
				}

				try {
					File file = new File(filePath);
					if (file.exists() && !file.isDirectory()) {
						responseBody = readFile(file);
						contentType = getContentType(filePath);
					} else {
						responseCode = 404;
						responseBody = "<html><body><h1>404 Not Found</h1></body></html>".getBytes();
					}
				} catch (IOException e) {
					responseCode = 500;
					responseBody = "<html><body><h1>500 Internal Server Error</h1></body></html>".getBytes();
				}
			} else {
				responseCode = 400;
				responseBody = "<html><body><h1>400 Bad Request</h1></body></html>".getBytes();
			}

			String responseHeaders = "HTTP/1.1 " + responseCode + " OK\r\n" +
					"Content-Type: " + contentType + "\r\n" +
					"Content-Length: " + responseBody.length + "\r\n" +
					"\r\n";

			System.out.println("Response Headers: ");
			System.out.print(responseHeaders);

			if (contentType.equals("text/html")) {
				System.out.println("Response Body: ");
				System.out.println(new String(responseBody));
			}

			outToClient.writeBytes(responseHeaders);
			outToClient.write(responseBody);

			connSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private byte[] readFile(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			return fis.readAllBytes();
		}
	}

	private String getContentType(String filePath) {
		if (filePath.endsWith(".html")) {
			return "text/html";
		} else if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) {
			return "image/jpeg";
		} else if (filePath.endsWith(".png")) {
			return "image/png";
		} else if (filePath.endsWith(".css")) {
			return "text/css";
		} else if (filePath.endsWith(".js")) {
			return "application/javascript";
		} else {
			return "application/octet-stream";
		}
	}
}