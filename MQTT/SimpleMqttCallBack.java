import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONObject;
public class SimpleMqttCallBack implements MqttCallback {
    int status = 0;
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    private boolean isFanOn = false;

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String res = new String(mqttMessage.getPayload());

        if (res.contains("AM2301")) {
            JSONObject jsonObject = new JSONObject(res);
            JSONObject sensorData = jsonObject.getJSONObject("AM2301");
            double temperature = sensorData.getDouble("Temperature");
            double humidity = sensorData.getDouble("Humidity");
            System.out.println("Temperature: " + temperature + "°C, Humidity: " + humidity + "%");

            if (humidity > 50 && !isFanOn) {
                System.out.println("humidity too high, turning on fan");
                turnOnFan();
                isFanOn = true;
            } else if (humidity <= 50 && isFanOn) {
                System.out.println("Humidity too low turning off fan.");
                turnOffFan();
                isFanOn = false;
            }
        } else if (res.contains("POWER")) {
            JSONObject jsonObject = new JSONObject(res);
            String powerState = jsonObject.getString("POWER");
            System.out.println("Received fan state: " + powerState);
            isFanOn = "ON".equalsIgnoreCase(powerState);
        }
    }


    public void turnOnFan()
    {
        String broker = "tcp://192.168.0.115:1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker,  MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.setCallback(new SimpleMqttCallBack());
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            publishMessage(sampleClient, "cmnd/grp3254/Power1", "1");
            sampleClient.disconnect();
            System.out.println("Turn on fan Disconnected");
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();

        }
    }

    public void  publishMessage(MqttClient sampleClient,String topicsend,String content) throws MqttPersistenceException, MqttException {
        // Laver en publish p  sampleClient med topic topicsend og indhold content.
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        System.out.println(content.getBytes());
        sampleClient.publish(topicsend, message);
        System.out.println("Message published");
    }

    public void turnOffFan()
    {
        String broker = "tcp://192.168.0.115:1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            MqttClient sampleClient = new MqttClient(broker,  MqttClient.generateClientId(), persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.setCallback(new SimpleMqttCallBack());
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            publishMessage(sampleClient, "cmnd/grp3254/Power1", "0");
            sampleClient.disconnect();
            System.out.println("Turn off fanDisconnected");
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();

        }
    }


    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
}