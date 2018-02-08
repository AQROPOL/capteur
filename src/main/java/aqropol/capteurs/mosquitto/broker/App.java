package aqropol.capteurs.mosquitto.broker;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class App {
  public static void main( String[] args ) {

		try {
  		System.out.println("== STARTING PUBLISHER ==");

			MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
			client.connect();
			MqttMessage message = new MqttMessage();
			message.setPayload("Hello World !".getBytes());
			client.publish("capteur", message);

			System.out.println("Message 'Hello World !' send to 'capteur' topic");

			client.disconnect();

			System.out.println("== PUBLISHER STOP");
		} catch(MqttException e) {
			e.printStackTrace();	
		}
	}
}
