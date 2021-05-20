package Entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/*
游戏记录类，用于记录游戏产生的数据
/
 */

@XmlRootElement(name="GameRecord")
public class GameRecord {
    @XmlAttribute(name = "Createtime")
    String Createtime;//创建时间
    @XmlAttribute(name = "player")
    String player;//玩家\
    @XmlAttribute(name = "step")
    int step;//步数
    @XmlAttribute(name = "playgame")
    String playgame;//游戏所用时长

    public String getCreatetime() {
        return Createtime;
    }

    public void setCreatetime(String createtime) {
        Createtime = createtime;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getPlaygame() {
        return playgame;
    }

    public void setPlaygame(String playgame) {
        this.playgame = playgame;
    }
}
