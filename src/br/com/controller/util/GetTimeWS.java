package br.com.controller.util;

import java.util.Date;

/**
 *
 * @author gelson
 */
public class GetTimeWS {
    private Date dataServer;

    public GetTimeWS() {
        // TODO get date server
        this.dataServer = new Date();
    }

    public Date getDataServer() {
        return dataServer;
    }
}
