package sw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
   
	private int id;
	@NotEmpty(message="密码不能为空")
	@Length(min = 6, message = "密码长度不能小于6位")
	private String password;
	private String email;
	@NotEmpty(message = "用户名不能为空")
	@Length(min = 5, message = "用户名长度不能小于5位")
	private String name;
	private String tel;
	@NotEmpty(message = "验证码不能为空")
	private String valicode;

}
