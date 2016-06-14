

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Timer;


public class Main extends Frame {

	Timer timer = new Timer();		
	ArrayList<String> hotels = new ArrayList<String>();


	public Main() {

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Main test = new Main();
		Gui gui = new Gui();
		test.addHotels();
		String timeStamp = new SimpleDateFormat("HH-mm-ss").format(Calendar.getInstance().getTime());

		JTextArea textAreaLeft = new JTextArea();
		String leftTextAreaText = new String();
		leftTextAreaText = "last checked: " + timeStamp;

		JTextArea textAreaRight = new JTextArea();
		String rightTextAreaText = new String();
		rightTextAreaText = "last checked: " + timeStamp;

		while(true) {
		Document doc = Jsoup.connect("http://www.cyprusparadise.com/north-cyprus-summer-deals").get();
		Elements prices = doc.select("h2");


		
			for(int i = 0; i < prices.size(); i++){
				for(int j = 0; j < test.hotels.size(); j++){
					if(prices.get(i).html().toLowerCase().contains(test.hotels.get(j).toLowerCase())){
						if(prices.get(i).html().toLowerCase().contains("£")) {
							System.out.println(test.hotels.get(j) + " has price");
							leftTextAreaText = leftTextAreaText + "\n" + test.hotels.get(j) + " has price";

						} else {
							System.out.println(test.hotels.get(j) + " MISSING PRICE");
							rightTextAreaText = rightTextAreaText + "\n" + test.hotels.get(j) + " missing price";
						}
					}
				}
			}


			gui.centerPanel.add(textAreaLeft);
			gui.centerPanel.add(textAreaRight);

			textAreaLeft.setText(leftTextAreaText);
			textAreaRight.setText(rightTextAreaText);
			
			
			
			Thread.sleep(5*60*1000);
			timeStamp = new SimpleDateFormat("HH-mm-ss").format(Calendar.getInstance().getTime());
			leftTextAreaText = "last checked: " + timeStamp;
			rightTextAreaText = "last checked: " + timeStamp;
		}
	}



	public boolean checkPrice(String s) {


		return false;
	}

	public void addHotels() {
		hotels.add("Rose Garden Resort");
		hotels.add("Long Beach");
		hotels.add("Riverside Garden");
		hotels.add("Acapulco Beach Resort");
		hotels.add("Pia Bella Hotel");
		hotels.add("Santoria Holiday Village");
		hotels.add("Sammys Hotel");
		hotels.add("Manolya");
		hotels.add("LA Hotel");
		hotels.add("Club Simena Resort");
		hotels.add("Ada Hotel");
		hotels.add("Altinkaya Holiday Resort");
		hotels.add("Bellapais Monastery Village");
		hotels.add("Bella View Boutique Hotel");
		hotels.add("The Colony");
		hotels.add("Malpas Hotel");
		hotels.add("Sempati");
		hotels.add("Le Chateau Lambousa");
		hotels.add("High Life");
		hotels.add("Merit Park Hotel");
		hotels.add("Merit Crystal Cove Hotel");
		hotels.add("Palm Beach Hotel");
		hotels.add("Oscar Resort Hotel");
		hotels.add("Salamis Bay Conti Resort");
		hotels.add("Kaya Artemis Resort");
	}
}
