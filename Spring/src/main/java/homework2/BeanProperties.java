package homework2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * xml 实现bean装配
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanProperties {

    private Integer age;

    private String gender;

    private String name;

}
