package br.com.controller.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import br.com.model.Cliente;
import br.com.model.Usuario;

public class WsLogin {

    public static int authenticate(String username, String password) {
        int tipoLogon = 0;
        
         try {
            SerializarObjetos serializa = new SerializarObjetos();
            Usuario usu = new Usuario();
            usu.setLogin(username);
            usu.setSenha(password);
            String jsonReturn = sendLogin(usu);
            System.out.println(jsonReturn);
            
            String clientes = readField(jsonReturn, "clientes");
            serializa.serializaClientes(clientes);
            String tipoUser = readField(jsonReturn, "tipoUser");
            
            tipoLogon = Integer.parseInt(tipoUser);
            List<Cliente> listaCli = serializa.deserializaClientes();
            
            for (Cliente cliente : listaCli) {
                System.out.println("cliente "+cliente);
            }

        } catch (Exception e) {
        }
        
        return tipoLogon;
    }

    public static String readField(String json, String name) throws IOException {
        if (name != null) {
            ObjectNode object = new ObjectMapper().readValue(json, ObjectNode.class);
            JsonNode node = object.get(name);
            return (node == null ? null : node.textValue());
        }
        return null;
    }

    public static String sendLogin(Usuario usu) {
        String jsonReturn = "";
        try {
            String mac = getMacAdress();
            usu.setMac(mac);
            ClientConfig configuration = new ClientConfig();
            configuration.property(ClientProperties.CONNECT_TIMEOUT, 15000);
            configuration.property(ClientProperties.READ_TIMEOUT, 15000);
            Client client = ClientBuilder.newClient(configuration);
            //Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://192.168.0.15/TesteRepreWS/loginWS.php");
            Form form = new Form();
            form.param("login", usu.getLogin());
            form.param("pass", usu.getSenha());
            form.param("mac", usu.getMac());
            Response response
                    = target.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));

            if (response.getStatus() != 200) {  //200 OK!
                JOptionPane.showMessageDialog(null, "erro na resposta");
            }
            jsonReturn = response.readEntity(String.class);

        } catch (ProcessingException e) {
            JOptionPane.showMessageDialog(null, "Sem conexão com o servidor");
            System.exit(0);
        }
        return jsonReturn;
    }

    public static String getMacAdress() {

        InetAddress ip;
        StringBuilder sb = new StringBuilder();
        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
            }

        } catch (UnknownHostException e) {

            e.printStackTrace();

        } catch (SocketException e) {

            e.printStackTrace();

        }
        return sb.toString();
    }

}
