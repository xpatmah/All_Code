package com.org.bits.webNMS.domain.maps;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.webnms.response.NE;

public class ALLInfo {

	public static final HashMap<String, Socket> ipSocketMap = new HashMap<String, Socket>();
	
	public static final  HashMap<String, PrintWriter> outPutStreamMap = new HashMap<String, PrintWriter>();
	
	public static final  HashMap<String, ObjectInputStream> inputStreamMap = new HashMap<String, ObjectInputStream>();
	
	public static final  List<NE> neList = new ArrayList<NE>();
	
	public static String getEncryptedString(String password){
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] psssBytes = password.getBytes();
			md.reset();
			byte[] digestedBytes = md.digest(psssBytes);
			
            for(int db=0 ;db<digestedBytes.length;db++){
            sb.append(Integer.toHexString(0xff & digestedBytes[db]));	
            }			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
