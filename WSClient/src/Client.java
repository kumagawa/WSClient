import java.net.URI;
import java.util.concurrent.Future;
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocket.Connection;
import org.eclipse.jetty.websocket.WebSocketClient;
import org.eclipse.jetty.websocket.WebSocketClientFactory;

public class Client {

	public static void main(String[] args) throws Exception {
		WebSocketClientFactory webSocketClientFactory = new WebSocketClientFactory();
		webSocketClientFactory.start();
		WebSocketClient client = webSocketClientFactory.newWebSocketClient();
		Future<Connection> futureConnection =
		    client.open(new URI("ws://localhost:8080/ws/"), new WebSocket.OnTextMessage() {

			@Override
			public void onMessage(String data) {
			}

			@Override
			public void onOpen(Connection connection) {
			}

			@Override
			public void onClose(int closeCode, String message) {
			}
		});
		Connection connection = futureConnection.get();
		connection.sendMessage("Hello, WebSocket!!");
		//connection.disconnect();
	}
}