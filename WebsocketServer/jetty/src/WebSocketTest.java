/**
 * Created by IntelliJ IDEA.
 * User: Chann
 * Date: 11/23/14
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import javax.servlet.ServletException;

public class WebSocketTest {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8091);
        WebSocketHandler wsHandler = new WebSocketHandler() {
        //MessageSocket wsHandler = new MessageSocket()
            @Override
            public void configure(WebSocketServletFactory factory) {
                //factory.register(MyWebSocketHandler.class); //use this for activemq messages
                factory.register(MyWebSocketHandlerTEST.class);
            }
        };
        server.setHandler(wsHandler);
        server.start();
        server.join();
    }
}