package cm.xxx.minos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-23 00:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryCondition {

    private String username;

    private int age;

    private int ageTo;

    private String xxx;

}
