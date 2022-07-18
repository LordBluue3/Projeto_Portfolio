package com.mikael.model;

import com.mikael.controller.Controller;
import lombok.SneakyThrows;
import org.json.JSONObject;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    /*
     * Qualquer porta entre 0 e 65535.
     * Seu IPV4.
     */
    private String port = "5000";
    private String server = "192.168.15.6";

    JSONObject json = new JSONObject();

    /*
     * Método que tenta conexão com o Server Socket atrávez do server e porta
     * e chama o método que irá realizar ações no servidor.
     */
    @SneakyThrows
    public void connection(JavaBeans javaBeans, HttpServletResponse response){
        // Tentado conexão ao servidor
        Socket socket = new Socket(server, Integer.parseInt(port));
        System.out.println("Conectado ao Server Socket!");
        actions(socket, javaBeans, response);
        System.out.println("Fechando o socket.");
        socket.close();

    }
    /*
     * Método que transforma as váriasveis da class JavaBeans em json,
     * chama os método enviar mensagem, receber mensagem e receber usuarios.
     * Essas mensagens são enviadas e recebidas do server socket
     */
    @SneakyThrows
    public void actions(Socket socket, JavaBeans javaBeans, HttpServletResponse response){
        json.put("email",javaBeans.getEmail());
        json.put("password",javaBeans.getPassword());
        sendMessage(socket);
        getMessage(socket, response);
    }
    /*
     *  Método que envia mensagem para o server socket
     *
     * obtem o fluxo de saída do soquete.
     * cria um fluxo de saída de objeto a partir do fluxo de saída para que possamos enviar um objeto através dele.
     * criando um array.
     * transformando o json em string e adicionando no array.
     * Envia ao Socket a mensagem
     */
    @SneakyThrows
    public void sendMessage(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        List<String> messages = new ArrayList<>();
        messages.add(new String(json.toString()));

        System.out.println("Enviando mensagem ao ServerSocket: ");
        System.out.println(json);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Resultado: ");
        objectOutputStream.writeObject(messages);
    }
    @SneakyThrows
    public  void getMessage(Socket socket,HttpServletResponse response){
        Controller controller = new Controller();
        DataInputStream dus = new DataInputStream(socket.getInputStream());
        String mgs = dus.readUTF();
        String confirma = dus.readUTF();
        System.out.println(mgs);
        if(mgs.equalsIgnoreCase(confirma)) {
            controller.redirecionarLogin(response);
        }else{
            controller.redirecionarErro(response);
        }
    }

}
