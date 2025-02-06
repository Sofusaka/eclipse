package co.edu.upb.songs;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.io.IOException;

import java.net.MalformedURLException;

import java.rmi.Naming;


public class RMIServer {
    private int port;
    public SongArray songs;  
    private final InterfaceSong service;

    public RMIServer(int port, InterfaceSong service) {
        this.service = service;
        this.port = port;
    }
    
    
    public void listening() {
        try {
            LocateRegistry.createRegistry(60);
            try {
                Naming.rebind("//127.0.0.1:60/song", service);
            } catch (RemoteException | MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
}
