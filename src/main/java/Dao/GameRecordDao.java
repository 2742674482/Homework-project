package Dao;

import Entity.GameRecord;
import Util.XmlUtil;

import javax.xml.bind.JAXBException;


public class GameRecordDao {
    public void InputGameRecord(GameRecord gameRecord) throws JAXBException{

        XmlUtil.marshallerByJaxb( "xml/GameRecord.xml", gameRecord);
    }
}
