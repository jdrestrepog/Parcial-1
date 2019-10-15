/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import interfaces.CalcInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author juan
 */
public class CalcImplement extends UnicastRemoteObject implements CalcInterface {

    public CalcImplement() throws RemoteException {
    }

    @Override
    public boolean calculate(boolean estado) throws RemoteException {
        if (estado == true) return true;         
        else return false;
    }

}
