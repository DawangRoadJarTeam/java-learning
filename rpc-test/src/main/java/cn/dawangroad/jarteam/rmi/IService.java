package cn.dawangroad.jarteam.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhiyingyang
 * @version 2018-06-19 12:02
 */
public interface IService extends Remote {
    String queryName(String no) throws RemoteException;
}
