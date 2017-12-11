package sw.model;

import java.util.List;

import lombok.Data;

@Data
public class MThread {
	private Integer id;
	private String threatName;
	private Float frequency;//发生频率
	private List<MWeakness> weaknessList;
}
