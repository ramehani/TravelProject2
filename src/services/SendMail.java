package services;
import javax.mail.*;
import javax.mail.internet.*;

//import rezcryptographyservice.cryptobase.ReqResCryptoServiceDispatcher;
import utils.LoadSystemProperties;

import java.security.Security;
import java.util.*;
//import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class SendMail {
  private String SMTPHostRez=null;
  private String fromAddress=null;
  private String toAddress=null;
  private String bccAddress=null;
  private String subject=null;
  private String strMsg=null;
  private boolean mimeBody = false;
  private static Properties _propRez = null;
  private static Session session=null; 	
  private static SendMail instanceRez = null;

  
  private boolean multiRecipient=false;
  private int 	 len=0;
  private String[] toAddresses=null;
  private Address[] addrs= null;
  private static LoadSystemProperties sysProp=null;


	//static String serverSMTPIp=(String)sysProp.getProperty("serverSMTPIp");
	//String MailAuth=(String)sysProp.getProperty("MailAuth");
	//static String SysMode  = (String)sysProp.getProperty("mailLogPath");    //"D:\\weblogs";	=Development

  public static void main(String args[]){
   try{	
   //String[] xmlData=new String[2];
   System.out.println ("********************************1111");
		
	//SendMsgClassRez sndCl = SendMsgClassRez.getInstance("69.20.57.166");
		
   SendMail sndCl = SendMail.getInstance("smtp.gmail.com");
	//SendMsgClassRez sndCl = SendMsgClassRez.getInstance(serverSMTPIp);
		
	
  	System.out.println ("*******************************222");
  	sndCl.setFrom("ramehani@gmail.com");
  	System.out.println ("***********************************333*");
  	sndCl.setTo("ramehani@yahoo.com");	
  	System.out.println ("**********************************444");
  	//sndCl.setBCC("regi@etspl.com");
  	sndCl.setSubject("Hello Test Mail");
  	System.out.println ("**********************************555");
  	sndCl.setMsg("Test mail");
  	System.out.println ("*************************************666");
  	sndCl.setMailType(true);
  	System.out.println ("***************************************77");
  	sndCl.sendRez("ramehani@gmail.com","aluthaha");
  	System.out.println ("*************************************888");
   }catch(Exception err){
    System.out.println(err.toString());	
   }	
  }	
  
  
  protected SendMail(String SMTPHostRez){

		_propRez = new Properties();

	  	Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	   
	  	_propRez.setProperty("mail.transport.protocol","smtp");
	  	_propRez.setProperty("mail.host",SMTPHostRez);
	  	_propRez.put("mail.smtp.auth","true");
	  	_propRez.put("mail.smtp.port","465");
	  	_propRez.put("mail.debug","false");
	  	_propRez.put("mail.smtp.socketFactory.port","465");
	  	_propRez.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	  	_propRez.put("mail.smtp.socketFactory.fallback","false");
	   
//		  sysOs = new PrintStream(System.out);
		try{
		  sysProp=LoadSystemProperties.getInstance(); 	
//		  fout = writeToSMTPFile(true,sysOs,fout);  	
		}catch(Exception er){
		  System.out.println("Error at SendMsgClassRez - ");
		  er.printStackTrace();
		}
		
  }
  
  public static SendMail getInstance(String SMTPHostRez){
  	if (instanceRez==null){
  	  //instanceRez = SendMsgClassRez.getInstance(SMTPHostRez);
  	    instanceRez = new SendMail(SMTPHostRez);
  	}
  	return  instanceRez; 
  }
  
  public void setFrom(String fromAddress) throws Exception{
	  try {
		  String[] strteokenize =  fromAddress.split(":");
		  fromAddress = strteokenize[0];
		}catch (Exception e) {
		 
	  	}
	
  	this.fromAddress = fromAddress;
  }
  
  public void setBCC(String bccAddress) throws Exception{
//  	System.out.println(" bccAddress - "+bccAddress);
  	this.bccAddress = bccAddress;
  }
  
  public void setTo(String toAddress) throws Exception{
  	multiRecipient=false;
//  	System.out.println(" toAddress - "+toAddress);
  	this.toAddress=toAddress;
  }
  
  /*This is to send for multiple email Recipients  */  
  public void setTo(String[] toAddress) throws Exception{
  		multiRecipient=true;
		len=toAddress.length;
		toAddresses =new String[len];
		
	for(int j=0;j<len;j++){
		toAddresses[j]=toAddress[j];
//		System.out.println(" toAddress "+j+" - "+toAddresses[j]);
	}

  }
  
  public void setSubject(String subject) throws Exception{
    this.subject=subject;
//    System.out.println(" Subject - "+subject);
  }
  
  public void setMsg(String strMsg){
    this.strMsg=strMsg;
  }
  
  public void setMailType(boolean mimeBody) throws Exception{
    this.mimeBody=mimeBody;
//    System.out.println(" MailType - "+mimeBody);
  }
  
  public  synchronized void sendRez(String username, String password) throws Exception{
  
	  try {
		  String[] strteokenize =  username.split(":");
		  username = strteokenize[1];
	  	}catch (Exception e) {
		 
	  	}

	  SMTPAuthenticator smtpauthenticator = new SMTPAuthenticator("" + username + "", "" + password + "");
      session = Session.getInstance(_propRez, smtpauthenticator);
      session.setDebug(false);	

      Message msgRez = new MimeMessage(session);
  	  InternetAddress from = new InternetAddress(fromAddress);
      msgRez.setFrom(from);
    System.out.println("test 1");
	    if(multiRecipient){
	 	  addrs = new InternetAddress[len];
		  for(int j=0;j<len;j++){
		    addrs[j]=new InternetAddress(toAddresses[j]);
		  }
		  msgRez.setRecipients(Message.RecipientType.TO,addrs);
	    }else{
	    InternetAddress[] to = {new InternetAddress(toAddress)};
	    msgRez.setRecipients(Message.RecipientType.TO, to);
		}
	    System.out.println("test 2");   
    if(bccAddress!=null){
    	InternetAddress[] bcc = {new InternetAddress(bccAddress)};
    	msgRez.setRecipients(Message.RecipientType.BCC, bcc);
	}
    System.out.println("test 3");
    msgRez.setSubject(subject);
    // messageBodyPart.setContent( messageContent, "text/html; charset=utf-8")
    if(!mimeBody){
     msgRez.setContent(strMsg,"text/html; charset=utf-8");
     msgRez.setDisposition("inline");
    }else{
     Multipart mPart= new MimeMultipart();
     
     MimeBodyPart mbPart = new MimeBodyPart();
     mbPart.setContent(strMsg,"text/html; charset=utf-8");
     mbPart.setDisposition("inline");
     mPart.addBodyPart(mbPart);
     msgRez.setContent(mPart);
     msgRez.saveChanges();
    }
    System.out.println("test 4");
    fromAddress=null;
    toAddress=null;
    bccAddress=null;
    subject=null;   
    toAddresses =null;   
    multiRecipient=false;	
//    Transport.send(msgRez);  
    System.out.println("test 5");
    Transport transport = session.getTransport();
    transport.connect();
    Transport.send(msgRez);
    transport.close();
    fout = writeToSMTPFile(true,sysOs,fout);
    }
  
  private static void writeToLog(String site,String mMsg) throws Exception { //L27	
		java.text.SimpleDateFormat _format = new java.text.SimpleDateFormat("MMM-dd-yyyy");	
		java.text.SimpleDateFormat _format1= new java.text.SimpleDateFormat("MMM-dd-yyyy hh:mm:ss");

		java.util.Date m_Date = new java.util.Date(); 				
		String mailLogPath       = "D:\\Weblogs\\systemlogs\\mailLogs"; 			
		mMsg=_format1.format(m_Date)+"-"+mMsg+"\r\n";
		String logFileName	= ""+mailLogPath+"\\"+_format.format(m_Date)+"_"+site+"_EmailRptX.log";
		FileOutputStream fout = new FileOutputStream(logFileName,true);		
		fout.write(mMsg.getBytes());
		fout.close();
} 
  
 public  synchronized void sendSecureRez(String username, String password) throws Exception{/*
	  
	 try {
		  String[] strteokenize =  username.split(":");
		  username = strteokenize[1];
	  	}catch (Exception e) {
		 
	  	}
	  	
	  SMTPAuthenticator smtpauthenticator = new SMTPAuthenticator("" + username + "", "" + password + "");
      session = Session.getInstance(_propRez, smtpauthenticator);
//	  session = Session.getInstance(_propRez);
     
      session.setDebug(false);
      MimeMessage msgRez = new MimeMessage(session);
      InternetAddress internetaddress = new InternetAddress(fromAddress);
      msgRez.setFrom(internetaddress);
     
      if(multiRecipient)
      {
          addrs = new InternetAddress[len];
          for(int i = 0; i < len; i++)
              addrs[i] = new InternetAddress(toAddresses[i]);

          msgRez.setRecipients(javax.mail.Message.RecipientType.TO, addrs);
      } else
      {
          InternetAddress ainternetaddress[] = {
              new InternetAddress(toAddress)
          };
          msgRez.setRecipients(javax.mail.Message.RecipientType.TO, ainternetaddress);
      }
     
      if(bccAddress != null)
      {
          InternetAddress ainternetaddress1[] = {
              new InternetAddress(bccAddress)
          };
          msgRez.setRecipients(javax.mail.Message.RecipientType.BCC, ainternetaddress1);
      }
      msgRez.setSubject(subject);

      
	    if(!mimeBody){
	    	ReqResCryptoServiceDispatcher reqResCryptoServiceDispatcher = new ReqResCryptoServiceDispatcher();
            try
            {
                
                reqResCryptoServiceDispatcher.setService("ReadEncryptSignPublicKey");
                reqResCryptoServiceDispatcher.setEncryptionType("PGP");
                reqResCryptoServiceDispatcher.setPublicKeyPathFile(sysProp.getProperty("publickeypath").toString());
                reqResCryptoServiceDispatcher.setSigned("N");
                reqResCryptoServiceDispatcher.setWriteFile("Y");
                reqResCryptoServiceDispatcher.setOutputFilePath("d:\\rezgateway-signed-encrypt.asc");
                reqResCryptoServiceDispatcher.setData(strMsg);
                reqResCryptoServiceDispatcher.initService();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            boolean sucess = checkErrors(reqResCryptoServiceDispatcher);
            System.out.println(reqResCryptoServiceDispatcher.getEncryptedMsg());
            if(sucess)
                System.out.println(reqResCryptoServiceDispatcher.getEncryptedMsg());
            strMsg = reqResCryptoServiceDispatcher.getEncryptedMsg();
            msgRez.setContent(strMsg, "text/plain");
            msgRez.setDisposition("inline");
	    }else{
	    	Multipart mPart= new MimeMultipart();
	     	encryptMailUtilities enutility = new encryptMailUtilities();
	     	enutility.setMsg(strMsg);
	     	enutility.encrypt();
	     	
	         mPart.addBodyPart(enutility.getControlPart(), 0);
	         mPart.addBodyPart(enutility.getEncryptedPart(), 1);
	    	
	         System.out.println("hrlsklkl");
	     	 MimeBodyPart mbPart = new MimeBodyPart();
	     	 msgRez.setContent(mPart);
	         System.out.println("helz here also1");
	         msgRez.saveChanges();
	         System.out.println("helz here also2");
	    }
	    fromAddress=null;
	    toAddress=null;
	    bccAddress=null;
	    subject=null;   
	    toAddresses =null;   
	    multiRecipient=false;	
	    
	    Transport transport = session.getTransport();
	    transport.connect();
	    Transport.send(msgRez);
	    transport.close();
	    fout = writeToSMTPFile(false,sysOs,fout);
  	*/}
  
/* private static boolean checkErrors(ReqResCryptoServiceDispatcher reqResCryptoServiceDispatcher)
 {
     boolean check = false;
     if(reqResCryptoServiceDispatcher.getErrorList().size() == 0)
     {
         System.out.println("SUCCESS");
         check = true;
     } else
     {
         System.out.println("FAILED");
         String errorStr;
         for(Iterator iter = reqResCryptoServiceDispatcher.getErrorList().iterator(); iter.hasNext(); System.out.println(errorStr))
             errorStr = (String)iter.next();

         check = false;
     }
     return check;
 }	*/
 
  private FileOutputStream writeToSMTPFile(boolean type,PrintStream os,FileOutputStream fout) throws Exception { //L27	

    if(type){
		java.text.SimpleDateFormat _format = new java.text.SimpleDateFormat("MMM-dd-yyyy");
		java.util.Date m_Date = new java.util.Date(); 					
		String mailLogPath  = (String)sysProp.getProperty("mailLogPath");    //"D:\\weblogs";
		
		String logFileName	= ""+mailLogPath+"\\"+_format.format(m_Date)+"_Emaillog.log";
		fout = new FileOutputStream(logFileName,true);		
		System.setOut(new PrintStream(fout));
		return fout;
    }else{ 
//    	System.out.println ("******************************************");
        System.out.println (" ");
		fout.close();
		System.setOut(os);
//		System.out.println ("**************Closed**************");
		return fout;
    }
   }


  private FileOutputStream fout = null;
  private PrintStream sysOs = null;
  
}
