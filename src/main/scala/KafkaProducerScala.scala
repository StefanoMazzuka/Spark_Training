import java.util.Properties

import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.KafkaProducer

object KafkaProducerScala {

  def main(args: Array[String]): Unit = {
    producer()
  }

  def producer(): Unit = {
    val producer = createProducer
    for (i <- 0 to 3) {
      var rec = getRecord(i)
      var send = producer.send(rec)
      println(send.get().offset())
    }
  }

  private def getRecord(i: Int): ProducerRecord[String, String] = {
    new ProducerRecord[String, String]("topicA", "1L", "Fu** Scala " + i)
  }

  def createProducer: KafkaProducer[String, String] = {
    val props = new Properties()
    // Lista de brokers a las que podemos llamar
    props.put("bootstrap.servers", "localhost:9092")
    // Los mensajes de kafka son clave valor, y los serializamos con LongSerializer
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    // Serializamos el valor del mensaje con String
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    new KafkaProducer[String, String](props)
  }
}
