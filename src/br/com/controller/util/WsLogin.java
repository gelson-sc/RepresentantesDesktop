
package br.com.controller.util;
// TODO implementar webservice rest

public class WsLogin {

    public static int authenticate(String username, String password, String mac) {
        int tipoLogon = 0;
        if (username.equals("teste") && password.equals("teste123")) {
            tipoLogon = 1;
        }
        else if (username.equals("teste") && password.equals("teste")) {
            tipoLogon = 2;
        }
        return tipoLogon;
    }
}