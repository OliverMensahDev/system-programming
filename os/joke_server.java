import java.net.*;
import java.io.*;
public class joke_server
{
public static void main(String[] args) {
try {
ServerSocket sock = new ServerSocket(9999);
/* now listen for connections */
while (true) {
Socket client = sock.accept();
PrintWriter pout = new
PrintWriter(client.getOutputStream(), true);
//jokes
String jokes[] = {"Johnny", "Hehehe", "Boys dey town", "Chilling be our morale", "You dey wann spoil me self abi","Kwame, meet me there",
"Mum love be the best", "If you dont see us, never mind", "Kappo,are u coming from the chopbar side", "We dey chill saaa"};
//random select
Random rand = new Random();
String currentJoke ;
currentJoke = jokes[rand.nextInt(jokes.length)];
/* write the Date to the socket */
pout.println(currentJoke);
/* close the socket and resume */
/* listening for connections */
client.close();
}
}
}
}
catch (IOException ioe) {
System.err.println(ioe);
}