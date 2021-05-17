package Entity;

import lombok.Data;

/*
游戏记录类，用于记录游戏产生的数据
/
 */
@Data
public class GameRecord {
    String Createtime;//创建时间
    String player;//玩家
    int step;//步数
    String playgame;//游戏所用时长

}
