package Util;

import Entity.GameRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlUtil {
    public static void marshallerByJaxb(String path, GameRecord object) {
        try {
            JAXBContext jc = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头声明信息

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            marshaller.marshal(object, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unmarshallerByJaxb(String path, Object object) {
        try {
            File file = new File(path);
            JAXBContext jc = JAXBContext.newInstance(object.getClass());

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
