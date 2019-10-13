import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class Helper {
	//e below can be used to fetch OTP from Outlook mail box, similar smtp can be used for the all other mail boxes.

	@SuppressWarnings("null")
	public static String OutlookMailReader(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP) {

	            
	//mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),
	//emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
	            String hostName = "smtp-mail.outlook.com";//change it according to your mail

	            String username = "kapil.goswami@mphasis.com";//username 

	            String password = "India@1986";

	            int messageCount;

	            int unreadMsgCount;

	            String emailSubject;

	            Message emailMessage = null;

	            String searchText=null ;

	            Properties sysProps = System.getProperties();

	            sysProps.setProperty("mail.store.protocol", "imaps");

	            try {

	                Session session = Session.getInstance(sysProps, null);

	                Store store = session.getStore();

	                store.connect(hostName, username, password);

	                Folder emailBox = store.getFolder(mailFolderName);

	                emailBox.open(Folder.READ_WRITE);

	                messageCount = emailBox.getMessageCount();

	                System.out.println("Total Message Count: " + messageCount);
	                //emailSubject = emailMessage.getSubject();
	             // retrieve the messages from the folder in an array and print it
	                Message[] messages = emailBox.getMessages();
	                System.out.println("messages.length---" + messages.length);

	                for (int i = 0, n = messages.length; i < n; i++) {
	                   Message message = messages[i];
	                   System.out.println("---------------------------------");
	                   System.out.println("Email Number " + (i + 1));
	                   //System.out.println();
	                   System.out.println("Subject: " + message.getSubject());
	                   if(message.getSubject().contains(emailSubjectContent))
	                	   
	                   {
	                	   System.out.println("OTP mail found");
	                	   System.out.println("From: " + message.getFrom()[0]);
	                       System.out.println("Text: " + message.getContent().toString());
	                	   String line;

		                    StringBuffer buffer = new StringBuffer();

		                    BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));

		                    while ((line = reader.readLine()) != null) {

		                        buffer.append(line);

		                    }
		                    
//		                    String messageContent=emailContent;
//
//	                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//
//	                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//
//	                        System.out.println("Text found : "+ searchText);

		                    
		                    String messageContent=message.getContent().toString();
		                    String brmessageContent = messageContent.replaceAll("<br>","");
		                    String bmessageContent = messageContent.replaceAll("<b>","");
		                    System.out.println("Text" + bmessageContent);
		                    //System.out.println("Text: " + message.getContent().toString());
		                    String[] arrsplit=bmessageContent.split(":");
		                    for(int k=0;k<arrsplit.length;i++)
		                    {
		                    	System.out.println(arrsplit[2]);
		                    	String rep=arrsplit[2].replaceAll("</b><br>Employee Name","");
		                    	
		                    	System.out.println(rep.trim());
		                    }
		                    

//		                    String result = buffer.toString().substring(buffer.toString().indexOf(brmessageContent));
//
//		                    searchText = result.substring(brmessageContent.length(), messageContent.length()+lengthOfOTP);
//
//		                    System.out.println("Text found : "+ searchText);
//
//		                    emailMessage.setFlag(Flags.Flag.SEEN, true);

		                    break;

		                }
	                   }
//	                   System.out.println("From: " + message.getFrom()[0]);
//	                   System.out.println("Text: " + message.getContent().toString());
//	                   String line;
//
//	                    StringBuffer buffer = new StringBuffer();
//
//	                    BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));
//
//	                    while ((line = reader.readLine()) != null) {
//
//	                        buffer.append(line);
//
//	                    }
//	                    //String messageContent=emailContent;
//	                    String messageContent=message.getContent().toString();
//
//	                    String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//
//	                    searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//
//	                    System.out.println("Text found : "+ searchText);
//
//	                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//	                    break;
//
//	                }
//	                String line;
//
//                    StringBuffer buffer = new StringBuffer();
//
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(message.getInputStream()));
//
//                    while ((line = reader.readLine()) != null) {
//
//                        buffer.append(line);
//
//                    }
//                    //String messageContent=emailContent;
//                    String messageContent=message.getContent().toString();
//
//                    String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//
//                    searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//
//                    System.out.println("Text found : "+ searchText);
//
//                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//                    //break;
//	                
//	                unreadMsgCount = emailBox.getNewMessageCount();
//
//	                System.out.println("Unread Emails count:" + unreadMsgCount);
//
//	                for(int i = 0; i<messageCount ;i--)
//
//	                {
//
//	                    emailMessage = emailBox.getMessage(i);
//
//	                    emailSubject = emailMessage.getSubject();
//
//	                    if(emailSubject.contains(emailSubjectContent))
//
//	                    {
//
//	                        System.out.println("OTP mail found");
//
//	                        
//	                    }
//
//	                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//
//	                }

	                emailBox.close(true);

	                store.close();
	            }

	            catch (Exception mex) 
	            {
	                mex.printStackTrace();

	                System.out.println("OTP Not found ");

	            }

	            return searchText;
}

	        
	public static void main(String[] args)
	{
		Helper.OutlookMailReader("Inbox","(Auto Approved)Transport Ad-hoc request raised","Following are the details of ADHOC",7);
	}

}
