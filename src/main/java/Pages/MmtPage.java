package Pages;

public class MmtPage {

	public static String from = "//*[@for=\"fromCity\"]";
	public static String to = "//*[@for=\"toCity\"]";
	public static String search = "//*[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"]";
	public static String departure = "//*[@class=\"sortby-dom-sctn departure_sorter \"]";
	public static String airlineName = "//*[@class=\"boldFont blackText airlineName\"]";
	public static String airlinePrice = "//*[@class=\"blackText fontSize18 blackFont white-space-no-wrap\"]";

	public static String emailId = "//*[@id=\"mail\"]";
	public static String copyButton = "(//*[@data-clipboard-action=\"copy\"])[2]";
	public static String viewMail="(//*[@class=\"arrow-link-ico\"])[2]";
	
	public static String tempFromMailId = "(//*[@class=\"from-email\"])";
	public static String tempMailSubject= "(//*[@class=\"user-data-subject\"])/h4";
	public static String tempMailMessge= "(//*[@class=\"inbox-data-content-intro\"])/p";
	
	//GmailDet
	public static String compose= "//*[@class=\"T-I T-I-KE L3\"]";
	public static String toSend = "//*[@id=\":1f3\"]";
	public static String subject= "//*[@name=\"subjectbox\"]";
	public static String contentMessage ="//*[@class=\"Ar Au\"]";
	public static String sendButton ="//*[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]";


}
