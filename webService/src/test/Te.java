package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Te {

	/**
	 * @param args
	 * @throws ServiceException 
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
		String targetEendPoint =  "http://localhost:8080/webService/services/HelloWorld?wsdl" ;   
		Service service =  new  Service();   
		Call call = (Call) service.createCall();   
		call.setTargetEndpointAddress( new  URL(targetEendPoint));   
		  
		call.setOperationName( new  QName(targetEendPoint,  "hello" ));//方法名        
		String result = (String) call.invoke( new  Object[]{ "dog" }); //参数  
		System.out.println(result);   
		  
		call.setOperationName( new  QName(targetEendPoint,  "add" )); //方法名  
		Integer res = (Integer) call.invoke( new  Object[]{  3 ,  2 }); //参数  
		System.out.println( "The result is: "  + res);  
	}

}
